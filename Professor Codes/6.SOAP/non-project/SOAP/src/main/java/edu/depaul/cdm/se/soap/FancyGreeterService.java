package edu.depaul.cdm.se.soap;

import edu.depaul.cdm.se.soap.param.GreeterRequest;
import edu.depaul.cdm.se.soap.param.GreeterResponse;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Web service with object rather than simple basic type
 * 
 */
@WebService(serviceName="FancyGreeterService")
public class FancyGreeterService {
    @WebMethod(operationName = "sayIt")
    public GreeterResponse sayIt(@WebParam(name = "request") GreeterRequest request) {
        GreeterResponse response = new GreeterResponse(request.getName());
        return response;
    }
    
    public GreeterResponse saySomethingElse(GreeterRequest request) {
        GreeterResponse response = new GreeterResponse("Say something, ", request.getName());
        return response;
    }
}
