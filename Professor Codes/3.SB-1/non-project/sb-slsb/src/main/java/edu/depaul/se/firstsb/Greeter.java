package edu.depaul.se.firstsb;

import java.util.logging.Logger;

public class Greeter {
    private static final Logger logger = Logger.getLogger(Greeter.class.getName());
    
    public Greeter() {
        logger.info("Greeter constructor");
    }
    
   public String getGreet(String name) {
       return "POJO Greetings, " + name;
   }
}
