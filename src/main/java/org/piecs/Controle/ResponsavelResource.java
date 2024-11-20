package org.piecs.Controle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("T_PIECS_RESPONSAVEL")
public class ResponsavelResource {

    private List<T_PIECS_RESPONSAVEL> responsaveis = new ArrayList<>(); // Simulação de um repositório

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{id}")
    public Response getResponsavel(
        @PathParam("id") String id)
    {
        Optional<T_PIECS_RESPONSAVEL> responsavelEncontrado = responsaveis.stream()
            .filter(r -> r.getId().equals(id))
            .findFirst();

        if (responsavelEncontrado.isPresent()) {
            return Response.ok(responsavelEncontrado.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<T_PIECS_RESPONSAVEL> searchResponsavel(
            @QueryParam("Nome") String nome,
            @QueryParam("CPF_CNPJ") String cpf_cnpj)
    {
        return responsaveis.stream()
            .filter(r -> (nome == null || r.getNm_cliente().equalsIgnoreCase(nome)) &&
                          (cpf_cnpj == null || r.getCpf_cnpj().equals(cpf_cnpj)))
            .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addResponsavel(T_PIECS_RESPONSAVEL novoResponsavel) {
        // Validação simples
        if (novoResponsavel.getNm_cliente() == null || novoResponsavel.getCpf_cnpj() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        responsaveis.add(novoResponsavel); // Adiciona o novo responsável
        return Response.status(Response.Status.CREATED).entity(novoResponsavel).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateResponsavel(@PathParam("id") String id, T_PIECS_RESPONSAVEL novoResponsavel) {
        Optional<T_PIECS_RESPONSAVEL> responsavelExistente = responsaveis.stream()
            .filter(r -> r.getId().equals(id))
            .findFirst();

        if (responsavelExistente.isPresent()) {
            // Atualiza os dados do responsável
            T_PIECS_RESPONSAVEL responsavel = responsavelExistente.get();
            responsavel.setNm_cliente(novoResponsavel.getNm_cliente());
            responsavel.setCpf_cnpj(novoResponsavel.getCpf_cnpj());
            // Atualize outros campos conforme necessário
            return Response.ok(responsavel).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteResponsavel(@PathParam("id") String id) {
        boolean removed = responsaveis.removeIf(r -> r.getId().equals(id));

        if (removed) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
