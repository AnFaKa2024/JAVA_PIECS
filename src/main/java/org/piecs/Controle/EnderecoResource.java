package org.piecs.Controle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_ENDERECO;
import org.piecs.Repositorio.RepositorioEndereco;

import java.util.List;

@Path("T_PIECS_ENDERECO")
public class EnderecoResource {

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEnderecos(T_PIECS_ENDERECO novoEndereco) {

        RepositorioEndereco repositorio = new RepositorioEndereco();
        repositorio.Adicionar(novoEndereco);
        return Response.status(Response.Status.CREATED).entity(novoEndereco).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public List<T_PIECS_ENDERECO> getEnderecos() {

        RepositorioEndereco repositorio = new RepositorioEndereco();
        return repositorio.Listar();
    }

    @DELETE
    @Path("{id}")
    public Response deleteEndereco(@PathParam("id") String id) {

        RepositorioEndereco repositorio = new RepositorioEndereco();
        repositorio.Delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<T_PIECS_ENDERECO> searchEndereco(@QueryParam("descricao") String descricao) {
        
        RepositorioEndereco repositorio = new RepositorioEndereco();
        return repositorio.SearchByDescription(descricao);
    }
}
