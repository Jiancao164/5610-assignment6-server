package com.example.wbdvonlinesp20serverjava.repositories;

import com.example.wbdvonlinesp20serverjava.models.Topic;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository
        extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:topicId")
    public Topic findTopicById(
            @Param("topicId") int tid);

    @Query("SELECT topic FROM Topic topic")
    public List<Topic> findAllTopics();

    // "SELECT * FROM widgets WHERE topic_id=topicId
//    @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    @Query("select topic from Topic topic where topic.lessonId=:lid")
    public List<Topic> findTopicForLesson(
            @Param("lid") String lessonId);
}
