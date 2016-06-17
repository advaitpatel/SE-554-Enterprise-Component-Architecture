package edu.depaul.cdm.se.soap;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Web service and sessionbean in one
 */
@Stateless
@WebService(serviceName="GreeterSBService")
public class GreeterSBService {

    public String sayGreet(String name) {
        return "Greetings " + name;
    }

}
