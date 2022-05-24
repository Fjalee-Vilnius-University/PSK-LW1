package lt.vu.rest.controllers;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Author;
import lt.vu.persistence.AuthorDAO;
import lt.vu.rest.controllers.dtos.AuthorDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/author")
public class AuthorController {

    @Inject
    @Setter
    @Getter
    private AuthorDAO authorDAO;

    @Path("/{id}")
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

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Response update(@PathParam("id") final Integer personId, AuthorDto authorDto) {
        try {
            Author existingPerson = authorDAO.findOne(personId);
            if (existingPerson == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingPerson.setName(authorDto.getName());

            authorDAO.update(existingPerson);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
