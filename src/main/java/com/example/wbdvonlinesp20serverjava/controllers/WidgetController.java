package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService widgetService;


    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findAllWidgets(@PathVariable Integer tid) {
        return widgetService.findAllWidgets(tid);
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable Integer wid) {
        return widgetService.findWidgetById(wid);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable Integer tid, @RequestBody Widget widget) {
        return widgetService.createWidget(tid, widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable int wid, @RequestBody Widget widget) {
        return widgetService.updateWidget(wid, widget);
    }
    @DeleteMapping("api/widgets/{wid}")
    public int deleteWidget(@PathVariable int wid) {
        return widgetService.deleteWidget(wid);
    }
}
