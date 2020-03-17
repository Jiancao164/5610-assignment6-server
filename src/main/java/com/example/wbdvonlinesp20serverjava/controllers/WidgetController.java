package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import com.example.wbdvonlinesp20serverjava.services.TopicService;
import com.example.wbdvonlinesp20serverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;

    @Autowired
    TopicService topicService;


    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") int widgetId,
                            @RequestBody Widget widget) {
        return service.updateWidget(widgetId, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") int widgetId) {
        return service.deleteWidget(widgetId);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable Integer tid, @RequestBody Widget newWidget) {
        return topicService.createWidgetForTopic(tid, newWidget);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") int wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") int tid) {
        System.out.println(tid);
        return service.findWidgetsForTopic(tid);
    }

}
