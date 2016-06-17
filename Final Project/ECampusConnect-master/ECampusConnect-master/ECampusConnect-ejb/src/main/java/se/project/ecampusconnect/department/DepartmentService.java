/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.department;

/**
 *
 * @author Advait
 */
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DepartmentService implements DepartmentServiceLocal, DepartmentServiceRemote {

    @EJB
    Department department;

    public DepartmentService() {

    }

    @Override
    public String service(String computer_science) 
    {
        
        String information_systems = department.getServices().get(computer_science);
        
        if(information_systems != null)
        {
            return information_systems;
        }
        else
        {
            return "not found.";
        }
        
    }

}
