package edu.depaul.se.calculator.service;

import edu.depaul.se.calculator.business.CalculatorBean;
import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.calculator.data.CalculatorData;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * SOAP web service
 * 
 * Reference
 * @see http://docs.oracle.com/javaee/6/tutorial/doc/gijqy.html
 * @see http://netbeans.org/kb/trails/web.html
 * 
 * Endpoint
 * @see http://localhost:8080/calculator-web/CalculatorService?WSDL
 */
@WebService(serviceName = "CalculatorService")
public class CalculatorService {
    @EJB
    private CalculatorBean calculator;

    /**
     * Simplest of web service operation
     * @param rhs
     * @param lhs
     * @return rhs + lhs
     */
    public float add(float rhs, float lhs) {
        return calculator.add(rhs, lhs);
    }
    
    /**
     * Example to show
     * <li>SOAPAction definition to ensure interop with .NET applications with WCF using @WebMethod(action)
     * <li>Introduce layer between parameter name and real instance variable using @WebParam
     * @param rhs
     * @param lhs
     * @return 
     */
    @WebMethod(action="minus_action", operationName="minus_operation")
    public float subtract(@WebParam(name="i") float rhs, 
                        @WebParam(name="j") float lhs) {
        return calculator.subtract(rhs, lhs);
    }

    
    /**
     * Example to show Complex data transmission
     * @param data
     * @return 
     */
    @WebMethod(operationName = "multiply", action="multiply")
    public CalculatorData multiply(@WebParam(name = "data") CalculatorData data) {
        data.setResult(calculator.multiply(data.getLhs(), data.getRhs()));
        return data;
    }

    /**
     * Example of SOAPFault
     * @return lhs/rhs
     */
    @WebMethod(operationName = "divide", action="divide")
    public float divide(
            @WebParam(name = "numerator") float numerator, 
            @WebParam(name = "denominator") float denominator) 
                throws DivideByZeroException {
        return calculator.divide(numerator, denominator);
    }

}
