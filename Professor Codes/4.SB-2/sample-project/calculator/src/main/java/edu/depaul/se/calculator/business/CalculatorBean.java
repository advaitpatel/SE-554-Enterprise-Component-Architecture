package edu.depaul.se.calculator.business;

import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.log.Logger;
import java.security.Principal;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class CalculatorBean {
    @EJB
    private Logger logger;

    @Resource
    private SessionContext context;
    
    public float add(float lhs, float rhs) {
        Principal principal = context.getCallerPrincipal();
        System.out.println(principal.getName());
        
        float result = lhs + rhs;
        logger.log(lhs + " + " + rhs + " = " + result);
        return result;
    }

    /**
     * Multiplies two numbers together
     * @param lhs
     * @param rhs
     * @return
     */
    @RolesAllowed("admin")
    public float multiply(float lhs, float rhs) {
        Principal principal = context.getCallerPrincipal();
        System.out.println(principal.getName());
        
        float result = lhs * rhs;
        logger.log(lhs + " * " + rhs + " = " + result);
        return result;
    }


    /**
     * Subtract rhs from lhs (lhs - rhs)
     * @param lhs
     * @param rhs
     * @return
     */
    public float subtract(float lhs, float rhs) {
        float result = lhs - rhs;
        logger.log(lhs + " - " + rhs + " = " + result);
        return result;
    }

    /**
     * Divide rhs from lhs (lhs - rhs)
     * @param lhs
     * @param rhs
     * @return
     */
    public float divide(float numerator, float denominator) throws DivideByZeroException {
        if (denominator == 0.0) {
            throw new DivideByZeroException("Denominator can not be zero");
        }
        float result = numerator/denominator; 
        logger.log(numerator + " * " + denominator + " = " + result);
        return result;
    }
}
