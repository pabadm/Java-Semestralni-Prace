import database.GroupEnum;
import database.Database;
import database.GroupDatabase;
import database.Student;
import tests.LeapTest;
import tests.ZodiacTest;

import java.util.Scanner;
import java.io.*;

import NumberFilter.NumberFilter;

public class Menu {

	Database database;

	private Scanner sc = new Scanner(System.in);
	private NumberFilter numberFilter = new NumberFilter(sc);
	private int GLOBAL_ID = 0;

	Menu(Database database) {
		this.database = database;
	}

	public void setGLOBAL_ID(int ID) {
		this.GLOBAL_ID = ID;
	}

	public int getGLOBAL_ID() {
		return GLOBAL_ID;
	}

	public static GroupEnum getGroupEnum(int cislo) {
		switch (cislo) {
		case 1:
			return GroupEnum.Technical;
		case 2:
			return GroupEnum.Humanitarian;
		case 3:
			return GroupEnum.Combined;
		}
		return GroupEnum.Technical;
	}

	public static int getGroupID(GroupEnum groupEnum) {
		switch (groupEnum) {
		case Technical:
			return 1;
		case Humanitarian:
			return 2;
		case Combined:
			return 3;
		}
		return 1;
	}

//case 1
	public void addStudent() {
		System.out.println("Choose the group 1-Technical, 2-Gumanitarian, 3-Combined");
		int groupID = numberFilter.pouzeVybranyCelaCisla(1, 3);

		System.out.println("Enter name, surname");
		String name = sc.next();
		String surname = sc.next();

		System.out.println("Enter date of birth (day, month, year)");
		int day = numberFilter.pouzeCelaCisla();
		int month = numberFilter.pouzeCelaCisla();
		int year = numberFilter.pouzeCelaCisla();

		setGLOBAL_ID(GLOBAL_ID + 1);

		GroupEnum groupEnum = getGroupEnum(groupID);

		GroupDatabase groupDatabase = database.getGroupDatabase(groupEnum);

		groupDatabase.setStudent(GLOBAL_ID, name, surname, year, month, day, groupEnum);

	}

//case2
	public void addStudentGrade() {
		System.out.println("Enter ID and grade");
		int ID = numberFilter.pouzeCelaCisla();
		int grade = numberFilter.pouzeVybranyCelaCisla(0, 5);

		String msg = ID + " is not in database";

		for (int i = 1; i <= 3; i++) {

			GroupDatabase groupDatabase = database.getGroupDatabase(getGroupEnum(i));

			if (groupDatabase.isStudentNull(ID) == false) {
				Student student = groupDatabase.getStudent(ID);

				if (!student.putGrade(grade))
					msg = "grade is not entered";
				else
					msg = "grade is entered";
				break;
			}

		}
		System.out.println(msg);
	}

// case 3 vypis informace o studentovi
	public void printStudentInfo() {
		System.out.println("Enter Student ID");
		int ID = numberFilter.pouzeCelaCisla();

		String msg = ID + " is not in database";

		for (int i = 1; i <= 3; i++) {

			GroupDatabase groupDatabase = database.getGroupDatabase(getGroupEnum(i));

			if (groupDatabase.isStudentNull(ID) == false) {

				Student student = groupDatabase.getStudent(ID);
				msg = student.getInfo();
				student.printGrades();
				break;
			}
		}
		System.out.println(msg);
	}

//case 4
	public void deleteStudent() {
		System.out.println("Enter student ID to delete");
		int ID = numberFilter.pouzeCelaCisla();

		String msg = ID + " is not in database";

		for (int i = 1; i <= 3; i++) {

			GroupDatabase groupDatabase = database.getGroupDatabase(getGroupEnum(i));

			if (groupDatabase.isStudentNull(ID) == false) {
				if (groupDatabase.deleteStudent(ID)) {
					msg = ID + " is deleted ";
					break;
				}
			}
		}
		System.out.println(msg);
	}

// case 5
	public void printStudentList() {
		database.printDatabase();
	}

//case 6
	public void studentSkillCheck() {
		System.out.println("Enter ID of the student");
		int ID = numberFilter.pouzeCelaCisla();

		String msg = ID + " is not in database";

		for (int i = 1; i <= 3; i++) {
			GroupEnum groupEnum = getGroupEnum(i);
			GroupDatabase groupDatabase = database.getGroupDatabase(groupEnum);
			if (groupDatabase.isStudentNull(ID) == false) {

				Student student = groupDatabase.getStudent(ID);
				// ---------
				// TEST LEAP
				if (groupEnum == GroupEnum.Technical || groupEnum == GroupEnum.Combined) {
					int year = student.getYear();
					System.out.println("Is your birth year leap? {" + year + "} 1-ano, 2-ne");

					LeapTest leapTest = new LeapTest();

					int studentAnswer = numberFilter.pouzeVybranyCelaCisla(1, 2);
					boolean studentAnswerBOOL;

					switch (studentAnswer) {
					case 1:
						studentAnswerBOOL = true;
						break;
					case 2:
						studentAnswerBOOL = false;
						break;
					default:
						studentAnswerBOOL = false;
						break;
					}

					boolean rightAnswer = leapTest.getLeap(student.getYear());
//					
					if (studentAnswerBOOL == rightAnswer) {
						msg = "Correct " + student.getYear();
					} else {
						msg = "Incorrect " + student.getYear();
					}
					System.out.println(msg);
				}
				// test zodiac
				if (groupEnum == GroupEnum.Humanitarian || groupEnum == GroupEnum.Combined) {
					System.out.println("What is your zodiac? {" + student.getDay() + "." + student.getMonth() + "."
							+ student.getYear()
							+ "}\n 1)Aries(Ram)\n2)Taurus(Bull)\n3)Gemini(Twins)\n4)Cancer(Crab)\n5)Leo(Lion)\n6)Virgo(Virgin)\n7)Libra(Balance)\n8)Scorpius(Scorpion)\n9)Sagittarius(Archer)\n10)Capricornus(Goat)\n11)Aquarius(Water Bearer)\n12)Pisces(Fish)");

					ZodiacTest zodiacTest = new ZodiacTest();

					int studentAnswer = numberFilter.pouzeVybranyCelaCisla(1, 12);
					int rightAnswer = zodiacTest.getZodiacID(student.getDay(), student.getMonth());

					if (rightAnswer == studentAnswer) {
						msg = "Correct, your zodiac is " + zodiacTest.getZodiacString(rightAnswer);
					} else {
						msg = "Incorrect, your zodiac is " + zodiacTest.getZodiacString(rightAnswer);
					}
					System.out.println(msg);
					return;
				}
				System.out.println(msg);

			}
		}
	}

	public void loadStudentFromFile(Scanner fileSC, GroupEnum groupEnum) {
		int ID = fileSC.nextInt();
		String name = fileSC.next();
		String surname = fileSC.next();
		int year = fileSC.nextInt();
		int month = fileSC.nextInt();
		int day = fileSC.nextInt();
		GroupDatabase groupDatabase = database.getGroupDatabase(groupEnum);
		groupDatabase.setStudent(ID, name, surname, year, month, day, groupEnum);
		Student student = groupDatabase.getStudent(ID);
		while (fileSC.hasNextInt()) {
			student.putGrade(fileSC.nextInt());
		}
	}

	public void loadDatabaseFromFile() {
		System.out.println("Enter Filename");
		String filename = sc.next();// TODO

		File file = new File(filename + ".txt");

		Scanner fileSC;
		try {
			fileSC = new Scanner(file);
			GLOBAL_ID = fileSC.nextInt();
			String option = fileSC.next();
			GroupEnum groupEnum = GroupEnum.Technical;
			while (fileSC.hasNext()) {
				option = fileSC.next();
				if (option.equals("GROUP_TECHNICAL"))
					groupEnum = GroupEnum.Technical;

				if (option.equals("GROUP_HUMANITARIAN"))
					groupEnum = GroupEnum.Humanitarian;

				if (option.equals("GROUP_COMBINED"))
					groupEnum = GroupEnum.Combined;

				if (!fileSC.hasNextInt()) {
					option = fileSC.next();
				}
				
				if (fileSC.hasNextInt())
					loadStudentFromFile(fileSC, groupEnum);
			}
			System.out.println("Database is loaded");
			fileSC.close();
		} catch (

		FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("File " + file + " is not found");
			loadDatabaseFromFile();
		}

	}

//	Save database to File;
	public void saveDatabaseToFile() {
		System.out.println("Enter Filename");

		String name = sc.next();

		File file = new File(name + ".txt");
		try {
			if (file.createNewFile()) {
				System.out.println("File is created");
			} else {
				System.out.println("File is found");
			}
			FileWriter fw = new FileWriter(file);
			fw.write(GLOBAL_ID + "\n");
			fw.write("GROUP_TECHNICAL\n");
			fw.write(database.getGroupDatabase(GroupEnum.Technical).getEverythingGroupDatabase());
			fw.write("GROUP_HUMANITARIAN\n");
			fw.write(database.getGroupDatabase(GroupEnum.Humanitarian).getEverythingGroupDatabase());
			fw.write("GROUP_COMBINED\n");
			fw.write(database.getGroupDatabase(GroupEnum.Combined).getEverythingGroupDatabase());
			fw.flush();
			
			System.out.println("Database is saved");

			fw.close();
		} catch (IOException e) {
			System.out.println("File " + file + "cannot be opened");
		}

	}

}
