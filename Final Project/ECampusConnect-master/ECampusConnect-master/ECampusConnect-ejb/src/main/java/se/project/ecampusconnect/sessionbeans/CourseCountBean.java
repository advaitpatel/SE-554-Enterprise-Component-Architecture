/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.sessionbeans;

/**
 *
 * @author Advait
 */
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton(name = "CourseCount")
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class CourseCountBean {

    private int courseCount = 0;

    @Lock(LockType.WRITE)
    public void incrementCourseCount() {
        courseCount++;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void resetCounter() {
        courseCount = 0;
    }

    @PostConstruct
    public void applicationStartup() {
        System.out.println("From application startup method.");
        resetCounter();
    }

    @PreDestroy
    public void applicationShutdown() {
        System.out.println("From application shutdown method");
    }

}
