package edu.depaul.cdm.se.asynch.p2p;

import edu.depaul.cdm.se.sbejb.impl.SimpleGreeterBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/Queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class QueueListener implements MessageListener {
    private static final Logger logger = Logger.getLogger(QueueListener.class.getName());

    @EJB
    private SimpleGreeterBean greeter;

    @Override
    public void onMessage(Message message) {
        try {
            String msg = ((TextMessage) message).getText();
            logger.log(Level.INFO, "Request.: {0}", new Object[]{msg});
            logger.log(Level.INFO, "Response: {0}", new Object[]{greeter.greetMe(msg)});
        } catch (JMSException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
