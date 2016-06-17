/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.soap_ws;

/**
 *
 * @author Advait
 */
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Message {

    @Resource(mappedName = "jms/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "jms/ExampleQueue")
    private Destination my_destin;

    @WebMethod
    public String sendMessage(String message) {
        javax.jms.Message request = null;
        if ("MapMessage".equalsIgnoreCase(message)) {
            request = sendMessage(message, MapMessage.class);
        } else {
            request = sendMessage(message, TextMessage.class);
        }
        String response = receiveMessage(request);
        return response;
    }

    private javax.jms.Message sendMessage(String msg, Class<? extends javax.jms.Message> messageType) {
        javax.jms.Message message = null;
        Connection connection = null;
        try {
            connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(my_destin);
            if (messageType != null && messageType.isAssignableFrom(TextMessage.class)) {
                message = session.createTextMessage(msg);
            } else {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setStringProperty("text", msg);
                message = mapMessage;
            }
            message.setJMSReplyTo(my_destin);
            messageProducer.send(message);
            System.out.println("Sent message id: " + message.getJMSMessageID());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
        return message;
    }

    private String receiveMessage(javax.jms.Message request) {
        String msg = null;
        Connection connection = null;
        try {
            connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination my_destin = request.getJMSReplyTo();
            if (my_destin == null) {
                my_destin = this.my_destin;
            }
            String messageSelector = "(JMSCorrelationID = '" + request.getJMSMessageID() + "')";
            System.out.println("Message selector: " + messageSelector);
            MessageConsumer messageConsumer = session.createConsumer(my_destin, messageSelector);
            connection.start();
            javax.jms.Message response = messageConsumer.receive(4000);
            if (response == null) {
                msg = "Response is not found";
            } else if (response instanceof TextMessage) {
                msg = ((TextMessage) response).getText();
            } else {
                msg = "Response is not type TextMessage";
            }
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
        return msg;
    }
}
