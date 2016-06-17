/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.professor;

import javax.persistence.EntityManager;
import se.project.ecampusconnect.main.SessionBean;

/**
 *
 * @author Advait
 */
public class ProfessorSessionBean extends SessionBean implements ProfessorSessionBeanInterface{

    EntityManager em;
    
    @Override
    public boolean add(String name, String email, String dept) {
        
        Instructor inst = new Instructor();
        inst.setName(name);
        inst.setEmail(email);
        inst.setDepartment(dept);
        
        //open link to db
            this.openEntityManager();
            
            //add course to database
            em.getTransaction().begin();
            em.persist( inst );
            em.getTransaction( ).commit( );

            //close link to db
            this.closeEntityManager();
            
            //student has been sucessfully added to database
            return true;
        
    }
    
}
