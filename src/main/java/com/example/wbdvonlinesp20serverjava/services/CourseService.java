package com.example.wbdvonlinesp20serverjava.services;

import com.example.wbdvonlinesp20serverjava.models.Course;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.CourseRepository;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    WidgetRepository widgetRepository;

    public List<Course> findAllCourses() {
        return courseRepository.findAllCourses();
    }

    public Course findCourseById(int cid) {
        return courseRepository.findCourseById(cid);
    }

    public int deleteCourse(int cid) {
        courseRepository.deleteById(cid);
        return 1;
    }

    public int updateCourse(int cid, Course newCourse) {
        Course oldCourse = courseRepository.findCourseById(cid);
        oldCourse.setTitle(newCourse.getTitle());
        courseRepository.save(oldCourse);
        return 1;
    }

    public Course createCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }

}
