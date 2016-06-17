package edu.depaul.cdm.se.asynch.client.pubsub;

import javax.jms.Connection;
import java.util.Date;
import javax.jms.Topic;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Sender {
    public static void main(String[] args) throws Exception {
        // Get JNDI context
        Context jndiContext = new InitialContext();
        
        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) 
                    jndiContext.lookup("jms/ConnectionFactory");
        Topic topic = (Topic) jndiContext.lookup("jms/Topic");
        
        // Connect to queue to send message
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(topic);
        
        // Send message
        TextMessage message = session.createTextMessage();
        System.out.println(".....About to send message to Watson");
        message.setText("Watson... come quickly..." + new Date());
        //producer.setPriority(2);
        producer.setPriority(8);
        producer.send(message);
        System.out.println(".....message sent to Watson");
        
        // Clean up
        connection.close();
        
    }
}
