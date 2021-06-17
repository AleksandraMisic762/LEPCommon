package rs.ac.bg.fon.ai.npcommon.domain;

/**
 * Klasa koja predstavlja eksperimentatora koji sprovodi eksperimente u
 * laboratoriji.
 * 
 * Eksperimentator ima atribute:
 * <ul>
 * <li>sifra, tipa <b>Long</b></li>
 * <li>ime, tipa <b>String</b></li>
 * <li>prezime, tipa <b>String</b></li>
 * </ul>
 */
public class Eksperimentator implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Jedinstvena šifra eksperimentatora, tipa <b>Long</b>.
	 */
	private Long sifra;
	/**
	 * Ime eksperimentatora, tipa <b>String</b>.
	 */
	private String ime;
	/**
	 * Prezime eksperimentatora, tipa <b>String</b>.
	 */
	private String prezime;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>Eksperimentator</b>.
	 */
	public Eksperimentator() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Eksperimentator</b> i
	 * postavlja vrednost atributa koja predstavlja jedinstvenu šifru
	 * eksperimentatora.
	 * 
	 * @param id
	 *            Šifra eksperimentatora tipa <b>Long</b>.
	 */
	public Eksperimentator(Long id) {
		setSifra(id);
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Eksperimentator</b> i
	 * postavlja vrednost svih atributa eksperimentatora.
	 * 
	 * @param id
	 *            Šifra eksperimentatora tipa <b>Long</b>.
	 * @param ime
	 *            Ime eksperimentatora tipa <b>String</b>.
	 * @param prezime
	 *            Prezime eksperimentatora tipa <b>String</b>.
	 */
	public Eksperimentator(Long id, String ime, String prezime) {
		setSifra(id);
		setIme(ime);
		setPrezime(prezime);
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
		if (sifra < 0) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = id;
	}

	/**
	 * Vraća ime eksperimentatora.
	 * 
	 * @return Ime eksperimentatora tipa <b>String</b>.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime eksperimentatora na novu vrednost.
	 * 
	 * @param ime
	 *            Ime eksperimentatora tipa <b>String</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je uneto ime koje je kraće od 2 znaka.
	 */
	public void setIme(String ime) {
		if (ime != null && ime.length() < 2) {
			throw new RuntimeException("Ime mora da ima bar 2 karaktera.");
		}
		this.ime = ime;
	}

	/**
	 * Vraća prezime eksperimentatora.
	 * 
	 * @return Prezime eksperimentatora tipa <b>String</b>.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime eksperimentatora na novu vrednost.
	 * 
	 * @param prezime
	 *            Prezme eksperimentatora tipa <b>String</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je uneto prezime koje je kraće 2 znaka.
	 */
	public void setPrezime(String prezime) {
		if (prezime != null && prezime.length() < 2) {
			throw new RuntimeException("Prezime mora da ima bar 2 karaktera.");
		}
		this.prezime = prezime;
	}

	@Override
	public String vratiNazivTabele() {
		return "Eksperimentator e2";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "e2.sifra, e2.ime, e2.prezime";
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "e2.ime, e2.prezime";
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(",").append("'").append(ime).append("',").append("'").append(prezime).append("'");
		return sb.toString();
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(ime).append("',").append("'").append(prezime).append("'");
		return sb.toString();
	}

	@Override
	public String toString() {
		return ime + " " + prezime;
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "e2.ime = '" + ime + "', e2.prezime = '" + prezime + "'";
	}

	@Override
	public String vratiUslovZaSelect() {
		return "WHERE e2.sifra = " + sifra;
	}

	@Override
	public String vratiJoinKlauzulu() {
		return null;
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO Eksperimentator (ime, prezime) VALUES (" + vratiVrednostiBezSifre() + ")";
	}
}
