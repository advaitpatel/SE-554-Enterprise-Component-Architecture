package edu.depaul.cdm.se.ejb.interceptor;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Watcher {
    private static final Logger log = Logger.getLogger(Watcher.class.getName());
    
    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception { 
        String callerClass = ctx.getClass().getName();
        String callerMethod = ctx.getMethod().getName();

        log.entering(callerClass, callerMethod);
        log.info("Watcher is watching you, be careful of what you are doing");
        Object o = ctx.proceed();
        log.exiting(callerClass, callerMethod);

        return o;
    }   
}
