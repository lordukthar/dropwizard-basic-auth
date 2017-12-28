package org.aja.helloworld.resources;

import io.dropwizard.hibernate.UnitOfWork;
import org.aja.helloworld.api.Book;
import org.aja.helloworld.api.BookIn;
import sun.security.krb5.internal.crypto.RsaMd5CksumType;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    List<Book> books = new ArrayList<>();

    public HelloWorldResource() {
        Book a = new Book("apa", "2000", 1);
        Book b = new Book("baboon", "2001", 2);
        books.add(a);
        books.add(b);
    }

    @GET
    @Path("plain")
    public Response readAll() {
       return Response.ok( books).build();
    }

    @GET
    @Path("plain/{id}")
    public Response get(@PathParam("id") Integer id) {
        Book book = books.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        return Response.ok(book).build();
    }

    @POST
    @Valid
    @Path("plain")
    public Response add(BookIn book) {
        books.add(transformBookIn(book));
        return Response.ok().build();
    }

    @DELETE
    @Path("plain/{id}")
    public Response delete(@PathParam("id") Integer id) {
        System.out.println("delete");
        Book b = books.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        books.remove(b);
        return Response.ok().build();
    }

    @PUT
    @Path("plain/{id}")
    public Response update(@PathParam("id") Integer id, BookIn book) {
        System.out.println("update");
        Book b = books.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        books.remove(b);
        books.add(new Book(book.getTitle(), book.getPublished(), id));
        return Response.noContent().build();
    }

    private Book transformBookIn(BookIn book) {

        Integer id = books.stream().mapToInt(Book::getId).max().getAsInt();

        return new Book(book.getTitle(), book.getPublished(), id+1);
    }
}
