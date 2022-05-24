package lt.vu.rest.controllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Author;
import lt.vu.persistence.AuthorDAO;
import lt.vu.rest.controllers.dtos.AuthorDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/authorRest")
public class AuthorController {

    @Inject
    @Setter
    @Getter
    private AuthorDAO authorDAO;

    @Path("/getName/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNameById(@PathParam("id") final Integer id) {
        Author author = authorDAO.findOne(id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        AuthorDto personDto = new AuthorDto();
        personDto.setName(author.getName());

        return Response.ok(author.getName()).build();
    }
}
