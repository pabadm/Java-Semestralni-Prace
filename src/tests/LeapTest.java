package tests;

import java.util.GregorianCalendar;

public class LeapTest {

	public LeapTest() {
	}

	public boolean getLeap(int year) {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.isLeapYear(year);
	}
}
