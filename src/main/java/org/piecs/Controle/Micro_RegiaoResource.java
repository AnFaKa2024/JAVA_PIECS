package org.piecs.Controle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("T_PIECS_MICRO_REGIAO")
public class Micro_RegiaoResource {

    private List<T_PIECS_MICRO_REGIAO> micro_regioes = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{page}")
    public Response getMicro_Regiao(
            @PathParam("page") int pages,
            @QueryParam("pageSize") int pageSize) {

        List<T_PIECS_MICRO_REGIAO> microRegioes = micro_regioes.stream()
                .skip((pages - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

        return Response.ok(microRegioes).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<T_PIECS_MICRO_REGIAO> searchMicro_Regiao(
            @QueryParam("Qt_placas") int qt_placas,
            @QueryParam("Qt_baterias") int qt_baterias) {

        List<T_PIECS_MICRO_REGIAO> resultados = micro_regioes.stream()
                .filter(micro_regiao -> micro_regiao.getQt_placa() == qt_placas && micro_regiao.getQt_bateria() == qt_baterias)
                .collect(Collectors.toList());

        return resultados;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMicro_Regiao(T_PIECS_MICRO_REGIAO novaMicro_Regiao) {
        if (novaMicro_Regiao == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Micro Região não pode ser nula").build();
        }
        micro_regioes.add(novaMicro_Regiao);
        return Response.status(Response.Status.CREATED).entity(novaMicro_Regiao).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteMicro_Regiao(@PathParam("id") String id) {
        boolean removed = micro_regioes.removeIf(micro_regiao -> micro_regiao.getId().equals(id));
        if (removed) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Micro Região não encontrada").build();
        }
    }
}
