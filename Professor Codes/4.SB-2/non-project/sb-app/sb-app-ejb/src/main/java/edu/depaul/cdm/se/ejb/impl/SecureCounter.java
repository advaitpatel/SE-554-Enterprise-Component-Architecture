package edu.depaul.cdm.se.ejb.impl;

import edu.depaul.cdm.se.sbejb.ISecureCounter;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
public class SecureCounter implements ISecureCounter {
    private int counter = 0;
    
    @Override
    @RolesAllowed({"admin"})
    public void increment() {
        counter++;
    }

    @Override
    public int count() {
        return counter;
    }

}
