package com.example.wbdvonlinesp20serverjava.repositories;

import com.example.wbdvonlinesp20serverjava.models.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository
        extends CrudRepository<Lesson, Integer> {

    @Query("SELECT lesson FROM Lesson lesson WHERE lesson.id=:lessonId")
    public Lesson findLessonById(
            @Param("lessonId") int lid);

    @Query("select lesson from Lesson lesson where lesson.module.id=:mid")
    public List<Lesson> findAllLessons(
            @Param("mid") int moduleId);


}
