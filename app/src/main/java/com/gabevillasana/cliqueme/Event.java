package com.gabevillasana.cliqueme;

/**
 * Created by gbotev on 2/18/17.
 */

public class Event {

    private String title;
    private String location;
    private String date;
    private String startTime;
    private String endTime;

    public Event(String title, String location, String date, String startTime, String endTime) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
