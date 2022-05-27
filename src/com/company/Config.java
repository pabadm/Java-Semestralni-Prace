package com.company;

public class Config {

    public static boolean flag = true;
    public static int IDStudentCount = 0;

    // --

    private static final String DIALOG_VARIATION_0 = "0. Exit";
    private static final String DIALOG_VARIATION_1 = "1. Přidát nové studenty";
    private static final String DIALOG_VARIATION_2 = "2. Nalezení jednotlivých studentů dle jejich ID";
    private static final String DIALOG_VARIATION_3 = "3. Propuštění studenta z univerzity";
    private static final String DIALOG_VARIATION_4 = "4. Print all students";
    private static final String DIALOG_VARIATION_5 = "5. Zadat studentovi novou známku";
    private static final String DIALOG_VARIATION_6 = "6. Pro vybraného studenta (dle ID) spustit jeho dovednost";
    private static final String DIALOG_VARIATION_7 = "7. Výpis obecného studijního průměru v technickém a humanitním oboru";
    private static final String DIALOG_VARIATION_8 = "8. Výpis poctu studentu v technickém a humanitním oboru";
    private static final String DIALOG_VARIATION_9 = "9. Abecedně řazený výpis všech studentů (dle příjmení) (NEFUNGUJE)";

    public static void DialogVariationPrint(int var) {
        switch (var) {
            case 0: System.out.println(DIALOG_VARIATION_0);
                break;
            case 1: System.out.println(DIALOG_VARIATION_1);
                break;
            case 2: System.out.println(DIALOG_VARIATION_2);
                break;
            case 3: System.out.println(DIALOG_VARIATION_3);
                break;
            case 4: System.out.println(DIALOG_VARIATION_4);
                break;
            case 5: System.out.println(DIALOG_VARIATION_5);
                break;
            case 6: System.out.println(DIALOG_VARIATION_6);
                break;
            case 7: System.out.println(DIALOG_VARIATION_7);
                break;
            case 8: System.out.println(DIALOG_VARIATION_8);
                break;
            case 9: System.out.println(DIALOG_VARIATION_9);
                break;
            default: System.out.println("DIALOG_VARIATION NOT FOUND");
                break;
        }
    }

}
