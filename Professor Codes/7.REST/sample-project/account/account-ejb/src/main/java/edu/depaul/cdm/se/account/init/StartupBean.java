package edu.depaul.cdm.se.account.init;

import edu.depaul.cdm.se.account.persistence.Account;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
@LocalBean
public class StartupBean {

    // just to force accountPU to be initialized to force table creation
    @PersistenceContext(unitName = "accountPU")
    private EntityManager em;

    @PostConstruct
    public void init() {
        // Just to initialize the account to force creation of the tables
        Logger.getLogger(StartupBean.class.getName()).info("Startup initialized");
    }
}
