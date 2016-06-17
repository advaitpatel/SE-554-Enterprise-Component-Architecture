/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.jms;

/**
 *
 * @author Advait
 */

import java.util.List;

import javax.ejb.Local;

@Local
public interface ReceiverRepo 
{
    void addCourse(String message);
    List<String> getCourses();
    int getCourseCount();
    
}
