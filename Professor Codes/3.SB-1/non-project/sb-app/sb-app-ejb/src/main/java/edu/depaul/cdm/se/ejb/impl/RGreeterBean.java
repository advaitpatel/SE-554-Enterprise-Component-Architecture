package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.ejb.RGreeterBeanRemote;
import javax.ejb.Stateless;

@Stateless
public class RGreeterBean implements RGreeterBeanRemote  {

    @Override
    public String greetMe(String name) {
        return "Remote hello: " + name;
    }
}
