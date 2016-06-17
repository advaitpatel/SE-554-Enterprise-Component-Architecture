package edu.depaul.cdm.se.ejb.impl;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class SimpleGreeterBean {
    public String greetMe(String name) {
        return "Hello " + name;
    }
}
