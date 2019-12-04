package org.aja.helloworld.resources;

import org.aja.helloworld.core.WordCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/translate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PersianResource {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final TranslateService translateService;
    private final WordCache wordCache;

    public PersianResource(TranslateService translateService, WordCache wordCache) {
        this.translateService = translateService;
        this.wordCache = wordCache;
    }

    @GET
    @Path("/persian/{word}")
    public Response getSwedish(@PathParam("word") String word) {
        log.info("word {}", word);
        return Response.ok(translateService.getSwedishWord(word)).build();
    }

    @GET
    @Path("/swedish/{word}")
    public Response getPersian(@PathParam("word") String word) {
        log.info("word {}", word);
        return Response.ok(wordCache.getPersianWord(word)).build();
    }

    @GET
    public Response getPersian() {
        log.info("word");
        return Response.ok(translateService.getAllWords()).build();
    }


    @GET
    @Path("/count/")
    public Response count() {
        return Response.ok(new Count(translateService.getCount())).build();
    }
}
