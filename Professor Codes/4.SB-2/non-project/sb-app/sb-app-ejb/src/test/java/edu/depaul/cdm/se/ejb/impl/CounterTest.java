package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.sbejb.IStatelessCounter;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CounterTest extends AbstractContainerTest {

    private static final String LOCAL_LKUP_NAME = "java:global/classes/LocalStatelessCounter";
    private static final String REMOTE_LKUP_NAME = "java:global/classes/StatelessCounter!edu.depaul.cdm.se.sbejb.IStatelessCounter";

    private LocalStatelessCounter getLocalInstance() throws NamingException {
        return (LocalStatelessCounter) getContext().lookup(LOCAL_LKUP_NAME);
    }
    
    private IStatelessCounter getRemoteInstance() throws NamingException {
        return (IStatelessCounter) getContext().lookup(REMOTE_LKUP_NAME);
    }
    
    @Test
    public void testLocalCounter() throws Exception {
        LocalStatelessCounter instance = getLocalInstance();
        int preIncrement = instance.count();
        instance.increment();
        int postIncrement = instance.count();
        assertEquals(++preIncrement, postIncrement);
    }
    
    @Test(expected = javax.naming.NamingException.class)
    public void testRemoteCounter() throws Exception {
        IStatelessCounter instance = getRemoteInstance();
        int preIncrement = instance.count();
        instance.increment();
        int postIncrement = instance.count();
        assertEquals(++preIncrement, postIncrement);
    }
    
}
