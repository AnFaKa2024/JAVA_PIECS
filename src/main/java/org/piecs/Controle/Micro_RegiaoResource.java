package org.piecs.Controle;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;

import java.util.Iterator;
import java.util.List;

@Path("T_PIECS_MICRO_REGIAO")
public class Micro_RegiaoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{responsavel}")
    public Response getMicro_Regiao(
        @PathParam("pages") int pages,
        @QueryParam("pageSize") int pageSize)
    {}


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<T_PIECS_MICRO_REGIAO> searchMicro_Regiao(
            @QueryParam("Qt_plcas") int qt_placas,
            @QueryParam("Qt_baterias") int qt_baterias)
    {}

    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMicro_Regiao(Micro_Regiao novaMicro_Regiao){}


    @DELETE
    @Path("{id}")
    public void deleteMicro_Regiao(@PathParam("id") int id){
        micro_regioes.remove(micro_regiao -> micro_regiao.getId() == id);
    }





}


