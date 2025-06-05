package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import io.smallrye.mutiny.Uni;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    @GET
    public Uni<List<Fruit>> list() {
        return Fruit.listAll();
    }

    @POST
    public Uni<Fruit> add(Fruit fruit) {
        return fruit.persist().replaceWith(fruit);
    }
}
