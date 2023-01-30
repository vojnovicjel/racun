package zadacizavezbuod15poglavlja;

import java.time.LocalDate;

public class Racun {

	private int id;
	private String nazivVlasinka;
	private int potrosnjaNiza;
	private int potrosnjaVisa;
	private double Cena;
	private int mesec;
	private LocalDate datum;
	
	
	public Racun() {
		
	}

	public Racun(int indetifikator, String nazivVlasinka, int potrosnjaNiza, int potrosnjaVisa, double ukupnaCena,
			int mesec, LocalDate datum) {
	
		this.id = indetifikator;
		this.nazivVlasinka = nazivVlasinka;
		this.potrosnjaNiza = potrosnjaNiza;
		this.potrosnjaVisa = potrosnjaVisa;
		this.Cena = Cena;
		this.mesec = mesec;
		this.datum = datum;
	}

	public int getid() {
		return id;
	}

	public void setIndetifikator(int indetifikator) {
		this.id = indetifikator;
	}

	public String getNazivVlasinka() {
		return nazivVlasinka;
	}

	public void setNazivVlasinka(String nazivVlasinka) {
		this.nazivVlasinka = nazivVlasinka;
	}

	public int getPotrosnjaNiza() {
		return potrosnjaNiza;
	}

	public void setPotrosnjaNiza(int potrosnjaNiza) {
		this.potrosnjaNiza = potrosnjaNiza;
	}

	public int getPotrosnjaVisa() {
		return potrosnjaVisa;
	}

	public void setPotrosnjaVisa(int potrosnjaVisa) {
		this.potrosnjaVisa = potrosnjaVisa;
	}

	public double getCena() {
		return Cena;
	}

	public void setUkupnaCena(double Cena) {
		this.Cena = Cena;
	}

	public int getMesec() {
		return mesec;
	}

	public void setMesec(int mesec) {
		this.mesec = mesec;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Racun [id=" + id + ", nazivVlasinka=" + nazivVlasinka + ", potrosnjaNiza="
				+ potrosnjaNiza + ", potrosnjaVisa=" + potrosnjaVisa + ", Cena=" + Cena + ", mesec=" + mesec
				+ ", datum=" + datum + "]";
	}

	
	
}
