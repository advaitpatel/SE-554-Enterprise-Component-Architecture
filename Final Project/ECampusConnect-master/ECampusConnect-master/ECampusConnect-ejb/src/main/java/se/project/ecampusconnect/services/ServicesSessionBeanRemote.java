/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.services;

/**
 *
 * @author Advait
 */
import javax.ejb.Remote;

@Remote
public interface ServicesSessionBeanRemote 
{
    void addServices(String name, String department);
    String searchServices(String name);
    void updateServices(String name, String department);
    void deleteServices(String name);
}
