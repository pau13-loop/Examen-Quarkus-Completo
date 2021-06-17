package edu.pingpong.examenquarkus;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.pingpong.examenquarkus.service.ServiceOlli;

@Path("/")
// @ApplicationScoped
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
}