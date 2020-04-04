package com.example.wbdvonlinesp20serverjava.services;

import com.example.wbdvonlinesp20serverjava.models.Lesson;
import com.example.wbdvonlinesp20serverjava.models.Topic;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.LessonRepository;
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
    LessonRepository lessonRepository;

    public List<Topic> findAllTopics(int lid) {
        return topicRepository.findAllTopics(lid);
    }

    public Topic findTopicById(int tid) {
        return topicRepository.findTopicById(tid);
    }

    public int deleteTopic(int tid) {
        topicRepository.deleteById(tid);
        return 1;
    }

    public int updateTopic(int tid, Topic newTopic) {
        Topic oldTopic = topicRepository.findTopicById(tid);
        oldTopic.setTitle(newTopic.getTitle());
        topicRepository.save(oldTopic);
        return 1;
    }

    public Topic createTopic(int lid, Topic newTopic) {
        Lesson lesson = lessonRepository.findLessonById(lid);
        newTopic.setLesson(lesson);
        return topicRepository.save(newTopic);
    }

}
