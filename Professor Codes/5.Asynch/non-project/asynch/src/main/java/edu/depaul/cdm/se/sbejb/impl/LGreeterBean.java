package edu.depaul.cdm.se.sbejb.impl;

import edu.depaul.cdm.se.sbejb.LGreeterBeanLocal;
import javax.ejb.Stateless;

@Stateless
public class LGreeterBean implements LGreeterBeanLocal {

    @Override
    public String greetMe(String name) {
        return "Local hello: " + name;
    }
}
