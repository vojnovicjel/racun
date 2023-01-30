package zadacizavezbuod15poglavlja;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;



public class Elektrodistribucija {
	private String naziv;
	private String adresa;
	private String telefon;
	private ArrayList<Racun> spisakRacuna = new ArrayList<>();

	public Elektrodistribucija() {

	}

	public Elektrodistribucija(String naziv, String adresa, String telefon) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public ArrayList<Racun> getSpisakRacuna() {
		return spisakRacuna;
	}

	public void setSpisakRacuna(ArrayList<Racun> spisakRacuna) {
		this.spisakRacuna = spisakRacuna;
	}

	public void save(String path) {
		ArrayList<String> lines = new ArrayList<String>();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

		for (int i = 0; i < spisakRacuna.size(); i++) {
			Racun r = this.spisakRacuna.get(i);
			String line = r.getid() + ";" + r.getNazivVlasinka() + ";" + r.getPotrosnjaNiza() + ";"
					+ r.getPotrosnjaVisa() + ";" + r.getMesec() + ";" + dtf.format(r.getDatum());
			lines.add(line);
		}
		try {

			Files.write(Paths.get(path), lines, Charset.defaultCharset(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (Exception e) {
			System.out.println("Datoteke " + path + "nije pronadjena");
		}

	}

	public void load(String path) {
//		spisakRacuna.clear();
//		List<String> lines;
//		try {
//			lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
//
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
//
//			// for (String line: lines) {
//			for (int i = 0; i < lines.size(); i++) {
//				String[] attributes = lines.get(i).split(";");
//
//				Racun racun = new Racun(Integer.parseInt(attributes[0]), attributes[1], Integer.parseInt(attributes[2]),
//						Integer.parseInt(attributes[3]), Double.parseDouble(attributes[4]),
//						Integer.parseInt(attributes[5]), LocalDate.parse(attributes[6], dtf));
//						
//
//				spisakRacuna.add(racun);
//			}
//		} catch (IOException e) {
//			System.out.println("File " + path + " not found.");
//		}
	}

	public boolean unosRacuna(Racun noviRacun) {
		for (int i = 0; i < spisakRacuna.size(); i++) {
			if (spisakRacuna.get(i).getid() == noviRacun.getid()) {
				System.out.println("Racun vec postoji");
				return false;
			}

		}
		spisakRacuna.add(noviRacun);
		System.out.println("Racun je uspesno unet");
		return true;

	}

	public void ispisPodatak() {
		for (int i = 0; i < spisakRacuna.size(); i++) {
			System.out.println(spisakRacuna.get(i));

		}
	}

	public boolean izmenaPodatakORacunu(Racun racun) {
		for (int i = 0; i < spisakRacuna.size(); i++) {
			if (spisakRacuna.get(i).getid() == racun.getid()) {
				spisakRacuna.set(i, racun);
				System.out.println("Racun je uspesno zamenjen");
				return true;

			}

		}
		System.out.println("Racun ne postoji");
		return false;

	}

	public boolean brisanjePodatakaORacunu(int id) {
		for (int i = 0; i < spisakRacuna.size(); i++) {
			if (spisakRacuna.get(i).getid() == id) {
				spisakRacuna.remove(i);
				System.out.println("Racun je uspesno obrisan");
				return true;
			}

		}
		System.out.println("Racun ne postoji");
		return false;
	}

	public void pretragaPotarifama(int minNiza, int maxNiza, int minVisa, int maxVisa) {
		for (int i = 0; i < spisakRacuna.size(); i++) {
			if (spisakRacuna.get(i).getPotrosnjaNiza() > minNiza && spisakRacuna.get(i).getPotrosnjaNiza() < maxNiza
					&& spisakRacuna.get(i).getPotrosnjaVisa() > minVisa
					&& spisakRacuna.get(i).getPotrosnjaVisa() < minVisa) {
				System.out.println("pronadjen:" + spisakRacuna.get(i));
			}

		}

	}

	public Double prosecnaPotrosnjaUMesecu(int mesec) {
		ArrayList<Racun> pronadjenRacun = new ArrayList<>();
		for (int i = 0; i < spisakRacuna.size(); i++) {
			if (spisakRacuna.get(i).getMesec() == mesec) {
				pronadjenRacun.add(spisakRacuna.get(i));
			}

		}
		if (pronadjenRacun.isEmpty()) {
			return null;

		} else {
			int suma = 0;
			for (int i = 0; i < pronadjenRacun.size(); i++) {
				suma += pronadjenRacun.get(i).getPotrosnjaNiza() + pronadjenRacun.get(i).getPotrosnjaVisa();

			}
			double prosek = (double) suma / pronadjenRacun.size();
			System.out.println("Prosecna potrosnja" + prosek);
			return prosek;
		}
	}

	public void najskupljiRacun(LocalDate minDatum, LocalDate maxDatum) {
		ArrayList<Racun> pronadjenRacun = new ArrayList<>();
		for (int i = 0; i < spisakRacuna.size(); i++) {
			if (this.spisakRacuna.get(i).getDatum().compareTo(minDatum) > 0
					&& this.spisakRacuna.get(i).getDatum().compareTo(maxDatum) < 0) {
				pronadjenRacun.add(this.spisakRacuna.get(i));
			}
		}
		if (pronadjenRacun.isEmpty()) {
			System.out.println("Racun ne postoji");
		} else {

		}
		double najvecaCena = pronadjenRacun.get(0).getCena();
		for (int i = 0; i < pronadjenRacun.size(); i++) {
			if (pronadjenRacun.get(i).getCena() > najvecaCena) {
				najvecaCena = pronadjenRacun.get(i).getCena();
			}
		}

		for (int i = 0; i < pronadjenRacun.size(); i++) {
			if (pronadjenRacun.get(i).getCena() == najvecaCena) {
				System.out.println("Najveci racun: " + pronadjenRacun.get(i));
			}
		}
	}

	public double ukupnaZarada() {
		int suma = 0;
		for (int i = 0; i < spisakRacuna.size(); i++) {
			suma += spisakRacuna.get(i).getCena();
		}
		return suma;
	}
	
	public void veciOdProseka(int mesec) {
		Double prosek = prosecnaPotrosnjaUMesecu(mesec);
		if (prosek == null) {
			System.out.println("Nema racuna za zadati mesec.");
		} else {
			for (int i = 0; i < spisakRacuna.size(); i++) {
				if (spisakRacuna.get(i).getMesec() == mesec &&
						spisakRacuna.get(i).getPotrosnjaNiza() + spisakRacuna.get(i).getPotrosnjaVisa() > prosek) {
					System.out.println("Pronadjen: " + spisakRacuna.get(i));
				}
			}
		}
	}

	@Override
	public String toString() {
		String podaci = "";
		podaci += "Naziv: " + this.naziv + "\n";
		podaci += "Adresa: " + this.adresa + "\n";
		podaci += "Telefon: " + this.telefon + "\n";
		podaci += "Ukupan broj racuna: " + spisakRacuna.size() + "\n";
		podaci += "Ukupan zarada: " + ukupnaZarada();
		return podaci;

	}

}
