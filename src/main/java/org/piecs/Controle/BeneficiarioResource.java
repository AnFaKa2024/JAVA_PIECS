package org.piecs.Controle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Repositorio.RepositorioBeneficiario;

import java.util.List;

@Path("T_PIECS_BENEFICIARIOS")
public class BeneficiarioResource {

    private RepositorioBeneficiario repositorio = new RepositorioBeneficiario();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public List<T_PIECS_BENEFICIARIOS> getBeneficiarios(
            @PathParam("responsavel") String responsavelId,
            @QueryParam("pageSize") int pageSize) {

        return repositorio.ListarPorResponsavel(responsavelId, pageSize);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public T_PIECS_BENEFICIARIOS searchBeneficiarios(@QueryParam("id") String id) {

        T_PIECS_BENEFICIARIOS beneficiario = repositorio.GetById(id);
        if (beneficiario == null) {
            throw new NotFoundException("Beneficiário não encontrado com ID: " + id);
        }
        return beneficiario;
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBeneficiarios(T_PIECS_BENEFICIARIOS novoBeneficiario) {

        if (novoBeneficiario.getNm_beneficiario() == null || novoBeneficiario.getEmail() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Nome e email são obrigatórios.").build();
        }
        repositorio.Adicionar(novoBeneficiario);
        return Response.status(Response.Status.CREATED).entity(novoBeneficiario).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBeneficiarios(@PathParam("id") String id, T_PIECS_BENEFICIARIOS beneficiariosAtualizados) {

        T_PIECS_BENEFICIARIOS beneficiarioExistente = repositorio.GetById(id);
        if (beneficiarioExistente == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Beneficiário não encontrado com ID: " + id).build();
        }
        beneficiariosAtualizados.setId(id);
        repositorio.UpDate(beneficiariosAtualizados);
        return Response.status(Response.Status.OK).entity(beneficiariosAtualizados).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBeneficiarios(@PathParam("id") String id) {

        T_PIECS_BENEFICIARIOS beneficiarioExistente = repositorio.GetById(id);
        if (beneficiarioExistente == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Beneficiário não encontrado com ID: " + id).build();
        }
        repositorio.Delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
