package my.mimos.udemyapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.mimos.udemyapi.entity.Course;
import my.mimos.udemyapi.entity.Lesson;
import my.mimos.udemyapi.service.UdemyService;

@RestController
@RequestMapping("/api")
public class UdemyController {
	
	private UdemyService udemyService;
	
	public UdemyController(UdemyService theUdemyService) {
		udemyService = theUdemyService;
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return udemyService.getAllCourses();
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course newCourse) {
		newCourse.setId(0);
		udemyService.addCourse(newCourse);
		return newCourse;
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable int id) {
		return udemyService.getCourseById(id);
	}
	
	
	@PostMapping("/courses/{courseId}/lessons")
	public Lesson addLesson(@PathVariable int courseId, @RequestBody Lesson newLesson) {
		Course course = udemyService.getCourseById(courseId);
		newLesson.setCourse(course);
		newLesson.setId(0);
		udemyService.addLesson(newLesson);
		return newLesson;
	}
	
	@GetMapping("/courses/{courseId}/lessons")
	public List<Lesson> getAllLessonByCourse(@PathVariable int courseId){
		return udemyService.getLessonByCourse(courseId);
	}
	
	
	

}
