package rs.ac.bg.fon.ai.npcommon.domain;

import java.sql.Date;

/**
 * Klasa koja predstavlja jedno održavanje eksperimenta.
 * 
 * Eksperiment ima atribute:
 * <ul>
 * <li>sifra, tipa <b>Long</b></li>
 * <li>naziv, tipa <b>String</b></li>
 * <li>datumOdrzavanja, tipa <b>java.sql.Date</b></li>
 * <li>bodovi, tipa <b>int</b></li>
 * <li>eksperimentator, objekat klase <b>Eksperimentator</b></li>
 * <li>raspored, objekat klase <b>RasporedEksperimenata</b></li>
 * </ul>
 */
public class Eksperiment implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Jedinstvena šifra eksperimenta, tipa <b>Long</b>.
	 */
	private Long sifra;
	/**
	 * Naziv eksperimenta kao <b>String</b>.
	 */
	private String naziv;
	/**
	 * Datum održavanja eksperimenta, tipa <b>java.sql.Date</b>.
	 */
	private Date datumOdrzavanja;
	/**
	 * Bodovi koje student može da ostvari učešćem u eksperimentu, kao <b>int</b>.
	 */
	private int bodovi;
	/**
	 * Eksperimentator koji sprovodi eksperiment, kao objekat klase
	 * <b>Eksperimetator</b>.
	 */
	private Eksperimentator eksperimenatator;
	/**
	 * Raspored eksperimenata kome eksperiment pripada, kao objekat klase
	 * <b>RasporedEksperimenata</b>.
	 */
	private RasporedEksperimenata raspored;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>Eksperimentator</b>.
	 */
	public Eksperiment() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost atributa koji
	 * predstavlja jedinstvenu šifru eksperimenta.
	 * 
	 * @param sifra
	 *            Šifra eksperimenta tipa <b>Long</b>.
	 */
	public Eksperiment(Long sifra) {
		setSifra(sifra);
	}

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
	 * eksperimenta.
	 * 
	 * @param sifra
	 *            Šifra eksperimenta, tipa <b>Long</b>.
	 * @param naziv
	 *            Naziv eksperimenta, tipa <b>String</b>.
	 * @param datumOdrzavanja
	 *            Datum održavanja eksperimenta, tipa <b>java.sql.Date</b>.
	 * @param bodovi
	 *            Bodovi koje učešće u eksperimentu nosi, tipa <b>int</b>.
	 * @param eksperimenatator
	 *            Eksperimentator koji održava eksperiment, kao objekat klase
	 *            <b>Eksperimentator</b>.
	 * @param raspored
	 *            Raspored kome eksperiment pripada, kao objekat klase
	 *            <b>RasporedEksperimenata</b>.
	 */
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
		if (id == null) {
			throw new NullPointerException("Šifra ne može da bude null.");
		}
		if (id < 0) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = id;
	}

	/**
	 * Vraća naziv eksperimenta.
	 * 
	 * @return Naziv eksperimenta, tipa <b>String</b>.
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja naziv eksperimenta na novu vrednost.
	 * 
	 * @param naziv
	 *            Naziv eksperimenta, tipa <b>String</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen naziv koja ima manje od 3 karaktera.
	 */
	public void setNaziv(String naziv) {
		if (naziv != null && naziv.length() < 3) {
			throw new RuntimeException("Naziv mora da ima bar 3 karaktera.");
		}
		this.naziv = naziv;
	}

	/**
	 * Vraća datum održavanja eksperimenta.
	 * 
	 * @return Datum održavanja eksperimenta tipa <b>java.sql.Date</b>.
	 */
	public Date getDatumOdrzavanja() {
		return datumOdrzavanja;
	}

	/**
	 * Postavlja datum održavanja eksperimenta na novu vrednost. Eksperimente je
	 * moguće zakazati jedino nakon trenutka u kome se zakazuju.
	 * 
	 * @param datumOdrzavanja
	 *            Datum odrzavanja eksperimenta tipa <b>java.sql.Date</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen datum održavanja koji je pre datuma na koji se
	 *             postavlja.
	 */
	public void setDatumOdrzavanja(Date datumOdrzavanja) {
		if (datumOdrzavanja != null && datumOdrzavanja.before(new java.util.Date())) {
			throw new RuntimeException("Eksperiment ne može da se zakaže u prošlosti.");
		}
		this.datumOdrzavanja = datumOdrzavanja;
	}

	/**
	 * Vraća broj bodova koje nosi eksperiment.
	 * 
	 * @return Broj bodova koje nosi eksperiment, tipa <b>int</b>.
	 */
	public int getBodovi() {
		return bodovi;
	}

	/**
	 * Postavlja bodove koje eksperiment nosi na prosleđenu vrednost. Bodovi moraju
	 * da budu prirodan broj.
	 * 
	 * @param bodovi
	 *            Bodovi koje eksperiment nosi, tipa <b>int</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen broj bodova manji od nula.
	 */
	public void setBodovi(int bodovi) {
		if (bodovi < 0) {
			throw new RuntimeException("Bodovi ne mogu da budu negativan broj.");
		}
		this.bodovi = bodovi;
	}

	/**
	 * Vraća eksperimentatora koji sprovodi eksperiment.
	 * 
	 * @return Eksperimentator koji sprovodi eksperiment kao objekat klase
	 *         <b>Eksperimentator</b>.
	 */
	public Eksperimentator getEksperimenatator() {
		return eksperimenatator;
	}

	/**
	 * Postavlja ekseprimentatora koji sprovodi eksperiment na novu vrednost.
	 * 
	 * @param eksperimenatator
	 *            Eksperimentator koji održava eksperiment kao objekat klase
	 *            <b>Eksperimentator</b>.
	 */
	public void setEksperimenatator(Eksperimentator eksperimenatator) {
		this.eksperimenatator = eksperimenatator;
	}

	/**
	 * Vraća raspored u kome se eksperiment nalazi.
	 * 
	 * @return Raspored eksperimenata kao objekat klase <b>RasporedEksperimenata</b>.
	 */
	public RasporedEksperimenata getRaspored() {
		return raspored;
	}

	/**
	 * Postavlja vrednost atributa raspored na raspored kome ovaj eksperiment
	 * pripada. Eksperiment pripada rasporedu ako je između datuma početka rasporeda
	 * i datuma kraja rasporeda. Raspored je null, ako ne postoji raspored u okviru
	 * kog se održava eksperiment.
	 * 
	 * @param raspored
	 *            Raspored kome eksperiment pripada, kao objekat klase
	 *            <b>RasporedEksperimenata</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen raspored kome eksperiment ne pripada, odnosno
	 *             izvan čijeg vremenskog opsega se eksperiment održava.
	 */
	public void setRaspored(RasporedEksperimenata raspored) {
		if (raspored != null
				&& (raspored.getDatumDo().after(datumOdrzavanja) && raspored.getDatumDo().before(datumOdrzavanja))
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
