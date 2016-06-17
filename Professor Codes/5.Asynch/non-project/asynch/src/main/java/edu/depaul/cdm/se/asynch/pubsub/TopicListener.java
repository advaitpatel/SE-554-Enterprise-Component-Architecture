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
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "TopicListener"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "TopicListener")
})
public class TopicListener implements MessageListener {
    private static final Logger logger = Logger.getLogger(TopicListener.class.getName());
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            logger.info(textMessage.getText());
        } catch (JMSException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
