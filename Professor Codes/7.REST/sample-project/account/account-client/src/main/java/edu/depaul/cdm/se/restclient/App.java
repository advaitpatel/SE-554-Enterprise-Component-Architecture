package edu.depaul.cdm.se.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 * Client showing Form client
 */
public class App {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget _baseWebTarget = client.target("http://localhost:8080/account-web/webresources/account/add");

        Form form = new Form();
        form.param("name", "SE554");
        form.param("init_bal", "120");

        String response
                = _baseWebTarget.request(MediaType.APPLICATION_FORM_URLENCODED)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                        String.class);

        System.out.println(response);
    }

}
