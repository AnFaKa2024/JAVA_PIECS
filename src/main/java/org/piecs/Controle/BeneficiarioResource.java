package org.piecs.Controle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;

import java.util.List;


@Path("T_PIECS_BENEFICIARIOS")
public class BeneficiarioResource {


    private static final Object beneficiariosAtualizados = null;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public List<T_PIECS_BENEFICIARIOS> getBeneficiarios(
        @PathParam("pages") int pages,
        @QueryParam("pageSize") int pageSize)
    {}


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<T_PIECS_BENEFICIARIOS> searchBeneficiarios(
            @QueryParam("id") int id)
    {}

    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBeneficiarios(Beneficiarios novoBeneficiario){}


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBeneficiarios(@PathParam(
            ("id") int id, Beneficiarios beneficiariosAtualizados)
    {}


    @DELETE
    @Path("id")
    public void deleteBeneficiarios (@PathParam("id") int id){
        beneficiarios.remove(beneficiario -> beneficiario.getId() == id);
    }


}
