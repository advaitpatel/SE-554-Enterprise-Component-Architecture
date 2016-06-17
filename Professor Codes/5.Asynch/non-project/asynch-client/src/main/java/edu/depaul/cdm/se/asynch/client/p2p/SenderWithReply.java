package edu.depaul.cdm.se.asynch.client.p2p;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Request-reply sample
 */
public class SenderWithReply {

    public static void main(String[] args) throws Exception {
        SenderWithReply sender = new SenderWithReply();
        sender.sendSimpleMessageWithResponseQueue();
    }

    private void sendSimpleMessageWithResponseQueue() throws Exception {
        // Get JNDI context
        Context jndiContext = new InitialContext();

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/ConnectionFactory");
        Queue requestQueue = (Queue) jndiContext.lookup("jms/Queue");

        try (JMSContext context = connectionFactory.createContext()) {
            TemporaryQueue replyQueue = context.createTemporaryQueue();
            String msg = "Watson... come quickly... and reply";
            TextMessage requestMessage
                    = context.createTextMessage(msg);
            requestMessage.setJMSReplyTo(replyQueue);

            System.out.println("Request: " + msg);
            context.createProducer().send(
                    requestQueue, requestMessage);

            JMSConsumer consumer = context.createConsumer(replyQueue);
            System.out.print("Reply: ");
            System.out.println(consumer.receiveBody(String.class));
        }
    }
}
