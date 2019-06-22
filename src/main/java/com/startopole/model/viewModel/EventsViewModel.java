package com.startopole.model.viewModel;

import java.util.List;

public class EventsViewModel {

    private int id;
    private String eventName;
    private String calendar;
    private String color;
    private String date;
    private List<Integer> categories;

    public EventsViewModel() {
    }

    public EventsViewModel(int id, String eventName, String calendar, String color, String date, List<Integer> categories) {
        this.id = id;
        this.eventName = eventName;
        this.calendar = calendar;
        this.color = color;
        this.date = date;
        this.categories = categories;
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

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }
}
