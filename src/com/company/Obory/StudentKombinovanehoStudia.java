package com.company.Obory;

import com.company.Models.Student;
import com.company.Service.ZkouskaPrestupnyRok;
import com.company.Service.ZkouskaZnameniZverokruhu;

import java.util.ArrayList;

public class StudentKombinovanehoStudia extends Student {

    private static double OborPrumer = 0;
    private static int studentCount = 0;
    private static ArrayList<Integer> listOfMarks = new ArrayList<Integer>();

    public StudentKombinovanehoStudia(int id, String name, String surname, int d, int m, int y, OborEnum obor) {
        super(id, name, surname, d, m, y, obor);
    }

    @Override
    public void PrintStudentInfo() {
        ZkouskaPrestupnyRok.Test(super.getDate());
        ZkouskaZnameniZverokruhu.Test(super.getDate());
    }

    public static void addStudentsMark(int mark) {
        listOfMarks.add(mark);

        double count = 0;
        for (Integer studMark : listOfMarks) {
            count = studMark + count;
        }

        OborPrumer = count / listOfMarks.size();
    }

    public static double getOborPrumer() {
        return OborPrumer;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void addStudent() {
        studentCount += 1;
    }

    public static void dellStudent() {
        studentCount -= 1;
    }
}
