package com.example.wbdvonlinesp20serverjava.services;

import com.example.wbdvonlinesp20serverjava.models.Topic;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.TopicRepository;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;

    public List<Topic> findAllTopics() {
        return topicRepository.findAllTopics();
    }

    public List<Topic> findTopicsForLesson(String lid) { return topicRepository.findTopicForLesson(lid);}

    // TODO: implement findTopicById
    public Topic findTopicById(int tid) {
        return topicRepository.findTopicById(tid);
    }

    // TODO: delete topic
    public int deleteTopic(int tid) {
        topicRepository.deleteById(tid);
        return 1;
    }

    public int updateTopic(int tid, Topic newTopic) {
        Topic oldTopic = topicRepository.findTopicById(tid);
        oldTopic.setDescription(newTopic.getDescription());
        oldTopic.setTitle(newTopic.getTitle());
        topicRepository.save(oldTopic);
         return 1;
    }

    public Topic createTopic(Topic newTopic) {
        return topicRepository.save(newTopic);
    }

    public Widget createWidgetForTopic(
            Integer tid,
            Widget newWidget) {
        Topic topic = topicRepository.findById(tid).get();
        newWidget.setTopic(topic);
        return widgetRepository.save(newWidget);
    }
}
