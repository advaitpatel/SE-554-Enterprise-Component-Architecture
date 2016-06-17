/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.soap;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;

/**
 * Oneway (aka fire and forget) service example
 */
@WebService
public class LongAwaitedGreeting {
        
    @Oneway
    public void onewayLongAwaitedResponse(String txt) {
        System.out.println("Oneway");
        doIt();
    }
    
    public void standardLongAwaitedResponse(String txt) {
        System.out.println("Standard way");
        doIt();
    }
    
    private void doIt() {
        System.out.println("Before pause");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AddressedGreeterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("After pause");
    }
    
}
