package org.piecs.Controle;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

import java.util.List;

@Path("T_PIECS_RESPONSAVEL")
public class ResponsavelResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public Response getResponsavel(
        @PathParam("pages") int pages,
        @QueryParam("pageSize") int pageSize)
    {}


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<T_PIECS_RESPONSAVEL> searchResponsavel(
            @QueryParam("Nome") String nome,
            @QueryParam("CPF_CNPJ") String cpf_cnpj)
    {}


    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addResponsavel(Responsavel novoResponsavel){}


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateResponsavel(@PathParam("id") int id, Responsavel novoResponsavel){}


    @DELETE
    @Path("{id}")
    public void deleteResponsavel(@PathParam("id") int id){
        responsaveis.remove(responsavel -> responsavel.getId() == id);
    }


}
