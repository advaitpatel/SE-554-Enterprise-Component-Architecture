package edu.depaul.se.firstsb;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class GreeterBean {

    private static final Logger logger = Logger.getLogger(GreeterBean.class.getName());

    public GreeterBean() {
        logger.info("GreeterBean constructor");
    }

    public String getGreet(String name) {
        return "EJB Greetings, " + name;
    }
    
    @PostConstruct
    public void ejbCreate() {
        logger.info("GreeterBean post construct");
    }
    
    @PreDestroy
    public void ejbDestroy() {
        logger.info("GreeterBean pre destroy");
    }
}
