/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.student;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import se.project.ecampusconnect.main.SessionBean;



/**
 *
 * @author Advait
 */
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentSessionBean extends SessionBean implements StudentSessionBeanInterface
{
    EntityManager em;

    @Override
    public boolean add(String name, String email_id, String level, String username, String password) {
        
        Student student = new Student();
        student.setName(name);
        student.setEmail(email_id);
        student.setSlevel(level);
        student.setUsername(username);
        student.setPassowrd(password);
        
         //open link to db
            this.openEntityManager();
            
            //add course to database
            em.getTransaction().begin();
            em.persist( student );
            em.getTransaction( ).commit( );

            //close link to db
            this.closeEntityManager();
            
            //student has been sucessfully added to database
            return true;
    }

    
    
}
