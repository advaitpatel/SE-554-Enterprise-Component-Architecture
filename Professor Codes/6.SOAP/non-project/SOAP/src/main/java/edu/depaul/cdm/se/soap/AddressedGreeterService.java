package edu.depaul.cdm.se.soap;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

/**
 * WS-Addressed example
 * When using SOAPUI version post 4.6.3 to test this service, make sure
 * <li>add -Dfile.encoding=UTF-8 to soapui.bat
 * <li>enable generate messageId option
 */
@WebService(serviceName = "AddressedGreeterService",
            targetNamespace = "http://addressedgreetings.se.cdm.depaul.edu")
@Addressing(required = true, enabled = true)
public class AddressedGreeterService {
    @Resource
    private WebServiceContext wsc;

    public W3CEndpointReference getEPR() {
        return (W3CEndpointReference) wsc.getEndpointReference();
    }

    @WebMethod
    @Action(input = "http://addressedgreetings.se.cdm.depaul.edu/input",
    output = "http://addressedgreetings.se.cdm.depaul.edu/output")
    public String hello(@WebParam(name = "name") String txt) {
        return "Addressed Hello " + txt + " !";
    }
}
