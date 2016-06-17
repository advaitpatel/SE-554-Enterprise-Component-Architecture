package edu.depaul.cdm.se.account.service.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import edu.depaul.cdm.se.account.persistence.Account;

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts {
    @XmlElement(name = "account")
    private List<Account> accounts = new ArrayList<Account>();
    
    public Accounts() {}
    
    public Accounts(List<Account> acts) {
        this.accounts = acts;
    }
}
