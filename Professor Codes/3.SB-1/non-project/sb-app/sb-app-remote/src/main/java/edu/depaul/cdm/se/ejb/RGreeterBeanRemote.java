package edu.depaul.cdm.se.ejb;

import javax.ejb.Remote;

@Remote
public interface RGreeterBeanRemote {

    String greetMe(String name);
    
}
