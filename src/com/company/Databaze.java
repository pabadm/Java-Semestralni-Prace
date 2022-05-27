package com.company;

import com.company.Models.Student;
import com.company.Obory.OborEnum;
import com.company.Obory.StudentHumanitnihoOboru;
import com.company.Obory.StudentKombinovanehoStudia;
import com.company.Obory.StudentTechnickehoOboru;

import java.util.ArrayList;
import java.util.Collections;

public class Databaze {

    public ArrayList<Student> listOfStudents;

//    public ArrayList<StudentTechnickehoOboru> listOfStudentsTechnickehoOboru = new ArrayList<StudentTechnickehoOboru>();
//    public ArrayList<StudentHumanitnihoOboru> listOfStudentHumanitnihoOboru = new ArrayList<StudentHumanitnihoOboru>();
//    public ArrayList<StudentKombinovanehoStudia> listOfStudentKombinovanehoStudia = new ArrayList<StudentKombinovanehoStudia>();

    public Databaze() {
        this.listOfStudents = new ArrayList<Student>();
    }

    public ArrayList<Student> getListOfElements() {
        return listOfStudents;
    }

    public void AddNewStudent(int id, String name, String surnmae, int d, int m, int y, OborEnum obor) {
        switch (obor) {
            case Technicky -> this.listOfStudents.add(new StudentTechnickehoOboru(id, name, surnmae, d, m, y, obor));
            case Humanitni -> this.listOfStudents.add(new StudentHumanitnihoOboru(id, name, surnmae, d, m, y, obor));
            case Kombinovany -> this.listOfStudents.add(new StudentKombinovanehoStudia(id, name, surnmae, d, m, y, obor));
        }
        System.out.println("Новый студент добавлен в систему с ID: " + id);
    }

    public void DeleteStudentByID(int ID) {
        try {
            this.listOfStudents.remove(FindStudentByID(ID));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void PrintStudentPersonalInfo(int ID) {
        try {
            this.listOfStudents.get(FindStudentByID(ID)).PrintStudentPersonalInfo();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void PrintStudentInfo(int ID) {
        try {
            this.listOfStudents.get(FindStudentByID(ID)).PrintStudentInfo();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void AddNewMark(int ID, int mark) {
        try {
            this.listOfStudents.get(FindStudentByID(ID)).AddNewMark(mark);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int FindStudentByID(int ID) {
        for (Student student : this.listOfStudents) if (student.getId() == ID) return student.getId() + 1;
        return 0;
    }
}
