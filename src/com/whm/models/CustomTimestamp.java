package com.whm.models;

public class CustomTimestamp {
    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;
    private int second;



    public CustomTimestamp(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String getPrettyTimestamp() {
        return this.day + " "
                + this.month + " "
                + this.year + " "
                + this.hour + ":"
                + this.minute + ":"
                + this.second;
    }

    public String getTimestampAsCSV() {
        return this.year + ","
                + this.month + ","
                + this.day + ","
                + this.hour + ","
                + this.minute + ","
                + this.second;
    }
}
