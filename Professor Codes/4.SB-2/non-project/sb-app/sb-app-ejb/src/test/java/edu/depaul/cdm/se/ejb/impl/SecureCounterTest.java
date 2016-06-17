package edu.depaul.cdm.se.ejb.impl;

import javax.ejb.EJBAccessException;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

public class SecureCounterTest extends AbstractContainerTest {

    private static final String LKUP_NAME = "java:global/classes/LocalSecureCounter";

    private LocalSecureCounter getInstance() throws NamingException {
        return (LocalSecureCounter) getContext().lookup(LKUP_NAME);
    }
    
    @Test
    public void testCount() throws Exception {
        LocalSecureCounter instance = getInstance();
        int count = instance.count();
        assertEquals(count, count);
    }

    @Test(expected = EJBAccessException.class)
    public void testIncrement() throws Exception {
        LocalSecureCounter instance = getInstance();
        instance.increment();
        int count = instance.count();
        assertEquals(count, count);
    }
}
