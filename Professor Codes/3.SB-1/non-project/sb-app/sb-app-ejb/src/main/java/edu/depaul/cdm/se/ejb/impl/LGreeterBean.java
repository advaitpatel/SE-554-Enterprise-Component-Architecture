package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.ejb.LGreeterBeanLocal;
import javax.ejb.Stateless;

@Stateless
public class LGreeterBean implements LGreeterBeanLocal {

    @Override
    public String greetMe(String name) {
        return "Local hello: " + name;
    }
}
