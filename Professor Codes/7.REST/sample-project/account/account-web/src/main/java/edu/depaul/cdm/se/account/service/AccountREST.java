package edu.depaul.cdm.se.account.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("account")
public class AccountREST {

    @EJB(lookup = "java:global/account-ear/account-ejb-7.9.1/AccountService")
    private AccountServiceRemote accountRemote;

    public AccountREST() {

        /* Not exactly sure why the @EJB is not being resolved for JAX-RS but was being
        resolved for JAX-WS and so adding manual lookup
        */
        InitialContext c;
        try {
            c = new InitialContext();
            accountRemote = (AccountServiceRemote) c.lookup("java:global/account-ear/account-ejb-7.9.1/AccountService");
        } catch (NamingException ex) {
            Logger.getLogger(AccountREST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @POST
    @Path("/add")
    public Response openAccount(@FormParam("name") String name,
            @FormParam("init_bal") float initialBalance) throws NegativeBalanceException {
        long accntNbr = accountRemote.openAccount(name, initialBalance);

        return Response.status(Response.Status.OK)
                .entity("account_num: " + accntNbr).build();
    }

    @GET
//    @Produces({"application/json"})
    public String findAll() {
        System.out.println("get all");
        return accountRemote.getAllAccounts().toString();
    }

}
