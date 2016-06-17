package edu.depaul.cdm.se.sbejbclient;

import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import edu.depaul.cdm.se.sbejb.IStatefulCounter;
import edu.depaul.cdm.se.sbejb.IStatelessCounter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 * Example to go along with SB App to demonstrate the difference between
 * Stateless Session Bean and Stateful Session Bean
 * 
 * Notice that SFSB always end with count of 2 whereas SLSB keep increasing count
 */
public class App implements Runnable 
{
    public static void main( String[] args ) throws Exception
    {
        App obj = new App();
        for (int i=0; i< 10; i++) {
            Thread t1 = new Thread(obj, "T" + i);
            t1.start();
        }
    }
    
    public void run() {
        try {
            statelessCounter();
            // statefulCounter();
        } catch (NamingException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Stateful counter
     * @throws NamingException 
     */
    private void statefulCounter() throws NamingException {
        IStatefulCounter counter = lookupStatefulCounter();
        counter.increment();
        counter.increment();
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": Stateful: " + counter.count());
    }
    
    /**
     * Stateless counter
     * @throws NamingException 
     */
    private void statelessCounter() throws NamingException {
        IStatelessCounter counter = lookupStatelessCounter();
        counter.increment();
        counter.increment();
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": Stateless: " + counter.count());
    }
    
    private IStatefulCounter lookupStatefulCounter() throws NamingException{
        final String sfLookupKey = "java:global/edu.depaul.cdm.se_sb-app-ear_ear_1.5-SNAPSHOT/sb-app-ejb-1.5-SNAPSHOT/StatefulCounter";

        return (IStatefulCounter) new InitialContext().lookup(sfLookupKey); 
    }
    
    private IStatelessCounter lookupStatelessCounter() throws NamingException{
        final String slLookupKey = "java:global/edu.depaul.cdm.se_sb-app-ear_ear_1.5-SNAPSHOT/sb-app-ejb-1.5-SNAPSHOT/StatelessCounter";

        return (IStatelessCounter) new InitialContext().lookup(slLookupKey);
    }
    
}
