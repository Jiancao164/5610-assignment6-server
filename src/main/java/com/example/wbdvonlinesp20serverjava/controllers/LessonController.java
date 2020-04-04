package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Lesson;
import com.example.wbdvonlinesp20serverjava.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LessonController {

    @Autowired
    LessonService lessonService;


    @GetMapping("/api/modules/{mid}/lessons")
    public List<Lesson> findAllLessons(@PathVariable Integer mid) {
        return lessonService.findAllLessons(mid);
    }

    @GetMapping("/api/lessons/{lid}")
    public Lesson findLessonById(@PathVariable Integer lid) {
        return lessonService.findLessonById(lid);
    }

    @PostMapping("/api/modules/{mid}/lessons")
    public Lesson createLesson(@PathVariable Integer mid, @RequestBody Lesson lesson) {
        return lessonService.createLesson(mid, lesson);
    }

    @PutMapping("/api/lessons/{lid}")
    public int updateLesson(@PathVariable int lid, @RequestBody Lesson lesson) {
        return lessonService.updateLesson(lid, lesson);
    }
    @DeleteMapping("api/lessons/{lid}")
    public int deleteLesson(@PathVariable int lid) {
        return lessonService.deleteLesson(lid);
    }
}
