package br.com.educatroca;

import java.util.List;

import br.com.educatroca.controller.PersonController;
import br.com.educatroca.entity.Person;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/educatroca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EducaTrocaResource {

	@Inject
	private PersonController personController;


	@GET
	public List<Person> findAll() {
		return Person.listAll();
	}


	@POST
	@Transactional
	public Response create(final Person person) {
		Person.persist(person);
		return Response.ok(person).status(201).build();
	}


	@PUT
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id") final Long id, final Person person) {
		final Person personEntity = personController.update(id, person);
		return Response.ok(personEntity).build();
	}


	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(@PathParam("id") final Long id) {
		final Person personEntity = Person.findById(id);

		if (personEntity == null) {
			throw new WebApplicationException("Person with id " + id + " does not exist.", Response.Status.NOT_FOUND);
		}

		personEntity.delete();
		return Response.status(204).build();
	}
}
