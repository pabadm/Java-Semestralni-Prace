import java.util.Scanner;

import database.*;
import database.GroupEnum;

import NumberFilter.NumberFilter;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		NumberFilter numberFilter = new NumberFilter(sc);

		int choice;
		boolean run = true;

		Database database = new Database();
		// udelani databaze pro 3 skupiny
		database.setGroupDatabase(GroupEnum.Technical);
		database.setGroupDatabase(GroupEnum.Humanitarian);
		database.setGroupDatabase(GroupEnum.Combined);

		Menu menu = new Menu(database);

		while (run) {
			System.out.println("=================================");
			System.out.println("Choose the option:");
			System.out.println("1 .. Add new student");
			System.out.println("2 .. Add grade for student");
			System.out.println("3 .. Get info about the student");
			System.out.println("4 .. Delete student ");
			System.out.println("5 .. Get students list");
			System.out.println("6 .. Check student skill");
			System.out.println("7 .. Import database from File");
			System.out.println("8 .. Save database to File");
			System.out.println("9 .. Exit");
			System.out.println("=================================");

			choice = numberFilter.pouzeCelaCisla();
			switch (choice) {
			case 1:
				menu.addStudent();
				break;
			case 2:
				menu.addStudentGrade();
				break;
			case 3:
				menu.printStudentInfo();
				break;
			case 4:
				menu.deleteStudent();
				break;
			case 5:
				menu.printStudentList();
				break;
			case 6:
				menu.studentSkillCheck();
				break;
			case 7:
				menu.loadDatabaseFromFile();
				break;
			case 8:
				menu.saveDatabaseToFile();
				break;
			case 9:
				run = false;
				break;
			}

		}
	}

}