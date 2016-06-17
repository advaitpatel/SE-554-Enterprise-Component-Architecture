package edu.depaul.cdm.se.ejb.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.PostRemove;

@Stateless
@LocalBean
public class LocalStatelessCounter {
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
        Logger.getLogger(LocalStatelessCounter.class.getName()).log(Level.INFO, "stateless post construct");
    }
    
    @PreDestroy
    public void preDestory() {
        Logger.getLogger(LocalStatelessCounter.class.getName()).log(Level.INFO, "stateless pre destroy");
    }
}
