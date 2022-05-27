package database;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {
	private int ID;
	private String name;
	private String surname;

	GregorianCalendar calendar = new GregorianCalendar();
	///// group Technical, Humanitarian, Combined
	private GroupEnum group;
	////
	List<Integer> grades = new ArrayList<Integer>();

	public Student(int ID, String name, String surname, int year, int month, int day, GroupEnum group) {
		this.ID = ID;
		this.name = name;
		this.surname = surname;
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
//		this.year = year-;
		this.group = group;
	}

	// add grades
	public boolean putGrade(int grade) {
		if (grade < 1 || grade > 5) {
			System.out.println("musi byt od 1 do 5");
			return false;
		}
		this.grades.add(grade);
		return true;
	}

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getYear() {
		return this.calendar.get(Calendar.YEAR);
	}

	public int getMonth() {
		return this.calendar.get(Calendar.MONTH) + 1;
	}

	public int getDay() {
		return this.calendar.get(Calendar.DAY_OF_MONTH);
	}

	public float getMiddleGrade() {
		float gradeSum = 0;
		float middleGrade = 0;

		for (int grade : grades) {
			gradeSum += grade;
		}
		middleGrade = gradeSum / grades.size();
		return Float.isNaN(middleGrade) ? 0 : middleGrade;
	}

	public GroupEnum getGroup() {
		return group;
	}

	public void printGrades() {
		System.out.print("\nGrades: [");
		for (int grade : grades) {
			System.out.print(grade + ", ");
		}
		System.out.print("]\n");
	}

	public String getInfo() {
		String MSG = "";
		MSG = "GROUP: " + getGroup() + "|ID: " + getID() + "|NAME: " + getName() + "|SURNAME: " + getSurname()
				+ "|DATE OF BIRTH: " + getDay() + "." + getMonth() + "." + getYear() + "|MIDDLE GRADE: "
				+ getMiddleGrade();
		return MSG;
	}
}
