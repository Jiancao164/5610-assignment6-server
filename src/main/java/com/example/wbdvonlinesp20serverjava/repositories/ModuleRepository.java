package com.example.wbdvonlinesp20serverjava.repositories;

import com.example.wbdvonlinesp20serverjava.models.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository
        extends CrudRepository<Module, Integer> {

    @Query("SELECT module FROM Module module WHERE module.id=:moduleId")
    public Module findModuleById(
            @Param("moduleId") int mid);

    @Query("select module from Module module where module.course.id=:cid")
    public List<Module> findAllModules(
            @Param("cid") int courseId);


}
