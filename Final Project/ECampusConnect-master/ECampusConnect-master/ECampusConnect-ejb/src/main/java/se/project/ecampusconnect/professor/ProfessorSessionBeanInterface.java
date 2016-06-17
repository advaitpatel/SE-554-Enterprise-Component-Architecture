/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.professor;

import javax.ejb.Stateless;

/**
 *
 * @author Advait
 */
@Stateless
public interface ProfessorSessionBeanInterface 
{
    public abstract boolean add(
             String name, 
             String email, 
             String dept);
    
}
