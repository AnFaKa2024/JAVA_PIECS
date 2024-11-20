package org.piecs.Controle;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

@Path("T_PIECS_RESPONSAVEL")
public class ResponsavelResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public Response getResponsavel(
        @PathParam("pages") int pages,
        @QueryParam("pageSize") int pageSize)
    {}


}
