package com.example.EventOrganizerBack.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class EventWithParticipentListDto {
    private Integer creatorId;
    private String description;
    private Date date;
    private Time time;
    private Integer capacity;
    private Boolean is_private;

    private String title;
    private String location;
    private List<String> participents;

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getIs_private() {
        return is_private;
    }

    public void setIs_private(Boolean is_private) {
        this.is_private = is_private;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getParticipents() {
        return participents;
    }

    public void setParticipents(List<String> participents) {
        this.participents = participents;
    }
}
