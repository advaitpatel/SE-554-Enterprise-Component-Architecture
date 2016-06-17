package edu.depaul.cdm.se.ejb.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.StatefulTimeout;
import edu.depaul.cdm.se.sbejb.IStatefulCounter;

@Stateful
@StatefulTimeout(value=1, unit= TimeUnit.MINUTES)
public class StatefulCounter implements Serializable, IStatefulCounter{
    private int counter = 0;
    
    @Override
    public void increment() {
        counter++;
    }
    
    @Override
    public int count() {
        return counter;
    }
    
    @PostConstruct
    public void postConstruct() {
        Logger.getLogger(StatefulCounter.class.getName()).log(Level.INFO, "stateful post construct");
    }
    
    @PreDestroy
    public void preDestroy() {
        Logger.getLogger(StatefulCounter.class.getName()).log(Level.INFO, "stateful pre destroy");
    }
    
    @PrePassivate
    public void prePassivate() {
        Logger.getLogger(StatefulCounter.class.getName()).log(Level.INFO, "stateful pre passivate");
    }
    
    @PostActivate
    public void preActivate() {
        Logger.getLogger(StatefulCounter.class.getName()).log(Level.INFO, "stateful post activate");
    }
    
    @Remove
    public void remove() {
        Logger.getLogger(StatefulCounter.class.getName()).log(Level.INFO, "stateful remove");
    }
}
