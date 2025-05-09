package br.com.fiap.controllers;

import br.com.fiap.services.DuvidasService;
import br.com.fiap.beans.Duvidas;
import br.com.fiap.beans.Response;
import br.com.fiap.exceptions.EntityNotFoundException;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/duvidas")
public class ResponseController {

    @Inject
    private DuvidasService duvidasService;

    @GET
    public Response getAllDuvidas() {
        List<Duvidas> duvidas = duvidasService.getAllDuvidas();
        return Response.ok(duvidas).build();
    }

    @GET
    @Path("/{id}")
    public Response getDuvidaById(@PathParam("id") Long id) {
        try {
            Duvidas duvida = duvidasService.getDuvidaById(id);
            return Response.ok(duvida).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Response.notFound("Duvida not found")).build();
        }
    }

    @POST
    public Response createDuvida(Duvidas duvida) {
        try {
            Duvidas createdDuvida = duvidasService.createDuvida(duvida);
            return Response.status(Response.Status.CREATED).entity(createdDuvida).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(Response.badRequest("Error creating Duvida")).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateDuvida(@PathParam("id") Long id, Duvidas duvida) {
        try {
            Duvidas updatedDuvida = duvidasService.updateDuvida(id, duvida);
            return Response.ok(updatedDuvida).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Response.notFound("Duvida not found")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(Response.badRequest("Error updating Duvida")).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDuvida(@PathParam("id") Long id) {
        try {
            duvidasService.deleteDuvida(id);
            return Response.noContent().build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(Response.notFound("Duvida not found")).build();
        }
    }
}
