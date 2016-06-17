package edu.depaul.cdm.se.asynch.client.p2p;

import javax.jms.*;
import javax.naming.*;

/**
 * Fire and forget sample
 */
public class Sender {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        sender.sendSimpleMessage();
    }

    private void sendSimpleMessage() throws Exception {
        // Get JNDI context
        Context jndiContext = new InitialContext();

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/ConnectionFactory");
        Queue requestQueue = (Queue) jndiContext.lookup("jms/Queue");

        
        try (JMSContext context = connectionFactory.createContext()) {
            String msg = "Watson... come quickly...";
            TextMessage requestMessage
                    = context.createTextMessage(msg);
            
            System.out.println("Request: " + msg);
            context.createProducer().send(
                    requestQueue, requestMessage);
        }
    }
}
