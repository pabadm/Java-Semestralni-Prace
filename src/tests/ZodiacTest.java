package tests;

public class ZodiacTest {

	public ZodiacTest() {

	}

	public int getZodiacID(int day, int month) {
		int num = 0;
		// Aries(Ram) 21.03-19.04
		if ((day >= 21 && month == 3) || (day <= 19 && month == 4)) {
			num = 1;
		}
		// Taurus(Bull) 20.04-20.05";
		if ((day >= 20 && month == 4) || (day <= 20 && month == 5)) {
			num = 2;
		}
		// Gemini(Twins) 21.05-21.06";
		if ((day >= 21 && month == 5) || (day <= 21 && month == 6)) {
			num = 3;
		}
		// "Cancer(Crab) 22.06-22.07";
		if ((day >= 22 && month == 6) || (day <= 22 && month == 7)) {
			num = 4;
		}
		// "Leo(Lion) 23.07-22.08";
		if ((day >= 23 && month == 7) || (day <= 22 && month == 8)) {
			num = 5;
		}
		// "Virgo(Virgin) 23.08-22.09";
		if ((day >= 23 && month == 8) || (day <= 22 && month == 9)) {
			num = 6;
		}
		// "Libra(Balance) 23.09-23.10";
		if ((day >= 23 && month == 9) || (day <= 23 && month == 10)) {
			num = 7;
		}
		// "Scorpius(Scorpion) 24.10-21.11";
		if ((day >= 24 && month == 10) || (day <= 21 && month == 11)) {
			num = 8;
		}
		// "Sagittarius(Archer) 22.11-21.12";
		if ((day >= 22 && month == 11) || (day <= 21 && month == 12)) {
			num = 9;
		}
		// "Capricornus(Goat) 22.12-19.01";
		if ((day >= 22 && month == 12) || (day <= 19 && month == 1)) {
			num = 10;
		}
		// "Aquarius(Water Bearer) 20.01-18.02";
		if ((day >= 20 && month == 1) || (day <= 18 && month == 2)) {
			num = 11;
		}
		// "Pisces(Fish) 19.02-20.03";
		if ((day >= 19 && month == 2) || (day <= 20 && month == 3)) {
			num = 12;
		}
		return num;
	}

	public String getZodiacString(int ID) {
//		int ID = getZodiacID();
		String text = "";
		switch (ID) {
		case 1:
			text = "Aries(Ram) 21.03-19.04";
			break;
		case 2:
			text = "Taurus(Bull) 20.04-20.05";
			break;
		case 3:
			text = "Gemini(Twins) 21.05-21.06";
			break;
		case 4:
			text = "Cancer(Crab) 22.06-22.07";
			break;
		case 5:
			text = "Leo(Lion) 23.07-22.08";
			break;
		case 6:
			text = "Virgo(Virgin) 23.08-22.09";
			break;
		case 7:
			text = "Libra(Balance) 23.09-23.10";
			break;
		case 8:
			text = "Scorpius(Scorpion) 24.10-21.11";
			break;
		case 9:
			text = "Sagittarius(Archer) 22.11-21.12";
			break;
		case 10:
			text = "Capricornus(Goat) 22.12-19.01";
			break;
		case 11:
			text = "Aquarius(Water Bearer) 20.01-18.02";
			break;
		case 12:
			text = "Pisces(Fish) 19.02-20.03";
			break;
		}
		return text;
	}
}
