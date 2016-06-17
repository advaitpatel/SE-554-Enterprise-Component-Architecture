package edu.depaul.cdm.se.asynch.session;

import edu.depaul.cdm.se.asynch.GreeterBeanRemote;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless 
@Asynchronous
public class AsynchGreetingsBean implements GreeterBeanRemote {
    private Logger log = Logger.getLogger(AsynchGreetingsBean.class.getName());

    public Future<String> greetMe(String name) {
        log.fine("Entering");
        
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        
        log.fine("Exiting");
        
        return new AsyncResult<String>("Hello, " + name);
    }

}
