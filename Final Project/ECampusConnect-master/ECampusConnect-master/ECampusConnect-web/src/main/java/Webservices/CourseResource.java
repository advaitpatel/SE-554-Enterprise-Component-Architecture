package Webservices;

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

public class CourseResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	CourseService courseService;

	public CourseResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		courseService = new CourseService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Course getAnimal() {
		Course course = courseService.getCourse(id);
		return course;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Course getAnimalAsHtml() {
		Course course = courseService.getCourse(id);
		return course;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putAnimal(JAXBElement<Course> courseElement) {
		Course course = courseElement.getValue();
		Response response;
		if (courseService.getCourses().containsKey(course.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		courseService.createCourse(course);
		return response;
	}

	@DELETE
	public void deleteAnimal() {
		courseService.deleteCourse(id);
	}

}