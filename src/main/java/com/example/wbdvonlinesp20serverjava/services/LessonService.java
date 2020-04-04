package com.example.wbdvonlinesp20serverjava.services;

import com.example.wbdvonlinesp20serverjava.models.Module;
import com.example.wbdvonlinesp20serverjava.models.Lesson;
import com.example.wbdvonlinesp20serverjava.repositories.ModuleRepository;
import com.example.wbdvonlinesp20serverjava.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    ModuleRepository moduleRepository;

    public List<Lesson> findAllLessons(int mid) {
        return lessonRepository.findAllLessons(mid);
    }

    public Lesson findLessonById(int lid) {
        return lessonRepository.findLessonById(lid);
    }

    public int deleteLesson(int lid) {
        lessonRepository.deleteById(lid);
        return 1;
    }

    public int updateLesson(int lid, Lesson newLesson) {
        Lesson oldLesson = lessonRepository.findLessonById(lid);
        oldLesson.setTitle(newLesson.getTitle());
        lessonRepository.save(oldLesson);
        return 1;
    }

    public Lesson createLesson(int mid, Lesson newLesson) {
        Module module = moduleRepository.findModuleById(mid);
        newLesson.setModule(module);
        return lessonRepository.save(newLesson);
    }

}
