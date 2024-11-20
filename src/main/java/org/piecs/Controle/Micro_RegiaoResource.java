package org.piecs.Controle;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;

import java.util.Iterator;

@Path("T_PIECS_MICRO_REGIAO")
public class Micro_RegiaoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public Response getMicro_Regiao(
        @PathParam("pages") int pages,
        @QueryParam("pageSize") int pageSize)
    {}




}


