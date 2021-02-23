package com.whm.models;

public class CustomTimestamp implements Comparable<CustomTimestamp> {
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


    @Override
    public int compareTo(CustomTimestamp timestamp) {
        if(this == timestamp) {
            return 0;
        }

        if(this.year > timestamp.year) {
            return 1;
        }
        if(this.year < timestamp.year) {
            return -1;
        }

        if (this.month > timestamp.month) {
            return 1;
        }
        if (this.month < timestamp.month) {
            return -1;
        }

        if (this.day > timestamp.day) {
            return 1;
        }
        if (this.day < timestamp.day) {
            return -1;
        }

        if (this.hour > timestamp.hour) {
            return 1;
        }
        if (this.hour < timestamp.hour) {
            return -1;
        }

        if (this.minute > timestamp.minute) {
            return 1;
        }
        if (this.minute < timestamp.minute) {
            return -1;
        }

        if (this.second> timestamp.second) {
            return 1;
        }
        if (this.second < timestamp.second) {
            return -1;
        }

        return 0;
    }
}
