package edu.depaul.cdm.se.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Sample JAX-RS client sample code
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client client = ClientBuilder.newClient();
        WebTarget _baseWebTarget = client.target("http://localhost:8080/RESTProject/webresources");
        App app = new App();
        app.checkResponseForEndPoint(_baseWebTarget);
        app.checkResponse(_baseWebTarget);
    }
    
    /**
     * Handling request with associated response object
     * @param _baseWebTarget 
     */
    private void checkResponseForEndPoint(WebTarget _baseWebTarget) {
        WebTarget webTarget = _baseWebTarget.path("greetings/usingquery");
        Response response = webTarget.queryParam("name", "Dave").request().buildGet().invoke();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
    
    /**
     * Handling request with parsed response object
     * @param _baseWebTarget 
     */
    private void checkResponse(WebTarget _baseWebTarget) {
        WebTarget webTarget = _baseWebTarget.path("greetings/usingpath");
        String response = webTarget.path("Dave").request().get(String.class);
        System.out.println(response);
    }
}
