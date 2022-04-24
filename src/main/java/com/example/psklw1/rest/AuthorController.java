package com.example.psklw1.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/author")
public class AuthorController {
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {

        int x = 0;
//        Player player = playersDAO.findOne(id);
//        if (player == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//
//        PlayerDto playerDto = new PlayerDto();
//        playerDto.setName(player.getName());
//        playerDto.setJerseyNumber(player.getJerseyNumber());
//        playerDto.setTeamName(player.getTeam().getName());
//
//        return Response.ok(playerDto).build();
        return null;
    }
}