package edu.depaul.cdm.se.soap;

import edu.depaul.cdm.se.sb.GreeterSB;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Greeter service with proxy to the underlying service
 */
@WebService(serviceName = "GreeterSBProxyService")
public class GreeterSBProxyService {
    @EJB
    private GreeterSB ejbRef;

    @WebMethod(operationName = "greet")
    public String greet(@WebParam(name = "name") String name) {
        return ejbRef.greet(name);
    }
    
}
