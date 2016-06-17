package Webservices;

import java.util.HashMap;
import java.util.Map;

public enum CourseDao {
	instance;

	private Map<String, Course> courses = new HashMap<String, Course>();

	private CourseDao() {

		Course course = new Course("1", "SE 452", "Graduate");
		courses.put("1", course);
		
                course = new Course("2", "SE 554", "Graduate");
		courses.put("2", course);
                
                course = new Course("3", "CSC 401", "Graduate");
		courses.put("3", course);
                
                course = new Course("4", "CSC 402", "Graduate");
		courses.put("4", course);
                
                course = new Course("5", "CSC 403", "Graduate");
		courses.put("5", course);
                
                course = new Course("6", "CSC 404", "Graduate");
		courses.put("6", course);
                
                course = new Course("7", "CSC 405", "Graduate");
		courses.put("7", course);
                
                course = new Course("8", "CSC 406", "Graduate");
		courses.put("8", course);
                
                course = new Course("9", "CSC 407", "Graduate");
		courses.put("9", course);
                
                course = new Course("10", "CSC 408", "Graduate");
		courses.put("10", course);

	}

	public Map<String, Course> getCourses() {
		return courses;
	}

}
