package org.piecs.Controle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Repositorio.RepositorioBeneficiario;

import java.util.List;

@Path("T_PIECS_BENEFICIARIOS")
public class BeneficiarioResource {

    private RepositorioBeneficiario repositorio = new RepositorioBeneficiario(); // Inicializando o repositório

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public List<T_PIECS_BENEFICIARIOS> getBeneficiarios(
        @PathParam("responsavel") String responsavelId,
        @QueryParam("pageSize") int pageSize) {
        // Lógica para buscar beneficiários com base no ID do responsável
        return repositorio.ListarPorResponsavel(responsavelId, pageSize); // Chama o método do repositório
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public T_PIECS_BENEFICIARIOS searchBeneficiarios(
            @QueryParam("id") String id) {
        // Lógica para buscar beneficiário por ID
        T_PIECS_BENEFICIARIOS beneficiario = repositorio.GetById(id); // Chama o método do repositório
        if (beneficiario == null) {
            throw new NotFoundException("Beneficiário não encontrado com ID: " + id);
        }
        return beneficiario; // Retorna o beneficiário encontrado
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBeneficiarios(T_PIECS_BENEFICIARIOS novoBeneficiario) {
        // Lógica para adicionar um novo beneficiário
        if (novoBeneficiario.getNm_beneficiario() == null || novoBeneficiario.getEmail() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Nome e email são obrigatórios.").build();
        }
        repositorio.Adicionar(novoBeneficiario);
        return Response.status(Response.Status.CREATED).entity(novoBeneficiario).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBeneficiarios(@PathParam("id") String id, T_PIECS_BENEFICIARIOS beneficiariosAtualizados) {
        // Lógica para atualizar um beneficiário existente
        T_PIECS_BENEFICIARIOS beneficiarioExistente = repositorio.GetById(id);
        if (beneficiarioExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Beneficiário não encontrado com ID: " + id).build();
        }
        beneficiariosAtualizados.setId(id); // Definindo o ID do beneficiário atualizado
        repositorio.UpDate(beneficiariosAtualizados);
        return Response.status(Response.Status.OK).entity(beneficiariosAtualizados).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBeneficiarios(@PathParam("id") String id) {
        // Lógica para deletar um beneficiário
        T_PIECS_BENEFICIARIOS beneficiarioExistente = repositorio.GetById(id);
        if (beneficiarioExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Beneficiário não encontrado com ID: " + id).build();
        }
        repositorio.Delete(id);
        return Response.status(Response.Status.NO_CONTENT).build(); // Retorna 204 No Content após a exclusão
    }
}
