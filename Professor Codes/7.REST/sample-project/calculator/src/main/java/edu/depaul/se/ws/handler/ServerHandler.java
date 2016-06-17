package edu.depaul.se.ws.handler;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * This handler extracts addressing details and transmits them to the
 * application.
 *
 */
public class ServerHandler extends AddressingHandler {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isOutbound = (Boolean) context
                .get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!isOutbound) {
            try {
                SOAPEnvelope envelope = context.getMessage().getSOAPPart()
                        .getEnvelope();
                SOAPHeader header = envelope.getHeader();

                /* store in application context addressing information */
                context.put(AddressingHandler.MESSAGE_ID, getMessageID(header));
                context.setScope(AddressingHandler.MESSAGE_ID,
                        Scope.APPLICATION);
                context.put(AddressingHandler.REPLY_TO, getReplyTo(header));
                context.setScope(AddressingHandler.REPLY_TO, Scope.APPLICATION);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        return true;
    }
}
