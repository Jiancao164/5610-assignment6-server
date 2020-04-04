package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Topic;
import com.example.wbdvonlinesp20serverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicService topicService;


    @GetMapping("/api/lessons/{lid}/topics")
    public List<Topic> findAllTopics(@PathVariable Integer lid) {
        return topicService.findAllTopics(lid);
    }

    @GetMapping("/api/topics/{tid}")
    public Topic findTopicById(@PathVariable Integer tid) {
        return topicService.findTopicById(tid);
    }

    @PostMapping("/api/lessons/{lid}/topics")
    public Topic createTopic(@PathVariable Integer lid, @RequestBody Topic topic) {
        return topicService.createTopic(lid, topic);
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
