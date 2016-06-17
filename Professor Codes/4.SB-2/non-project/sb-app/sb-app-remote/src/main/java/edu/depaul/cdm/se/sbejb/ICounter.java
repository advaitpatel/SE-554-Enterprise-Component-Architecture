package edu.depaul.cdm.se.sbejb;

import javax.ejb.Remote;

@Remote
public interface ICounter {
    public void increment(); 
    
    public int count(); 
}
