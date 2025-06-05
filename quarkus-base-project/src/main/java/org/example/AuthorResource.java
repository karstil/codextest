package org.example;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @GET
    public Uni<List<Author>> list() {
        return Author.listAll();
    }

    @GET
    @Path("{id}")
    public Uni<Author> get(@PathParam("id") Long id) {
        return Author.findById(id);
    }

    @POST
    public Uni<Author> add(Author author) {
        return author.persist().replaceWith(author);
    }

    @PUT
    @Path("{id}")
    public Uni<Author> update(@PathParam("id") Long id, Author authorData) {
        return Author.<Author>findById(id)
                .invoke(entity -> {
                    if (entity != null) {
                        entity.name = authorData.name;
                        entity.address = authorData.address;
                    }
                });
    }

    @DELETE
    @Path("{id}")
    public Uni<Boolean> delete(@PathParam("id") Long id) {
        return Author.deleteById(id);
    }
}
