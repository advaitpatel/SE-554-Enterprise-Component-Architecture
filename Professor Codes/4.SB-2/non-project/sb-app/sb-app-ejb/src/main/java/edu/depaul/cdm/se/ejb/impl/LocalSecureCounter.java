package edu.depaul.cdm.se.ejb.impl;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class LocalSecureCounter {
    private int counter = 0;
    
    @RolesAllowed({"admin"})
    public void increment() {
        counter++;
    }

    public int count() {
        return counter;
    }

}
