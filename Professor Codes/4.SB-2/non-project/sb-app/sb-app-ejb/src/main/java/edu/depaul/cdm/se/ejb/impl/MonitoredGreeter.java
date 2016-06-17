package edu.depaul.cdm.se.ejb.impl;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.interceptor.Interceptors;
import edu.depaul.cdm.se.ejb.interceptor.Watcher;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Stateless
@LocalBean
@Interceptors({Watcher.class})
public class MonitoredGreeter {
    private static final Logger log = Logger.getLogger(MonitoredGreeter.class.getName());
    public String getGreet(String name) {
        return "EJB Greetings, " + name;
        
    }
    
    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception { 
        String callerClass = ctx.getClass().getName();
        String callerMethod = ctx.getMethod().getName();

        log.entering(callerClass, callerMethod);
        log.info("Auditor is watching you, be careful of what you are doing");
        Object o = ctx.proceed();
        log.exiting(callerClass, callerMethod);

        return o;
    }   
}
