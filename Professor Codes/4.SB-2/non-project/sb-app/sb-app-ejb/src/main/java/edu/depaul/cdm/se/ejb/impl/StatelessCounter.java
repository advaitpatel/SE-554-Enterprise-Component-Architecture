package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.sbejb.IStatelessCounter;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PostRemove;

@Stateless
public class StatelessCounter implements IStatelessCounter {
    private int counter = 0;
    
    @PostRemove
    private void resetCounter() {
        counter = 0;
    }
    
    public void increment() {
        counter++;
    }
    
    public int count() {
        return counter;
    }
    
    @PostConstruct
    public void postConstruct() {
        Logger.getLogger(StatelessCounter.class.getName()).log(Level.INFO, "stateless post construct");
    }
    
    @PreDestroy
    public void preDestory() {
        Logger.getLogger(StatelessCounter.class.getName()).log(Level.INFO, "stateless pre destroy");
    }

}
