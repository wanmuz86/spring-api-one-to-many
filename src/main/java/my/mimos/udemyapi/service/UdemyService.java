package my.mimos.udemyapi.service;

import java.util.List;

import my.mimos.udemyapi.entity.Course;
import my.mimos.udemyapi.entity.Lesson;

public interface UdemyService {

	public List<Course> getAllCourses();
	public void addCourse(Course course);
	public Course getCourseById(int id);
	
	public List<Lesson> getLessonByCourse(int courseId);
	public void addLesson(Lesson lesson);
}
