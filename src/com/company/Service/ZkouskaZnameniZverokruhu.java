package com.company.Service;

import com.company.Models.BirthDate;

public class ZkouskaZnameniZverokruhu {

    public static void Test (BirthDate date) {
        switch (date.getMonth()) {
            case 1:
                System.out.println(DateChecker(21, date.getDay(), "Vodnář", "Kozoroh"));
                break;
            case 2:
                System.out.println(DateChecker(19, date.getDay(), "Ryby", "Vodnář"));
                break;
            case 3:
                System.out.println(DateChecker(21, date.getDay(), "Beran", "Ryby"));
                break;
            case 4:
                System.out.println(DateChecker(21, date.getDay(), "Býk", "Beran"));
                break;
            case 5:
                System.out.println(DateChecker(21, date.getDay(), "Blíženci", "Býk"));
                break;
            case 6:
                System.out.println(DateChecker(21, date.getDay(), "Rak", "Blíženci"));
                break;
            case 7:
                System.out.println(DateChecker(23, date.getDay(), "Lev", "Rak"));
                break;
            case 8:
                System.out.println(DateChecker(23, date.getDay(), "Panna", "Lev"));
                break;
            case 9:
                System.out.println(DateChecker(23, date.getDay(), "Váhy", "Panna"));
                break;
            case 10:
                System.out.println(DateChecker(23, date.getDay(), "Štír", "Váhy"));
                break;
            case 11:
                System.out.println(DateChecker(22, date.getDay(), "Střelec", "Štír"));
                break;
            case 12:
                System.out.println(DateChecker(22, date.getDay(), "Kozoroh", "Střelec"));
                break;
            default:
                System.out.println("NONE");
        }
    }

    private static String DateChecker (int FirstDayZverokruh, int day, String StartVariant, String LastVariant) {
        if (day < FirstDayZverokruh) return LastVariant;
        if (day >= FirstDayZverokruh) return StartVariant;
        return null;
    }

}
