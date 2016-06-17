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
import javax.ejb.Remote;


@Remote
public interface AssistantServicesRemote {
    public void specialization();
}
