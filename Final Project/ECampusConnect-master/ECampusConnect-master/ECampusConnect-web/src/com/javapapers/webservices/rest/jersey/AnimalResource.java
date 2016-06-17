package com.javapapers.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class AnimalResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	AnimalService animalService;

	public AnimalResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		animalService = new AnimalService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Animal getAnimal() {
		Animal animal = animalService.getAnimal(id);
		return animal;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Animal getAnimalAsHtml() {
		Animal animal = animalService.getAnimal(id);
		return animal;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putAnimal(JAXBElement<Animal> animalElement) {
		Animal animal = animalElement.getValue();
		Response response;
		if (animalService.getAnimals().containsKey(animal.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		animalService.createAnimal(animal);
		return response;
	}

	@DELETE
	public void deleteAnimal() {
		animalService.deleteAnimal(id);
	}

}