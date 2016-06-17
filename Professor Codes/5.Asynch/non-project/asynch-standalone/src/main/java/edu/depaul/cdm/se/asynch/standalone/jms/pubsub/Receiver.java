package edu.depaul.cdm.se.asynch.standalone.jms.pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Topic;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Receiver {
     public static void main(String[] args) throws Exception {
        Context jndiContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) 
                    jndiContext.lookup("jms/ConnectionFactory");
        Topic topic = (Topic) jndiContext.lookup("jms/Topic");
        
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(topic);
        connection.start();
        System.out.println("PubSub Dr Who is listening: ");
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("Message received: " + message.getText());
        }
    }   
}
