package edu.depaul.cdm.se.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Stateless
@Path("greetings")
public class Greeter {
    @GET
    @Path("/usingpath/{name}")
    @Produces("application/json")
    public String greetPath(@PathParam("name") String name) {
        return "PHello " + name;
    }
    
    @GET
    @Path("/usingquery")
    public String greetQuery(@QueryParam("name") String name) {
        return "QHello " + name;
    }
    /*
    @GET
    @Path("/usingquery")
    @Produces("application/xml")
    public String greetQuery(@QueryParam("name") String name) {
        return "<Hello>" +
                "<name>" + name + "</name>" +
                "</Hello>";
    }
    */
}
