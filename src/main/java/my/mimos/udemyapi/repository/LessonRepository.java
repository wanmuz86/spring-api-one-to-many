package my.mimos.udemyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.mimos.udemyapi.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
