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
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class SearchFacadeBean
 */
@Stateless(name = "SearchFacade")
public class SearchFacadeBean {

    List<String> courseList = new ArrayList<String>();

    public List<String> courseSearch(String courseType) {

        if (courseType.equals("Grad")) {
            courseList.add("SE 452");
            courseList.add("SE 554");
            courseList.add("SE 491");
            courseList.add("SE 447");
            courseList.add("SE 453");
        } else if (courseType.equals("Undergrad")) {
            courseList.add("SE 352");
            courseList.add("SE 344");
            courseList.add("SE 397");
            courseList.add("SE 347");
            courseList.add("SE 352");
            
        }
        return courseList;
    }
}
