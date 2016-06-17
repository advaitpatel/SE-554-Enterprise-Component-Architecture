package edu.depaul.se.calculator.service;

import edu.depaul.se.calculator.business.CalculatorBean;
import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.calculator.data.CalculatorData;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 * 
 * Reference
 * @see http://docs.oracle.com/javaee/6/tutorial/doc/gilik.html
 * 
 * Different production/consumption type
 * @see http://stackoverflow.com/questions/477816/the-right-json-content-type
 * 
 * Endpoint
 * @see http://localhost:8080/calculator-web/webresources/application.wadl
 */
@Path("calculator")
@Stateless
public class CalculatorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculatorResource
     */
    public CalculatorResource() {
    }
    
    @EJB
    private CalculatorBean calculator;

    /**
     * Sample REST using GET operation returning raw text results
     * @return lhs + rhs
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public String add(
            @QueryParam("lhs") float lhs,
            @QueryParam("rhs") float rhs) {
        return "" + calculator.add(lhs, rhs);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/divide")
    public CalculatorData divide(
            @QueryParam("numerator") float numerator,
            @QueryParam("denominator") float denominator) {

        CalculatorData data = new CalculatorData();
        data.setLhs(numerator);
        data.setRhs(denominator);
        try {
            data.setResult(calculator.divide(numerator, denominator));
        } catch (DivideByZeroException ex) {
            throw new RuntimeException(ex.toString());
        }
        
        return data;
    }
    
    /**
     * Sample REST using GET operation with JSON response rather than raw text
     * see web.xml for JSON converter 
     *  <init-param>
     *		<param-name>com.sun.jersey.api.json.POJOMappingFeature</param-name>
     *		<param-value>true</param-value>
     *	</init-param>
     *
     * @param lhs
     * @param rhs
     * @return lhs - rhs
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/subtract")
    public CalculatorData substract(
            @QueryParam("lhs") float lhs,
            @QueryParam("rhs") float rhs) {
        CalculatorData data = new CalculatorData(lhs, rhs, calculator.subtract(lhs, rhs));
        return data;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/multiply")
    public CalculatorData multiply(CalculatorData data) {
        data.setResult(calculator.multiply(data.getLhs(), data.getRhs()));
        return data;
    }

}
