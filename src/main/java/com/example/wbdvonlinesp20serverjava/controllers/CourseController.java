package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Course;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/api/courses/{tid}")
    public Course findCourseById(@PathVariable Integer tid) {
        return courseService.findCourseById(tid);
    }

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/api/courses/{cid}")
    public int updateCourse(@PathVariable int cid, @RequestBody Course course) {
        return courseService.updateCourse(cid, course);
    }
    @DeleteMapping("api/courses/{cid}")
    public int deleteCourse(@PathVariable int cid) {
        return courseService.deleteCourse(cid);
    }
}
