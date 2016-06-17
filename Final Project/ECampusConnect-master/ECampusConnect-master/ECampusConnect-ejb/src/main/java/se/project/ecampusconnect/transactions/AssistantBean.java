/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.transactions;

/**
 *
 * @author Advait
 */
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AssistantBean implements AssistantServicesLocal, AssistantServicesRemote {

    @PersistenceContext(unitName = "AssistantService")
    private EntityManager em;
    @Resource
    UserTransaction tx;

    @Override
    public void specialization() {
        try {
            try {
                tx.begin();
                System.out.println("Processing...");
            } finally {
                tx.commit();
            }
        } catch (Exception e) {
            throw new EJBException(e);
        }

    }

}
