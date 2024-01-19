package com.microservices.number;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.time.Instant;
import java.util.Random;

@Path("api/numbers")
public class NumberResource {
    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")

    public String hello() {
        return "Hello numbers from RESTEasy Reactive";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public IsbnNumbers generateIsbnNumbers(){

        logger.info("Generating isbn numbers");
        IsbnNumbers isbn = new IsbnNumbers(
                "13-"+new Random().nextLong(10000000000L,99999999999L),
                "10-"+ new Random().nextLong(10000000L,99999999L),
                Instant.now()
        );
        logger.info("Generated numbers: "+ isbn.toString());

        return isbn;
    }
}
