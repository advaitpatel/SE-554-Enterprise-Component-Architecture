package edu.depaul.cdm.se.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Auditor {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        System.out.println("*** DefaultInterceptor intercepting " + ctx.getMethod().getName());
        try {
            return ctx.proceed();
        } finally {
            System.out.println("*** DefaultInterceptor exiting");
        }
    }
}
