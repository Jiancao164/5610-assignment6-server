package com.example.wbdvonlinesp20serverjava.repositories;

import com.example.wbdvonlinesp20serverjava.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository
        extends CrudRepository<Course, Integer> {

    @Query("SELECT course FROM Course course WHERE course.id=:courseId")
    public Course findCourseById(
            @Param("courseId") int tid);

    @Query("SELECT course FROM Course course")
    public List<Course> findAllCourses();


}
