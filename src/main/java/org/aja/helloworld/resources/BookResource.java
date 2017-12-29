package org.aja.helloworld.resources;

import org.aja.helloworld.api.BookRequest;
import org.aja.helloworld.api.BookResponse;
import org.aja.helloworld.jdbi.BookDao;
import org.aja.helloworld.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private Logger log = LoggerFactory.getLogger("HelloWorldResource");
    //private List<Book> books = new ArrayList<>();
    private BookDao dao;

    public BookResource(BookDao dao) {
        this.dao = dao;
    }

    public BookResource() {
        /*Book a = new Book("apa", "2000", 1);
        Book b = new Book("baboon", "2001", 2);
        books.add(a);
        books.add(b);*/
    }

    @GET
    @Path("plain")
    public Response readAll() {
       log.info("readAll");

       List<Book> books = dao.readAll();

        final Collection<BookResponse> bookResponses =
                books.stream().map(this::convertModeltoApi).collect(Collectors.toList());

        return Response.ok(bookResponses).build();
    }

    @GET
    @Path("plain/{id}")
    public Response get(@PathParam("id") Integer id) {
        log.info("read {}", id);
       // Book book = books.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        Book book = dao.read(id);
        return Response.ok(convertModeltoApi(book)).build();
    }

    @POST
    @Valid
    @Path("plain")
    public Response add(BookRequest book) {
        log.info("add {}", book.toString());
        Book b = getLastIndex(book);
        dao.insert(b);
        return Response.ok().build();
    }

    @DELETE
    @Path("plain/{id}")
    public Response delete(@PathParam("id") Integer id) {
        log.info("delete {}", id);
       // Book book = books.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        dao.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("plain/{id}")
    public Response update(@PathParam("id") Integer id, BookRequest book) {
        log.info("update {} {}", id , book.toString());
        /*Book b = books.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        books.remove(b);
        books.add(new Book(book.getTitle(), book.getPublished(), id));*/
        dao.update(new Book(book.getTitle(), book.getPublished(), id));
        return Response.noContent().build();
    }

    private Book getLastIndex(BookRequest book) {
        Integer id = dao.readAll().stream().mapToInt(Book::getId).max().getAsInt();
        //Integer id = books.stream().mapToInt(Book::getId).max().getAsInt();
        return new Book(book.getTitle(), book.getPublished(), id+1);
    }

    private BookResponse convertModeltoApi(Book book) {
        return  new BookResponse(book.getTitle(), book.getPublished(), book.getId());
    }
}
