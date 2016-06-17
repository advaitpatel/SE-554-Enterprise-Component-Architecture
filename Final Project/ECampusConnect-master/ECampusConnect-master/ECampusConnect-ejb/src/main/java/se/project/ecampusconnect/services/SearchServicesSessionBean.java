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
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@WebService(serviceName = "DePaulDepartmentServices")
@TransactionManagement(TransactionManagementType.BEAN)
public class SearchServicesSessionBean implements ServicesSessionBeanRemote {
    
    @PersistenceContext(unitName = "HandbookJSPU")
    private EntityManager entityManager;
    
    @WebMethod(operationName = "addServices")
    public void addServices(String name, String department) {
        ServiceEntity inputDefenition = new ServiceEntity();
        inputDefenition.setName(name);
        inputDefenition.setDepartment(department);
        entityManager.persist(inputDefenition);
        
    }
    
    @WebMethod(operationName = "searchServices")
    public String searchServices(String name) {
        Query selectQuery = entityManager.createNativeQuery(
                "SELECT services FROM \"Services\" WHERE name = '" + name + "'");
        List<String> resultList = selectQuery.getResultList();
        
        String allServices = "";
        for (String resultDefenition : resultList) {
            allServices = allServices + "<br>" + name + " - " + resultDefenition;
        }
        return allServices;
    }
    
    @WebMethod(operationName = "updateServices")
    public void updateServices(String name, String department) 
    {
        Query updateQuery = entityManager.createNativeQuery("UPDATE \"Services\" SET department = '" + department
				+ "' WHERE name = '" + name + "'");
		updateQuery.executeUpdate();
        
    }
    
    @WebMethod(operationName = "deleteServices")
    public void deleteServices(String name) 
    {
        Query deleteQuery = entityManager
				.createNativeQuery("DELETE FROM \"Services\" WHERE name = '" + name + "'");
		deleteQuery.executeUpdate();
        
    }
    
}
