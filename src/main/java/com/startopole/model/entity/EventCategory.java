package com.startopole.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "EVENTCATEGORIES")
public class EventCategory {

    @Id
    private int id;

    @Column
    private int event_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    public EventCategory() {
    }

    public EventCategory(int event_id, Category category_id) {
        this.event_id = event_id;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
