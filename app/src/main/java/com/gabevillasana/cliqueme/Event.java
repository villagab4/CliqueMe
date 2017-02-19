package com.gabevillasana.cliqueme;

/**
 * Created by gbotev on 2/18/17.
 */

public class Event {

    private String name;
    private String description;
    private String place;
    private String date;
    private String startTime;
    private String endTime;

    public Event(String name, String description, String place, String date, String startTime, String endTime) {
        this.name = name;
        this.description = description;
        this.place = place;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPlace() {
        return this.place;
    }

    public String getDate() {
        return this.date;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

}
