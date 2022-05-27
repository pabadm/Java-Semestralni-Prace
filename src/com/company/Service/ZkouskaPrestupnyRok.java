package com.company.Service;

import com.company.Models.BirthDate;

public class ZkouskaPrestupnyRok {

    public static void Test (BirthDate date) {
        if (((date.getYear() % 4 == 0) && (date.getYear() % 100 != 0)) || (date.getYear() % 400 == 0)) System.out.println("Je prestupny");
        else System.out.println("Neni prestupny");
    }

}
