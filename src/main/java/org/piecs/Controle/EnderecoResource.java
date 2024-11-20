package org.piecs.Controle;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_ENDERECO;

import java.util.List;

@Path("T_PIECS_ENDERECO")
public class EnderecoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public List<T_PIECS_ENDERECO> getEnderecos(
            @PathParam("pages") int pages,
            @QueryParam("pageSize") int pageSize)
    {}


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<T_PIECS_ENDERECO> searchEndereco(
            @QueryParam("descricao") String descricao)
    {}

    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEnderecos(Enderecos novoEndereco){}


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEnderecos(@PathParam("id") int id, Enderecos enderecoAtualizado){}


    @DELETE
    @Path("{id}")
    public void deleteBeneficiario(@PathParam("id") int id){
        beneficiarios.remove(beneficiarios -> beneficiarios.getId() == id);
    }


}
