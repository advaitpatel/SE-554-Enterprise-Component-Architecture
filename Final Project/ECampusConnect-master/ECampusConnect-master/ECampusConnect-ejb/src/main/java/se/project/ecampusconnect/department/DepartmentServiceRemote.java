/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.department;

import javax.ejb.Remote;

/**
 *
 * @author Advait
 */
@Remote
public interface DepartmentServiceRemote {

    String service(String computer_science);

}
