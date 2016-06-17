package edu.depaul.cdm.se.ejb;

import javax.ejb.Local;

@Local
public interface LGreeterBeanLocal {
    public String greetMe(String name);
}
