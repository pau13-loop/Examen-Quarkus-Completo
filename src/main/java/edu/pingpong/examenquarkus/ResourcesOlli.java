package edu.pingpong.examenquarkus;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.pingpong.examenquarkus.domain.Item;
import edu.pingpong.examenquarkus.domain.Orden;
import edu.pingpong.examenquarkus.domain.Usuaria;
import edu.pingpong.examenquarkus.service.ServiceOlli;

@Path("/")
public class ResourcesOlli {

    @Inject
    ServiceOlli service;

    public ResourcesOlli() {}

    @GET
    @Path("/wellcome")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        return Response.status(Response.Status.OK).entity("Wellcome Ollivanders!").build();
    }

    @GET
    @Path("/usuaria/{nombre}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("nombre") String nombre) {
        Usuaria usu = service.cargaUsuaria(nombre);
        return usu.getNombre().equals("")? 
        Response.status(Response.Status.NOT_FOUND).build()
        : Response.status(Response.Status.OK).entity(usu).build();
    }


}