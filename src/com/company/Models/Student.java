package com.company.Models;

import com.company.Obory.OborEnum;

import java.util.ArrayList;

public abstract class Student {

    private int id;
    private String name, surname;
    private BirthDate date;
    private OborEnum obor;


    private ArrayList<Integer> listOfMarks = new ArrayList<Integer>();
    private double prumer = 0;

    // --

    public Student(int id, String name, String surname, int d, int m, int y, OborEnum obor) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = new BirthDate(d, m, y);
        this.obor = obor;
    }

    // --

    public void PrintStudentPersonalInfo() {
        System.out.println("--------------");
        System.out.println("Printing Student personal info: ");
        System.out.println("Student ID: " + this.id);
        System.out.println("Jmeno Prijmeni: " + this.name + " " + this.surname);
        System.out.println("Rok narozeni: " + this.date.getDay() + "." + this.date.getMonth() + "." + this.date.getYear());
        System.out.println("Studijni prumer: " + this.prumer);
        System.out.println("--------------");
    }

    public void AddNewMark(int mark) {
        this.listOfMarks.add(mark);
        CountStudPrumer();
    }

    private void CountStudPrumer() {
        double count = 0;
        for (Integer mark : this.listOfMarks) {
            count = mark + count;
        }

        this.prumer = count / this.listOfMarks.size();
    }

    public int getId() {
        return id;
    }

    public double getPrumer() {
        return this.prumer;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BirthDate getDate() {
        return date;
    }

    public OborEnum getObor() {
        return obor;
    }

    public abstract void PrintStudentInfo();
}
