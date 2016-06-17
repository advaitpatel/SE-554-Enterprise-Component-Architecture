package edu.depaul.cdm.se.asynch.pubsub;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "ImportantTopicListener"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JMSPriority > 5"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "ImportantTopicListener")
})
public class ImportantTopicListener implements MessageListener {
    private static final Logger logger = Logger.getLogger(ImportantTopicListener.class.getName());

    @Override
    public void onMessage(Message msg) {
        TextMessage textMessage = (TextMessage) msg;
        try {
            logger.info("ImportantTopicListener priority: " + msg.getJMSPriority());
            logger.info(textMessage.getText());
        } catch (JMSException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
