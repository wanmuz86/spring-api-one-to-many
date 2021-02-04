package my.mimos.udemyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.mimos.udemyapi.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
