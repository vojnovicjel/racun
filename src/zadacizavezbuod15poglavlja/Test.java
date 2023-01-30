package zadacizavezbuod15poglavlja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {

	public static Scanner scanner = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public static void main(String[] args) {

		Elektrodistribucija evid = new Elektrodistribucija("Elektrodistibucijavojvodine", "Bulevar Osloboddjenja",
				"021458979");
		evid.load("elektrodistribucija.txt");

		String opcija;

		do {
			System.out.println("Meni");
			System.out.println("1. Unos podataka o elektrodistribuciji");
			System.out.println("2. Unos novog racuna");
			System.out.println("3. Ispis racuna");
			System.out.println("4. Izmeni racun");
			System.out.println("5. Obrisi racun");
			System.out.println("6. Pretraga po tarifama");
			System.out.println("7. Prosecna potrosnja u mesecu");
			System.out.println("8. Racuni veci od proseka");
			System.out.println("9. Najskuplji racun");

			opcija = scanner.nextLine();
			switch (opcija) {
			case "1":
				unosPodatakODistibudi(evid);
				break;
			case "2":
				unosRacuna(evid);
				break;
			case "3":
				evid.ispisPodatak();
				break;
			case "4":
				izmeniRacun(evid);
				break;
			case "5":
				obrisiRacun(evid);
				break;
			case "6":
				pretragaPoTarifama(evid);
				break;
			case "7":
				prosecnaPotrosnja(evid);
				break;
			case "8":
				potrosnjaVecaOdProseka(evid);
				break;
			case "9":
				najskupljiRacun(evid);
				break;
			case "10":
				System.out.println(evid);;
				break;
			case "x":
				break;
			default:
				System.out.println("Opcija ne postoji.");
				break;

			}
		evid.save("elektrodistribucija.txt");
		} while (!opcija.equals("x"));
		
		scanner.close();

	}

	
	private static void najskupljiRacun(Elektrodistribucija evid) {
		String minDatumStr;
		do {
			System.out.println("Datum:");
			minDatumStr = scanner.nextLine();
		} while (!proveriDatum(minDatumStr));
		LocalDate minDatum = LocalDate.parse(minDatumStr, dtf);
		
		String maxDatumStr;
		do {
			System.out.println("Datum:");
			maxDatumStr = scanner.nextLine();
		} while (!proveriDatum(maxDatumStr));
		LocalDate maxDatum = LocalDate.parse(maxDatumStr, dtf);
		
		evid.najskupljiRacun(minDatum, maxDatum);

	}


	private static void potrosnjaVecaOdProseka(Elektrodistribucija evid) {
		String mesecStr;
		do {
			System.out.println(" Unesi mesec:");
			mesecStr = scanner.nextLine();
		} while (!proverMesec(mesecStr));
		int mesec = Integer.parseInt(mesecStr);
		evid.veciOdProseka(mesec);
		
	}


	private static void prosecnaPotrosnja(Elektrodistribucija evid) {
		String mesecStr;
		do {
			System.out.println(" Unesi mesec:");
			mesecStr = scanner.nextLine();
		} while (!proverMesec(mesecStr));
		int mesec = Integer.parseInt(mesecStr);
		
		evid.prosecnaPotrosnjaUMesecu(mesec);
	}


	private static void pretragaPoTarifama(Elektrodistribucija evid) {
		String minNizaStr;
		do {
			System.out.println(" Min niza:");
			minNizaStr = scanner.nextLine();
		} while (!provertarifu(minNizaStr));
		int minNiza = Integer.parseInt(minNizaStr);

		String maxNizaStr;
		do {
			System.out.println(" Max niza:");
			maxNizaStr = scanner.nextLine();
		} while (!provertarifu(maxNizaStr));
		int maxNiza = Integer.parseInt(maxNizaStr);

		String minVisaStr;
		do {
			System.out.println(" Min visa:");
			minVisaStr = scanner.nextLine();
		} while (!provertarifu(minVisaStr));
		int minVisa = Integer.parseInt(minVisaStr);

		String maxVisaStr;
		do {
			System.out.println(" Max visa:");
			maxVisaStr = scanner.nextLine();
		} while (!provertarifu(maxVisaStr));
		int maxVisa = Integer.parseInt(maxVisaStr);

		evid.pretragaPotarifama(minNiza, maxNiza, minVisa, maxVisa);

	}

	private static void obrisiRacun(Elektrodistribucija evid) {
		String idStr;
		do {
			System.out.println("Indetifikator:");
			idStr = scanner.nextLine();
		} while (!proverBroj(idStr));
		int id = Integer.parseInt(idStr);

		evid.brisanjePodatakaORacunu(id);
	}

	private static void izmeniRacun(Elektrodistribucija evid) {
		String idStr;
		do {
			System.out.println("Indetifikator:");
			idStr = scanner.nextLine();
		} while (!proverBroj(idStr));
		int id = Integer.parseInt(idStr);

		System.out.println("Naziv vlasniak:");
		String nazivVlasnika = scanner.nextLine();

		String potrosnjaNizaStr;
		do {
			System.out.println("Niza tarifa:");
			potrosnjaNizaStr = scanner.nextLine();
		} while (!provertarifu(potrosnjaNizaStr));
		int potrosnjaNiza = Integer.parseInt(potrosnjaNizaStr);

		String potrosnjaVisaStr;
		do {
			System.out.println("Visa tarifa:");
			potrosnjaVisaStr = scanner.nextLine();
		} while (!provertarifu(potrosnjaVisaStr));
		int potrosnjaVisa = Integer.parseInt(potrosnjaVisaStr);

		String cenaStr;
		do {
			System.out.println("Cena:");
			cenaStr = scanner.nextLine();
		} while (!proveriCenu(cenaStr));
		int cena = Integer.parseInt(cenaStr);

		String mesecStr;
		do {
			System.out.println("Mesec:");
			mesecStr = scanner.nextLine();
		} while (!proverMesec(mesecStr));
		int mesec = Integer.parseInt(mesecStr);

		String datumStr;
		do {
			System.out.println("Datum:");
			datumStr = scanner.nextLine();
		} while (!proveriDatum(datumStr));
		LocalDate datum = LocalDate.parse(datumStr, dtf);

		Racun racun = new Racun(id, nazivVlasnika, potrosnjaNiza, potrosnjaVisa, cena, mesec, datum);
		evid.izmenaPodatakORacunu(racun);

	}

	private static void unosRacuna(Elektrodistribucija evid) {
		String idStr;
		do {
			System.out.println("Indetifikator:");
			idStr = scanner.nextLine();
		} while (!proverBroj(idStr));
		int id = Integer.parseInt(idStr);

		System.out.println("Naziv vlasniak:");
		String nazivVlasnika = scanner.nextLine();

		String potrosnjaNizaStr;
		do {
			System.out.println("Niza tarifa:");
			potrosnjaNizaStr = scanner.nextLine();
		} while (!provertarifu(potrosnjaNizaStr));
		int potrosnjaNiza = Integer.parseInt(potrosnjaNizaStr);

		String potrosnjaVisaStr;
		do {
			System.out.println("Visa tarifa:");
			potrosnjaVisaStr = scanner.nextLine();
		} while (!provertarifu(potrosnjaVisaStr));
		int potrosnjaVisa = Integer.parseInt(potrosnjaVisaStr);

		String cenaStr;
		do {
			System.out.println("Cena:");
			cenaStr = scanner.nextLine();
		} while (!proveriCenu(cenaStr));
		int cena = Integer.parseInt(cenaStr);

		String mesecStr;
		do {
			System.out.println("Mesec:");
			mesecStr = scanner.nextLine();
		} while (!proverMesec(mesecStr));
		int mesec = Integer.parseInt(mesecStr);

		String datumStr;
		do {
			System.out.println("Datum:");
			datumStr = scanner.nextLine();
		} while (!proveriDatum(datumStr));
		LocalDate datum = LocalDate.parse(datumStr, dtf);

		Racun racun = new Racun(id, nazivVlasnika, potrosnjaNiza, potrosnjaVisa, cena, mesec, datum);
		evid.unosRacuna(racun);
	}

	private static boolean proverMesec(String mesecStr) {
		try {
			int mesec = Integer.parseInt(mesecStr);
			if (mesec > 1 || mesec < 12) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	private static boolean proveriDatum(String datumStr) {

		try {
			LocalDate datum = LocalDate.parse(datumStr, dtf);
			if (datum.compareTo(LocalDate.now()) < 0) {
				return true;
			}
			return false;
		} catch (Exception e) {

		}
		return false;
	}

	private static boolean proveriCenu(String cenaStr) {

		try {
			double cena = Double.parseDouble(cenaStr);
			if (cena > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	private static boolean provertarifu(String potrosnjaNizaStr) {
		try {
			Integer.parseInt(potrosnjaNizaStr);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	private static boolean proverBroj(String idStr) {
		try {
			int id = Integer.parseInt(idStr);
			if (id > 1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	private static void unosPodatakODistibudi(Elektrodistribucija evid) {
		System.out.println("Naziva:");
		String naziv = scanner.nextLine();

		System.out.println("Adresa:");
		String adresa = scanner.nextLine();

		System.out.println("Teelfon:");
		String telefon = scanner.nextLine();

		evid.setNaziv(naziv);
		evid.setAdresa(adresa);
		evid.setTelefon(telefon);

	}

}
