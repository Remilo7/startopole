package com.startopole.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    private int id;

    @Column
    private String eventName;

    @Column
    private String calendar;

    @Column
    private String color;

    @Column
    private String date;

    public Event() {
    }

    public Event(String eventName, String calendar, String color, String date) {
        this.eventName = eventName;
        this.calendar = calendar;
        this.color = color;
        this.date = date;
    }

    public Event(int id, String eventName, String calendar, String color, String date) {
        this.id = id;
        this.eventName = eventName;
        this.calendar = calendar;
        this.color = color;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
