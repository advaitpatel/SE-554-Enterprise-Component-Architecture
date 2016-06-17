package edu.depaul.cdm.se.soap;

import javax.jws.WebService;

/**
 *  Simplest of Webservices
 */
@WebService
public class SimpleGreeter {
    public String greetMe(String name) {
        return "Hello " + name;
    }
}
