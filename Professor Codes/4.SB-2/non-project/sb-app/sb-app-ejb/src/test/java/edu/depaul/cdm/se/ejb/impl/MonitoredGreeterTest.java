package edu.depaul.cdm.se.ejb.impl;

import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonitoredGreeterTest extends AbstractContainerTest {

    private static final String LKUP_NM = "java:global/classes/MonitoredGreeter";
    
    private MonitoredGreeter getEJBInstance() throws NamingException {
        return (MonitoredGreeter) getContext().lookup(LKUP_NM);
    }
    
    @Test
    public void testGreeter() throws Exception {
        MonitoredGreeter instance = getEJBInstance();
        String expResult = "EJB Greetings, Tester";
        String result = instance.getGreet("Tester");
        assertEquals(expResult, result);
    }
}
