package Webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseService {

	CourseDao courseDao;

	public CourseService() {
		courseDao = CourseDao.instance;
	}

	public void createCourse(Course course) {
		courseDao.getCourses().put(course.getId(), course);
	}

	public Course getCourse(String id) {
		return courseDao.getCourses().get(id);
	}

	public Map<String, Course> getCourses() {
		return courseDao.getCourses();
	}

	public List<Course> getCourseAsList() {
		List<Course> courseList = new ArrayList<Course>();
		courseList.addAll(courseDao.getCourses().values());
		return courseList;
	}

	public int getCoursesCount() {
		return courseDao.getCourses().size();
	}

	public void deleteCourse(String id) {
		courseDao.getCourses().remove(id);
	}

}
