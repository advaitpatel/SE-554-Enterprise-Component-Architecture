package edu.depaul.cdm.se.ejb.impl;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractContainerTest {

    private static EJBContainer ec;
    private static Context ctx;

    @Before
    public void instanceSetup() {

    }

    @BeforeClass
    public static void setUp() {
        Properties props = new Properties();
        props.put(EJBContainer.MODULES, new File("target/classes"));

        ec = EJBContainer.createEJBContainer(props);

        // ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
    }

    @AfterClass
    public static void tearDown() {
        if (ec != null) {
            try {
                ctx.close();
                ctx = null;
            } catch (NamingException ex) {
                Logger.getLogger(AbstractContainerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            ec.close();
            ec = null;
        }

    }

    protected Context getContext() {
        return ctx;
    }
}
