package edu.depaul.cdm.se.sbejb;

import javax.ejb.Local;

@Local
public interface LGreeterBeanLocal {
    public String greetMe(String name);
}
