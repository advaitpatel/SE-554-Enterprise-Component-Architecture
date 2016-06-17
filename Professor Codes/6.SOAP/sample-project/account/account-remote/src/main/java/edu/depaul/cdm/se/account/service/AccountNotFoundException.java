package edu.depaul.cdm.se.account.service;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String a) {
        super(a);
    }
    
    public AccountNotFoundException() {
        super();
    }
}
