package edu.depaul.cdm.se.account.service;

import edu.depaul.cdm.se.account.service.xml.Accounts;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Adding web service to Account and forwarding to EJB
 */
@WebService
public class Account {
    @EJB
    private AccountServiceRemote accountRemote;
    
    @WebMethod
    public long openAccount(String name, float initialBalance) throws NegativeBalanceException {
        return accountRemote.openAccount(name, initialBalance);
    }

    @WebMethod
    public float deposit(long accountNumber, float amount)
            throws NegativeBalanceException, AccountNotFoundException {
       return accountRemote.deposit(accountNumber, amount);
    }
        
    @WebMethod    
    public float withdraw(long accountNumber, float amount)
            throws NegativeBalanceException, InsufficientBalanceException, AccountNotFoundException {
       return accountRemote.withdraw(accountNumber, amount);
    }

    @WebMethod
    public float close(long accountNumber)
            throws InsufficientBalanceException, AccountNotFoundException {
       return accountRemote.close(accountNumber);
    }
    

    @WebMethod
    public void transferFunds(long fromAccountNumber, long toAccountNumber, float amount)
            throws AccountNotFoundException, NegativeBalanceException, InsufficientBalanceException{ 
       accountRemote.transferFunds(fromAccountNumber, toAccountNumber, amount);
    }
    
    @WebMethod
    public Accounts getAllAccounts() {
        Accounts accounts = new Accounts();
        return new Accounts(accountRemote.getAllAccounts());
    };

}