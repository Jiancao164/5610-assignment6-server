package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Topic;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.TopicRepository;
import com.example.wbdvonlinesp20serverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicService topicService;


    @PostMapping("/api/topics/{tid}/widgets/discard")
    public Widget createWidgetForTopic(
            @PathVariable("tid") Integer tid,
            @RequestBody Widget newWidget) {
        return topicService.createWidgetForTopic(tid, newWidget);
    }
    @PostMapping("api/lessons/{lid}/topics")
    public Topic createTopicForLesson(
            @PathVariable("lid") String lessonId,
            @RequestBody Topic newTopic
    ) {
        newTopic.setLessonId(lessonId);
        return topicService.createTopic(newTopic);
    }



    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/api/topics/{tid}")
    public Topic findTopicById(@PathVariable Integer tid) {
        return topicService.findTopicById(tid);
    }
    @GetMapping("/api/lesson/{lid}/topics")
    public List<Topic> findTopicsForLesson(@PathVariable String lid) {
        return topicService.findTopicsForLesson(lid);
    }
    @PostMapping("/api/topics")
    public Topic createTopic(String lid, @RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }
    @PutMapping("/api/topics/{tid}")
    public int updateTopic(@PathVariable int tid, @RequestBody Topic topic) {
        return topicService.updateTopic(tid, topic);
    }
    @DeleteMapping("api/topics/{tid}")
    public int deleteTopic(@PathVariable int tid) {
        return topicService.deleteTopic(tid);
    }
}
