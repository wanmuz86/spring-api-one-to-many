package my.mimos.udemyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.mimos.udemyapi.entity.Course;
import my.mimos.udemyapi.entity.Lesson;
import my.mimos.udemyapi.repository.CourseRepository;
import my.mimos.udemyapi.repository.LessonRepository;

@Service
public class UdemyServiceImpl implements UdemyService{
	
	private CourseRepository courseRepo;
	private LessonRepository lessonRepo;
	
	
	@Autowired
	public UdemyServiceImpl(CourseRepository theCourseRepo, 
			LessonRepository theLessonRepo) {
		courseRepo = theCourseRepo;
		lessonRepo = theLessonRepo;
	}
	
	// TODO - 1) getAllCourses, saveCourse,  getCourseById 
	
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	public void addCourse(Course course) {
		
		courseRepo.save(course);
	}
	
	public Course getCourseById(int id) {
		
		Optional<Course> optionalCourse = courseRepo.findById(id);
		Course searchedCourse = null;
		if (optionalCourse.isPresent()) {
			searchedCourse = optionalCourse.get();
		}
		else {
			throw new RuntimeException("Course not found");
		}
		return searchedCourse;
	}

	@Override
	public List<Lesson> getLessonByCourse(int courseId) {
		Course course = getCourseById(courseId);
		return course.getLessons();
	}

	@Override
	public void addLesson(Lesson lesson) {
		
		lessonRepo.save(lesson);
		
	}

}
