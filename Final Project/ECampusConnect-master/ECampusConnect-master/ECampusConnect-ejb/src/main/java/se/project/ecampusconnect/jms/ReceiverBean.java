/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.jms;

/**
 *
 * @author Advait
 */
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/ExampleQueue", activationConfig
        = {
            @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JMSCorrelationID IS NULL"),
            @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})

@TransactionManagement(TransactionManagementType.BEAN)
public class ReceiverBean implements MessageListener {

    @Resource(mappedName = "jms/ConnectionFactory")
    private ConnectionFactory cf;

    @Resource(mappedName = "jms/ExampleQueue")
    private Destination destination;

    @Resource
    private MessageDrivenContext mdc;

    @EJB
    private ReceiverRepo receiver_repo;

    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        if (message instanceof TextMessage) {
            msg = (TextMessage) message;
            parseMessage(msg);
        } else {
            String resp = "Received message of wrong type: "
                    + message.getClass() + ". Allowed are only text messages!";
            reply(message, resp);
            System.out.println(resp);
        }
    }

    private void parseMessage(TextMessage message) {
        try {
            String text = message.getText();
            receiver_repo.addCourse(text);
            System.out.println("Received Courses: " + text);
            if (text != null && text.equalsIgnoreCase("Hello world")) {
                reply(message, "world");
            } else {
                reply(message, "ERROR: Valid payload is only \"Hello world\"");
            }
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            mdc.setRollbackOnly();
            e.printStackTrace();
        }
    }

    private void reply(Message message, String payload) {
        Connection connection = null;
        try {
            connection = cf.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Destination destination = message.getJMSReplyTo();
            if (destination == null) {
                destination = this.destination;
            }
            MessageProducer messageProducer = session
                    .createProducer(destination);
            Message response = session.createTextMessage(payload);
            response.setJMSCorrelationID(message.getJMSMessageID());
            messageProducer.send(response);
            System.out.println("Request message id: " + message.getJMSMessageID());
            System.out.println("Response message id: " + response.getJMSMessageID());
            System.out.println("Response message correlation id: " + response.getJMSCorrelationID());
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
    }

}
