package com.company;

import com.company.Models.Student;
import com.company.Obory.OborEnum;
import com.company.Obory.StudentHumanitnihoOboru;
import com.company.Obory.StudentKombinovanehoStudia;
import com.company.Obory.StudentTechnickehoOboru;

import java.util.Scanner;

public class loop {

    private static Databaze databaze = new Databaze();

    private static Scanner scanner = new Scanner(System.in);
    private static int cmd;

    public static void start() {
        while (Config.flag) {
            MenuPrinter();
            cmd = scanner.nextInt();
            switch (cmd) {
                case 0:
                    System.out.println("Exit!");
                    Config.flag = false;
                    break;
                case 1:
                    System.out.println("Add new student to database");
                    AddStudentToDatabase();
                    break;
                case 2:
                    System.out.println("Print student personal info");

                    System.out.print("ID studenta: ");
                    cmd = scanner.nextInt();
                    PrintStudentPersonalInfoByID(cmd);
                    break;
                case 3:
                    System.out.println("Delete student from database");

                    System.out.print("ID studenta: ");
                    cmd = scanner.nextInt();
                    DeleteStudentByID(cmd);
                    break;
                case 4:
                    System.out.println("Print all students");
                    PrintAllStudents();
                    break;
                case 5:
                    System.out.println("Add new mark");

                    System.out.print("ID studenta: ");
                    int id = scanner.nextInt();
                    System.out.print("Mark: ");
                    int mark = scanner.nextInt();
                    FindStudentByID(id).AddNewMark(mark);

                    switch (FindStudentByID(id).getObor()) {
                        case Technicky -> StudentTechnickehoOboru.addStudentsMark(mark);
                        case Humanitni -> StudentHumanitnihoOboru.addStudentsMark(mark);
                        case Kombinovany -> StudentKombinovanehoStudia.addStudentsMark(mark);
                    }

                    break;
                case 6:
                    cmd = scanner.nextInt();
                    PrintStudentSpecialInfoByID(cmd);
                    break;
                case 7:
                    VypisObecnehoStudijnihoPrumeru();
                    break;
                case 8:
                    getStudentsOborCount();
                    break;
            }
        }
    }

    private static void AddStudentToDatabase() {
        OborEnum obor = null;
        String name = null;
        String surname = null;
        int d, m, y;

        System.out.println("Vyberte si obor: ");
        System.out.println("1. Technicky: ");
        System.out.println("2. Humanitni: ");
        System.out.println("3. Kombinovany ");
        cmd = scanner.nextInt();
        switch (cmd) {
            case 1:
                obor = OborEnum.Technicky;
                StudentTechnickehoOboru.addStudent();
                break;
            case 2:
                obor = OborEnum.Humanitni;
                StudentHumanitnihoOboru.addStudent();
                break;
            case 3:
                obor = OborEnum.Kombinovany;
                StudentKombinovanehoStudia.addStudent();
                break;
            default: System.out.println("Error");
                break;
        }

        //--

        System.out.print("Jmeno: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Prijmeni: ");
        surname = scanner.nextLine();

        System.out.print("den: ");
        d = scanner.nextInt();
        System.out.print("mesic: ");
        m = scanner.nextInt();
        System.out.print("rok: ");
        y = scanner.nextInt();

        databaze.AddNewStudent(Config.IDStudentCount, name, surname, d, m, y, obor);
        Config.IDStudentCount++;
    }

    private static void PrintStudentPersonalInfoByID (int id) {
        FindStudentByID(id).PrintStudentPersonalInfo();
    }

    private static void PrintStudentSpecialInfoByID(int id) {
        FindStudentByID(id).PrintStudentInfo();
    }

    private static void PrintAllStudents () {
        for (Student student : databaze.listOfStudents) {
            System.out.println(student.getSurname() + " " + student.getName() + "(" + student.getId() + ")");
        }
    }

    private static void DeleteStudentByID(int id) {
        databaze.listOfStudents.remove(FindStudentByID(id));
        switch (FindStudentByID(id).getObor()) {
            case Technicky -> StudentTechnickehoOboru.dellStudent();
            case Humanitni -> StudentHumanitnihoOboru.dellStudent();
            case Kombinovany -> StudentKombinovanehoStudia.dellStudent();
        }
    }

    private static Student FindStudentByID(int id) {
        for (Student student : databaze.listOfStudents) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static void VypisObecnehoStudijnihoPrumeru() {
        System.out.println("Studijni prumer technickeho oboru: " + StudentTechnickehoOboru.getOborPrumer());
        System.out.println("Studijni prumer humanitniho oboru: " + StudentHumanitnihoOboru.getOborPrumer());
        System.out.println("Studijni prumer kombinovaneho oboru: " + StudentKombinovanehoStudia.getOborPrumer());
    }

    private static void getStudentsOborCount() {
        System.out.println("Pocet studentu Technickeho oboru: " + StudentTechnickehoOboru.getStudentCount());
        System.out.println("Pocet studentu Humanitniho oboru: " + StudentHumanitnihoOboru.getStudentCount());
        System.out.println("Pocet studentu Kombinovaneho oboru: " + StudentKombinovanehoStudia.getStudentCount());
    }

    private static void MenuPrinter() {
        System.out.println("----");
        Config.DialogVariationPrint(0);
        Config.DialogVariationPrint(1);
        Config.DialogVariationPrint(2);
        Config.DialogVariationPrint(3);
        Config.DialogVariationPrint(4);
        Config.DialogVariationPrint(5);
        Config.DialogVariationPrint(6);
        Config.DialogVariationPrint(7);
        Config.DialogVariationPrint(8);
        Config.DialogVariationPrint(9);
        System.out.println("----");
    }
}
