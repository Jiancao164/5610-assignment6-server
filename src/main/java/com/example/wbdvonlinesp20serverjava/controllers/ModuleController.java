package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Module;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ModuleController {

    @Autowired
    ModuleService moduleService;


    @GetMapping("/api/courses/{cid}/modules")
    public List<Module> findAllModules(@PathVariable Integer cid) {
        return moduleService.findAllModules(cid);
    }

    @GetMapping("/api/modules/{mid}")
    public Module findModuleById(@PathVariable Integer mid) {
        return moduleService.findModuleById(mid);
    }

    @PostMapping("/api/courses/{cid}/modules")
    public Module createModule(@PathVariable Integer cid, @RequestBody Module module) {
        return moduleService.createModule(cid, module);
    }

    @PutMapping("/api/modules/{mid}")
    public int updateModule(@PathVariable int mid, @RequestBody Module module) {
        return moduleService.updateModule(mid, module);
    }
    @DeleteMapping("api/modules/{mid}")
    public int deleteModule(@PathVariable int mid) {
        return moduleService.deleteModule(mid);
    }
}
