package rs.ac.bg.fon.ai.npcommon.domain;

import java.sql.Date;

public class Eksperiment implements OpstiDomenskiObjekat {

	private static final long serialVersionUID = 1L;

	private Long sifra;
	private String naziv;
	private Date datumOdrzavanja;
	private int bodovi;
	private Eksperimentator eksperimenatator;
	private RasporedEksperimenata raspored;

	public Eksperiment() {
	}

	public Eksperiment(Long sifra) {
		setSifra(sifra);
	}

	public Eksperiment(Long sifra, String naziv, Date datumOdrzavanja, int bodovi, Eksperimentator eksperimenatator,
			RasporedEksperimenata raspored) {
		setSifra(sifra);
		setNaziv(naziv);
		setDatumOdrzavanja(datumOdrzavanja);
		setBodovi(bodovi);
		setEksperimenatator(eksperimenatator);
		setRaspored(raspored);
	}

	@Override
	public Long getSifra() {
		return sifra;
	}

	@Override
	public void setSifra(Long id) {
		if (sifra == null) {
			throw new NullPointerException("Šifra ne može da bude null.");
		}
		if (sifra < 1) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv !=null && naziv.length() < 3) {
			throw new RuntimeException("Naziv mora da ima bar 3 karaktera.");
		}
		this.naziv = naziv;
	}

	public Date getDatumOdrzavanja() {
		return datumOdrzavanja;
	}

	public void setDatumOdrzavanja(Date datumOdrzavanja) {
		if (datumOdrzavanja !=null && datumOdrzavanja.before(new java.util.Date())) {
			throw new RuntimeException("Eksperiment ne može da se zakaže u prošlosti.");
		}
		this.datumOdrzavanja = datumOdrzavanja;
	}

	public int getBodovi() {
		return bodovi;
	}

	public void setBodovi(int bodovi) {
		if (bodovi < 0) {
			throw new RuntimeException("Bodovi ne mogu da budu negativan broj.");
		}
		this.bodovi = bodovi;
	}

	public Eksperimentator getEksperimenatator() {
		return eksperimenatator;
	}

	public void setEksperimenatator(Eksperimentator eksperimenatator) {
		this.eksperimenatator = eksperimenatator;
	}

	public RasporedEksperimenata getRaspored() {
		return raspored;
	}

	public void setRaspored(RasporedEksperimenata raspored) {
		if (raspored !=null && (raspored.getDatumDo().after(datumOdrzavanja) && raspored.getDatumDo().before(datumOdrzavanja))
				|| (raspored.getDatumOd().after(datumOdrzavanja) && raspored.getDatumOd().before(datumOdrzavanja))
				|| (raspored.getDatumDo().before(datumOdrzavanja) && raspored.getDatumOd().after(datumOdrzavanja))
				|| (raspored.getDatumOd().before(datumOdrzavanja) && raspored.getDatumDo().after(datumOdrzavanja))) {
			throw new RuntimeException("Eksperiment se ne održava u okviru prosleđenog rasporeda.");
		}
		this.raspored = raspored;
	}

	@Override
	public String vratiNazivTabele() {
		return "Eksperiment e1";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return " e1.sifra, e1.naziv, e1.datumOdrzavanja, e1.bodovi, e1.eksperimentator,  e2.ime, e2.prezime, e1.raspored, r.sifra, r.datumOd, r.datumDo ";
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return " e1.naziv, e1.datumOdrzavanja, e1.bodovi, e1.eksperimentator, e1.raspored,  e2.ime, e2.prezime, e1.raspored, r.sifra, r.datumOd, r.datumDo ";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(naziv).append("',").append((datumOdrzavanja == null ? null : "'" + datumOdrzavanja + "'"))
				.append(",").append(bodovi).append(",")
				.append(eksperimenatator == null ? null : eksperimenatator.getSifra()).append(",")
				.append(raspored == null ? null : raspored.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(",").append("'").append(naziv).append("',")
				.append((datumOdrzavanja == null ? null : "'" + datumOdrzavanja + "'")).append(",").append(bodovi)
				.append(",").append(eksperimenatator == null ? null : eksperimenatator.getSifra()).append(",")
				.append(raspored == null ? null : raspored.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "e1.naziv = '" + naziv + "', e1.datumOdrzavanja = '" + (datumOdrzavanja == null ? null : datumOdrzavanja)
				+ "',  e1.bodovi = " + bodovi + ",  e1.eksperimentator = "
				+ (eksperimenatator == null ? null : eksperimenatator.getSifra()) + ",  e1.raspored = "
				+ (raspored == null ? null : raspored.getSifra());
	}

	@Override
	public String vratiUslovZaSelect() {
		return " WHERE e1.sifra = " + sifra;
	}

	@Override
	public String vratiJoinKlauzulu() {
		return " LEFT JOIN eksperimentator e2 on (e1.eksperimentator = e2.sifra) LEFT JOIN rasporedeksperimenata r on (e1.raspored = r.sifra) ";
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO Eksperiment (naziv, datumOdrzavanja, bodovi, eksperimentator, raspored) VALUES ("
				+ vratiVrednostiBezSifre() + ")";
	}

	@Override
	public String toString() {
		return naziv;
	}

}
