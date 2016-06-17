package edu.depaul.cdm.se.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.depaul.cdm.se.account.persistence.Account;

@SessionScoped
@Named
public class AccountBean implements Serializable {
    private static final Logger logger = Logger.getLogger(AccountBean.class.getName());
    
    @PersistenceContext(unitName = "accountPU")
    private EntityManager entityManager;
    
    public List<Account> getAccountList() throws SQLException {
        
        logger.info("Before getting connection");
        
        List<Account> list = entityManager.createQuery("select a from Account a").getResultList();
        
        logger.log(Level.INFO, "Before returning: {0}", list.size());
        
        return list;
    }
}
