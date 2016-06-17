package edu.depaul.se.firstsb;

import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class GreeterBeanTest {
    /**
     * Test of returnMessage method, POJO test.
     */
    @Test
    public void testGreeting() throws Exception {
        GreeterBean instance = new GreeterBean();
        String expResult = "EJB Greetings, Tester";
        String result = instance.getGreet("Tester");
        assertEquals(expResult, result);
    }
    
}