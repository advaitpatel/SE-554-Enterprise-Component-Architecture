package com.javapapers.webservices.rest.jersey;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/animals")
public class AnimalsResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	AnimalService animalService;

	public AnimalsResource() {
		animalService = new AnimalService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Animal> getAnimals() {
		return animalService.getAnimalAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Animal> getAnimalsAsHtml() {
		return animalService.getAnimalAsList();
	}

	// URI: /rest/animals/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(animalService.getAnimalsCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createAnimal(@FormParam("id") String id,
			@FormParam("animalname") String name,
			@FormParam("animaltype") String type,
			@Context HttpServletResponse servletResponse) throws IOException {
		Animal animal = new Animal(id, name, type);
		animalService.createAnimal(animal);
		servletResponse.sendRedirect("./animals/");
	}

	@Path("{animal}")
	public AnimalResource getAnimal(@PathParam("animal") String id) {
		return new AnimalResource(uriInfo, request, id);
	}

}