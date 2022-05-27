package com.company.Models;

public class BirthDate {

    private int day, month, year;

    public BirthDate (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay () {
        return day;
    }

    public int getMonth () {
        return month;
    }

    public int getYear () {
        return year;
    }
}
