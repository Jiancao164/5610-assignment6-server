package com.example.wbdvonlinesp20serverjava.repositories;

import com.example.wbdvonlinesp20serverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {

    @Query("SELECT widget FROM Widget widget WHERE widget.id=:widgetId")
    public Widget findWidgetById(
            @Param("widgetId") int wid);

    @Query("select widget from Widget widget where widget.topic.id=:tid")
    public List<Widget> findAllWidgets(
            @Param("tid") int topicId);


}
