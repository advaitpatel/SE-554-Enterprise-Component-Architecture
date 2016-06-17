package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.ejb.RGreeterBeanRemote;
import org.junit.Test;
import static org.junit.Assert.*;

public class GreeterBeanTest {
    
    public GreeterBeanTest() {
    }
    
    /**
     * Test of greetMe method, of class SimpleGreeterBean.
     */
    @Test
    public void testLocalBeanTest() {
        SimpleGreeterBean bean = new SimpleGreeterBean();
        assertEquals("Hello Dave", bean.greetMe("Dave"));
    }
    
    @Test
    public void testInterfaceTest() {
        RGreeterBeanRemote bean = new RGreeterBean();
        assertEquals("Remote hello: Dave", bean.greetMe("Dave"));
    }
}
