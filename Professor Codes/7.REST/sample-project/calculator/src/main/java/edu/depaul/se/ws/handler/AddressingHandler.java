package edu.depaul.se.ws.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Helper handler for working with the WS-Addressing headers.
 */
public abstract class AddressingHandler implements
        SOAPHandler<SOAPMessageContext> {

    public static final String MESSAGE_ID = "MessageID";
    public static final String RELATES_TO = "RelatesTo";
    public static final String REPLY_TO = "ReplyTo";

    protected void setReplyTo(SOAPHeader header, String address) {
        /* change ReplyTo address using DOM */
        NodeList nodeListReplyTo = header.getElementsByTagName(REPLY_TO);
        NodeList nodeListAddress = nodeListReplyTo.item(0).getChildNodes();
        for (int i = 0; i < nodeListAddress.getLength(); i++) {
            Node node = nodeListAddress.item(i);
            if ("Address".equals(node.getLocalName())) {
                node.setTextContent(address);
                break;
            }
        }
    }

    protected String getMessageID(SOAPHeader header) {
        NodeList nodeListMessageId = header.getElementsByTagName(MESSAGE_ID);
        return nodeListMessageId.item(0).getTextContent();
    }

    protected String getRelatesTo(SOAPHeader header) {
        NodeList nodeListMessageId = header.getElementsByTagName(RELATES_TO);
        return nodeListMessageId.item(0).getTextContent();
    }

    protected String getReplyTo(SOAPHeader header) {
        NodeList nodeListReplyTo = header.getElementsByTagName(REPLY_TO);
        NodeList nodeListAddress = nodeListReplyTo.item(0).getChildNodes();
        for (int i = 0; i < nodeListAddress.getLength(); i++) {
            Node node = nodeListAddress.item(i);
            if ("Address".equals(node.getLocalName())) {
                return node.getTextContent();
            }
        }
        return null;
    }

    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public void close(MessageContext arg0) {
    }
}
