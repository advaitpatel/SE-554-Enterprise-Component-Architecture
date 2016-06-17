/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.student;

import javax.ejb.Stateless;

/**
 *
 * @author Advait
 */
@Stateless
public interface StudentSessionBeanInterface {
    public abstract boolean add(
                String name, 
                String email_id,
                String level,
                String username,
                String password);
    
    
}
