package edu.depaul.cdm.se.asynch;

import java.util.concurrent.Future;
import javax.ejb.Remote;

@Remote
public interface GreeterBeanRemote {

    Future<String> greetMe(String name);
    
}
