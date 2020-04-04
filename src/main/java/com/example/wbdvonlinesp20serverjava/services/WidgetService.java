package com.example.wbdvonlinesp20serverjava.services;

import com.example.wbdvonlinesp20serverjava.models.Topic;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.TopicRepository;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public List<Widget> findAllWidgets(int tid) {
        return widgetRepository.findAllWidgets(tid);
    }

    public Widget findWidgetById(int tid) {
        return widgetRepository.findWidgetById(tid);
    }

    public int deleteWidget(int tid) {
        widgetRepository.deleteById(tid);
        return 1;
    }

    public int updateWidget(int tid, Widget newWidget) {
        Widget oldWidget = widgetRepository.findWidgetById(tid);
        oldWidget.setTitle(newWidget.getTitle());
        oldWidget.setText(newWidget.getText());
        oldWidget.setDisplay(newWidget.getDisplay());
        oldWidget.setSize(newWidget.getSize());
        oldWidget.setPosition(newWidget.getPosition());
        oldWidget.setType(newWidget.getType());
        oldWidget.setSrc(newWidget.getSrc());

        widgetRepository.save(oldWidget);
        return 1;
    }

    public Widget createWidget(int tid, Widget newWidget) {
        Topic topic = topicRepository.findTopicById(tid);
        newWidget.setTopic(topic);
        return widgetRepository.save(newWidget);
    }

}
