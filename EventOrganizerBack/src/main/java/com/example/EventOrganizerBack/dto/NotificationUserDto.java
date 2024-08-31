package com.example.EventOrganizerBack.dto;

public class EventUserDto {
    //the response object for the event user
    //  type: string;
    //  emitter: string;
    //  eventTitle: string;
    //  date: string;
    //  time: string;

    private String type;
    private String emitter;
    private String eventTitle;
    private String date;
    private String time;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmitter() {
        return emitter;
    }

    public void setEmitter(String emitter) {
        this.emitter = emitter;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
