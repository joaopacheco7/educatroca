package br.com.educatroca.controller;

import br.com.educatroca.entity.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PersonController {

	public Person update(final Long id, final Person person) {
		final Person personEntity = Person.findById(id);

		if (personEntity == null) {
			throw new WebApplicationException("Person with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
		}

		personEntity.setName(person.getName());
		personEntity.setEmail(person.getEmail());
		personEntity.setPassword(person.getPassword());

		return personEntity;
	}

}
