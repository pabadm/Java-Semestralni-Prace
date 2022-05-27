package database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GroupDatabase {
	private Map<Integer, Student> elementsDatabase;

	GroupDatabase() {
		elementsDatabase = new HashMap<Integer, Student>();
	}

	/// pro nacteni s souboru

	public boolean setStudent(int ID, String name, String surname, int year, int month, int day, GroupEnum group) {
		if (elementsDatabase.put(ID, new Student(ID, name, surname, year, month, day, group)) == null) {
			return true;
		} else {
			return false;
		}
	}

	public Student getStudent(int ID) {
		return elementsDatabase.get(ID);
	}

	public Student getStudentBySurname(String surname) {
//		int ID = 1;
//		boolean run = true;
		Set<Integer> listID = elementsDatabase.keySet();
		Student info = null;
		for (int ID : listID) {
			info = elementsDatabase.get(ID);
			if (info.getSurname() == surname) {
				return info;
			}
		}
		return info;
	}

//	public boolean putGrade(int ID, int grade) {
//		if (elementsDatabase.get(ID) == null)
//			return false;
//		return elementsDatabase.get(ID).putGrade(grade);
//	}

	public boolean deleteStudent(int ID) {
		if (elementsDatabase.remove(ID) != null)
			return true;
		return false;
	}

	public void printGroupDatabase() {
		Set<Integer> listID = elementsDatabase.keySet();
		List<String> listSurname = new ArrayList<String>();

		Student info = null;
		for (int ID : listID) {
			info = getStudent(ID);
			listSurname.add(info.getSurname());
		}

		Collections.sort(listSurname);
		// obecny prumer
		float studentsSumGrade = 0;

		for (String surname : listSurname) {
			info = getStudentBySurname(surname);

			studentsSumGrade += info.getMiddleGrade();

			System.out.println("ID: " + info.getID() + "|SURNAME: " + info.getSurname() + "|NAME: " + info.getName()
					+ "|MIDDLE GRADE: " + info.getMiddleGrade());

		}
		System.out.println("\t\t=>Student amount: " + listID.size() + "| middle grade: " + studentsSumGrade / listID.size());
	}

	public String getEverythingGroupDatabase() {
		Set<Integer> listID = elementsDatabase.keySet();

		Student student = null;

		String information = "";
		
		for (int ID : listID) {
			student = getStudent(ID);
			String gradesSTR = "";
			for(int grade : student.grades) {
				gradesSTR += grade ;
				gradesSTR += " ";
			}

			information += "ID "+ student.getID() + " " + student.getName() + " " + student.getSurname() + " " + student.getYear()
					+ " " + student.getMonth() + " " + student.getDay() + " " + gradesSTR +"\n";
		}
		return information;
	}

	public boolean isStudentNull(int ID) {
		return elementsDatabase.get(ID) == null;
	}
}
