package edu.depaul.se.log;

import edu.depaul.se.log.jpa.DBLogger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class Logger {
    @PersistenceContext(unitName="calculatorPU")
    private EntityManager em;

    public void log(String message) {
        DBLogger log = new DBLogger();
        log.setMessage(message);
        em.persist(log);
    }

}
