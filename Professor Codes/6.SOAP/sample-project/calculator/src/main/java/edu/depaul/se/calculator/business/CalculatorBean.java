package edu.depaul.se.calculator.business;

import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.log.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CalculatorBean {

    @EJB
    private Logger logger;
    
    public float add(float lhs, float rhs) {
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
    public float multiply(float lhs, float rhs) {
        return lhs * rhs;
    }


    /**
     * Subtract rhs from lhs (lhs - rhs)
     * @param lhs
     * @param rhs
     * @return
     */
    public float subtract(float lhs, float rhs) {
        return lhs - rhs;
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
        return numerator/denominator;
    }
}
