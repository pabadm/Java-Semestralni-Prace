package NumberFilter;

import java.util.Scanner;

public class NumberFilter {
	Scanner sc;

	public NumberFilter(Scanner sc) {
		this.sc = sc;
	}

	public int pouzeCelaCisla() {
		int cislo = 0;
		try {
			cislo = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Nastala vyjimka typu " + e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla();
		}
		return cislo;
	}

	public int pouzeVybranyCelaCisla(int min, int max) {
		int cislo;

//		if (min > max) {
//			cislo = pouzeVybranyCelaCisla(max, min);
//		}

		cislo = pouzeCelaCisla();
		if (cislo < min || cislo > max) {
			System.out.println("You have options from " + min + " to " + max);
			cislo = pouzeVybranyCelaCisla(min, max);
		}
		return cislo;
	}

	public float pouzeRealnaCisla() {
		float cislo = 0;
		try {
			cislo = sc.nextFloat();
		} catch (Exception e) {
			System.out.println("Nastala vyjimka typu " + e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeRealnaCisla();
		}
		return cislo;
	}

	public float pouzeVybranyRealnaCisla(float min, float max) {
		float cislo;

		if (min > max) {
			cislo = pouzeVybranyRealnaCisla(max, min);
		}

		cislo = pouzeRealnaCisla();

		if (cislo < min || cislo > max) {
			System.out.println("You have options from " + min + " to " + max);
			cislo = pouzeVybranyRealnaCisla(min, max);
		}
		return cislo;
	}

}