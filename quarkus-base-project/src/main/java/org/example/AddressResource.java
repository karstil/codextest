package org.example;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @GET
    public Uni<List<Address>> list() {
        return Address.listAll();
    }

    @GET
    @Path("{id}")
    public Uni<Address> get(@PathParam("id") Long id) {
        return Address.findById(id);
    }

    @POST
    public Uni<Address> add(Address address) {
        return address.persist().replaceWith(address);
    }

    @PUT
    @Path("{id}")
    public Uni<Address> update(@PathParam("id") Long id, Address addressData) {
        return Address.<Address>findById(id)
                .invoke(entity -> {
                    if (entity != null) {
                        entity.street = addressData.street;
                        entity.city = addressData.city;
                        entity.country = addressData.country;
                    }
                });
    }

    @DELETE
    @Path("{id}")
    public Uni<Boolean> delete(@PathParam("id") Long id) {
        return Address.deleteById(id);
    }
}
