package com.microservices.book;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;


@Path("/api/books")
public class BookResource {
    @Inject
    Logger logger;
    @RestClient
    NumberProxy proxy;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "fallingBackOnCreatingABook")
    public Response createBook(Book bookRequest){
        logger.info("book that is coming: "+ bookRequest);
        Book book = new Book(bookRequest.title, bookRequest.author, bookRequest.yearOfPublication, bookRequest.genre,  bookRequest.creationDate, proxy.generateIsbnNumbers().isbn13);
        logger.info("The book was created: "+ book);
        return Response.status(201).entity(book).build();
    }


    public Response fallingBackOnCreatingABook(Book bookRequest){
        logger.warn("falling back method: "+ bookRequest);
        Book book = new Book(bookRequest.title, bookRequest.author, bookRequest.yearOfPublication, bookRequest.genre,  bookRequest.creationDate, "Will be set later");


        saveOnDisc(book);
        return Response.status(206).entity(book).build();
    }

    public void saveOnDisc(Book book){
        String jsonBook = JsonbBuilder.create().toJson(book);
    }
}
