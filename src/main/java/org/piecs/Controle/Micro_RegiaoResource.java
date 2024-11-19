package org.piecs.Controle;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;

@Path("T_PIECS_MICRO_REGIAO")
public class Micro_RegiaoResource {

    @GET
    @Produces
    public Response getMicro_Regiao() {
        String jsonResponse = """
            [
                {"id": 1, "nome": "SP"},
                {"id": 2, "nome": "CE"}
            ]
        """;

        return Response.ok(jsonResponse).build();
    }


    @POST
    @Produces
    public Response postMicro_Regiao(T_PIECS_MICRO_REGIAO novaMicroRegiao) {
        T_PIECS_MICRO_REGIAO.add(novaMicroRegiao);
        return Response.status(Response.Status.CREATED).entity(novaMicroRegiao).build();
    }

    @PUT
    @Path("{id}")
    public Response updateMicro_regiao(@PathParam("id") int id, T_PIECS_MICRO_REGIAO microRegiao) {
        for (T_PIECS_MICRO_REGIAO microregiao : microRegiao){
            if (microregiao.getId() == id){
                microRegiao.setResponsavel(microRegiao.getResponsavel());
                microRegiao.setCapacidade_placa(microRegiao.getCapacidade_placa());
                microRegiao.setCapacidade_bateria(microRegiao.getCapacidade_bateria());
                microRegiao.setQt_armazenada_energia(microRegiao.getQt_armazenada_energia());
                microRegiao.setEndereco(microRegiao.getEndereco());
                return Response.ok(microRegiao).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteMicro_regiao(@PathParam("id") int id) {
        for (T_PIECS_MICRO_REGIAO microRegiao : microRegiao){
            if (microRegiao.getId() == id){
                microRegiao.remove(microRegiao);
                return Response.ok().build();
                
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    

}


