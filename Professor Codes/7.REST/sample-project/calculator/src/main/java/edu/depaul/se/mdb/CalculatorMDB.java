package edu.depaul.se.mdb;

import edu.depaul.se.xml.CalculatorRequest;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@MessageDriven(mappedName = "jms/CalculatorQ",
activationConfig = {
    @ActivationConfigProperty(
     propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
public class CalculatorMDB implements MessageListener {

    private static final Logger logger = Logger.getLogger(CalculatorMDB.class.getName());

    @Resource(mappedName = "jms/ConnectionFactory")    
    private QueueConnectionFactory queueConnectionFactory;
    
    public void onMessage(Message message) {
        // Based on the Calculator operator, call the appropriate method
        CalculatorRequest c = null;
        try {
            c = convert(((TextMessage) message).getText());
            logger.finest(message.toString());

            int result = 0;
            switch (c.getOperator()) {
                case MULTIPLY:
                    result = c.getRhs() * c.getLhs();
                    break;
                case SUBTRACT:
                    result = c.getRhs() - c.getLhs();
                    break;
                case ADD:
                    result = c.getRhs() + c.getLhs();
                    break;
            }

            if (message.getJMSReplyTo() == null) {
                logger.log(Level.INFO, "{0} {1} {2} = {3}", new Object[]{c.getLhs(), c.getOperator(), c.getRhs(), result});
            } else {
                Destination replyDestination = message.getJMSReplyTo();
                QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
                Session session = queueConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer replyProducer = session.createProducer(message.getJMSReplyTo());
                TextMessage replyMessage = session.createTextMessage("" + result);
                replyMessage.setJMSCorrelationID(message.getJMSMessageID());
                replyProducer.send(replyMessage);
            }
        } catch (JMSException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Convert xml to CalculatorRequest
     *
     * @param xml
     * @return
     */
    private CalculatorRequest convert(String xml) {
        CalculatorRequest c = null;

        try {
            JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
            Unmarshaller m = context.createUnmarshaller();
            try (StringReader reader = new StringReader(xml)) {
                c = (CalculatorRequest) m.unmarshal(reader);
            }
        } catch (JAXBException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return c;
    }
}
