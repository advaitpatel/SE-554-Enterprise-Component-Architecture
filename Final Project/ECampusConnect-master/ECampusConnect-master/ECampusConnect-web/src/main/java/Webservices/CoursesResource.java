package Webservices;

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

@Path("/courses")
public class CoursesResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	CourseService courseService;

	public CoursesResource() {
		courseService = new CourseService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Course> getCourses() {
		return courseService.getCourseAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Course> getCoursesAsHtml() {
		return courseService.getCourseAsList();
	}

	// URI: /rest/courses/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(courseService.getCoursesCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createCourse(@FormParam("id") String id,
			@FormParam("coursename") String name,
			@FormParam("coursetype") String type,
			@Context HttpServletResponse servletResponse) throws IOException {
		Course course = new Course(id, name, type);
		courseService.createCourse(course);
		servletResponse.sendRedirect("./courses/");
	}

	@Path("{course}")
	public CourseResource getCourse(@PathParam("course") String id) {
		return new CourseResource(uriInfo, request, id);
	}

}