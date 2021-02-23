package com.whm.models;

public class CustomTimestamp {
    private int day;
    private int month;
    private int year;

    private int hour;
    private int minute;
    private int second;

    public CustomTimestamp(int day, int month, int year, int hour, int minute, int second) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String getTimeStamp() {
        return this.day + " " + this.month + " " + this.year + " " + this.hour + ":" + this.minute + ":" + this.second;
    }
}
