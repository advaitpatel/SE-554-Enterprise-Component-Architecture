package edu.depaul.se.calculator.service;

import edu.depaul.se.calculator.business.CalculatorBean;
import edu.depaul.se.ws.handler.AddressingHandler;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.Addressing;

/**
 *
 */
@WebService
@Addressing(required = true)
@HandlerChain(file = "calcws_handler_chain.xml")
public class AddressedCalculator {

    @EJB
    private CalculatorBean calculator;
    @Resource
    private WebServiceContext context;

    @WebMethod(action = "add")
    public float add(float lhs, float rhs) {
        printAddressingDetails();
        return calculator.add(lhs, rhs);
    }

    private void printAddressingDetails() {
        MessageContext messageContext = context.getMessageContext();
        System.out.println("[server] Received message ID: "
                + messageContext.get(AddressingHandler.MESSAGE_ID));
        System.out.println("[server] Reply To address: "
                + messageContext.get(AddressingHandler.REPLY_TO));
    }
}
