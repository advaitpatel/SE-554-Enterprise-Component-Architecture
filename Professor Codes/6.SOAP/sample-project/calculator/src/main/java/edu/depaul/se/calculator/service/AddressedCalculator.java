package edu.depaul.se.calculator.service;

import edu.depaul.se.calculator.business.CalculatorBean;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;

/**
 * Leveraging WS-Addressing
 */
@WebService
@Addressing(required = true)
public class AddressedCalculator {

    @EJB
    private CalculatorBean calculator;
    @Resource
    private WebServiceContext context;

    @WebMethod(action = "add")
    public float add(float lhs, float rhs) {
        return calculator.add(lhs, rhs);
    }
}
