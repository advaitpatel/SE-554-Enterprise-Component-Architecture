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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
@Lock(LockType.READ)
public class ReceiverImpl implements ReceiverRepo{

    private List<String> courses;
    
    @PostConstruct
	void init() {
		courses = new ArrayList<String>();
	}
    
    @Lock(LockType.WRITE)
    @Override
    public void addCourse(String course) {
        courses.add(course);
    }

    @Override
    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    @Override
    public int getCourseCount() {
        return courses.size();
    }
    
}
