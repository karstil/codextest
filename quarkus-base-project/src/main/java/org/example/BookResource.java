package org.example;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public Uni<List<Book>> list() {
        return Book.listAll();
    }

    @GET
    @Path("{id}")
    public Uni<Book> get(@PathParam("id") Long id) {
        return Book.findById(id);
    }

    @POST
    public Uni<Book> add(Book book) {
        return book.persist().replaceWith(book);
    }

    @PUT
    @Path("{id}")
    public Uni<Book> update(@PathParam("id") Long id, Book bookData) {
        return Book.<Book>findById(id)
                .invoke(entity -> {
                    if (entity != null) {
                        entity.title = bookData.title;
                        entity.author = bookData.author;
                    }
                });
    }

    @DELETE
    @Path("{id}")
    public Uni<Boolean> delete(@PathParam("id") Long id) {
        return Book.deleteById(id);
    }
}
