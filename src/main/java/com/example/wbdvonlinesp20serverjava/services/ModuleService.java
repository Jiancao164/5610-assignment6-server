package com.example.wbdvonlinesp20serverjava.services;

import com.example.wbdvonlinesp20serverjava.models.Course;
import com.example.wbdvonlinesp20serverjava.models.Module;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.CourseRepository;
import com.example.wbdvonlinesp20serverjava.repositories.ModuleRepository;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Module> findAllModules(int cid) {
        return moduleRepository.findAllModules(cid);
    }

    public Module findModuleById(int mid) {
        return moduleRepository.findModuleById(mid);
    }

    public int deleteModule(int mid) {
        moduleRepository.deleteById(mid);
        return 1;
    }

    public int updateModule(int mid, Module newModule) {
        Module oldModule = moduleRepository.findModuleById(mid);
        oldModule.setTitle(newModule.getTitle());
        moduleRepository.save(oldModule);
        return 1;
    }

    public Module createModule(int cid, Module newModule) {
        Course course = courseRepository.findCourseById(cid);
        newModule.setCourse(course);
        return moduleRepository.save(newModule);
    }

}
