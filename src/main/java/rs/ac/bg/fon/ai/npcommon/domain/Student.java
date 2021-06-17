package rs.ac.bg.fon.ai.npcommon.domain;

/**
 * Klasa koja predstavlja studenta.
 * 
 * Student ima atribute:
 * <ul>
 * <li>sifra, tipa <b>Long</b></li>
 * <li>brojIndeksa, tipa <b>String</b></li>
 * <li>ime, tipa <b>String</b></li>
 * <li>prezime, tipa <b>String</b></li>
 * <li>polozio, tipa <b>boolean</b></li>
 * <li>predmet, objekat klase <b>Predmet</b></li>
 * </ul>
 * 
 */
public class Student implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Jedinstvena šifra studenta, tipa <b>Long</b>.
	 */
	private Long sifra;
	/**
	 * Broj indeksa studenta, tipa <b>String</b>.
	 */
	private String brojIndeksa;
	/**
	 * Ime studenta, tipa <b>String</b>.
	 */
	private String ime;
	/**
	 * Prezime studenta, tipa <b>String</b>.
	 */
	private String prezime;
	/**
	 * Atribut koji pokazuje da li je student polozio ispit, tipa <b>boolean</b>.
	 */
	private boolean polozio;
	/**
	 * Predmet koji je student prijavio, kao objekat klase <b>Predmet</b>.
	 */
	private Predmet predmet;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>Student</b>.
	 */
	public Student() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Student</b> i postavlja
	 * vrednost atributa koja predstavlja jedinstvenu šifru studenta.
	 * 
	 * @param sifra
	 *            Šifra studenta, tipa <b>Long</b>.
	 */
	public Student(Long sifra) {
		setSifra(sifra);
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Student</b> i postavlja
	 * vrednost svih atributa studenta.
	 * 
	 * @param sifra
	 *            Šifra studenta, tipa <b>Long</b>.
	 * @param brojIndeksa
	 *            Broj indeksa studenta, tipa <b>String</b> u formatu GGGG/XXXX, gde
	 *            su prve četiri cifre godina upisa, a poslednje četiri jedinstveni
	 *            broj, razdvojeni kosom crtom.
	 * @param ime
	 *            Ime studenta, tipa <b>String</b>.
	 * @param prezime
	 *            Prezime studenta, tipa <b>String</b>.
	 * @param predmet
	 *            Predmet koji je student prijavio, kao objekat klase
	 *            <b>Predmet</b>.
	 * @param polozio
	 *            Atribut koji predstavlja da li je student polozio predmet koji je
	 *            prijavio, tipa <b>boolean</b>.
	 * 
	 */
	public Student(Long sifra, String brojIndeksa, String ime, String prezime, boolean polozio, Predmet predmet) {
		setSifra(sifra);
		setBrojIndeksa(brojIndeksa);
		setIme(ime);
		setPrezime(prezime);
		setPredmet(predmet);
		setPolozio(polozio);
	}

	/**
	 * Vraća broj indeksa studenta, u formatu GGGG/XXXX, gde je GGGG godina upisa
	 * studenta, a XXXX broj indeksa predstavljen preko četiri cifre.
	 * 
	 * @return Broj indeksa studenta, tipa <b>String</b>.
	 */
	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	/**
	 * Postavlja broj indeksa studenta na novu, prosleđenu vrednost.
	 * 
	 * @param brojIndeksa
	 *            Broj indeksa studenta, tipa <b>String</b>, u formatu GGGG/XXXX,
	 *            gde je GGGG godina upisa studenta, a XXXX broj indeksa,
	 *            predstavljen preko četiri cifre.
	 * @throws java.lang.RuntimeException
	 *             Ako je unet broj indeksa u pogrešnom formatu, odnosno, kraći od 9
	 *             znakova ili sa godinom upisa pre 1990 ili sa brojem indeksa koji
	 *             nije prirodan broj.
	 * @throws java.lang.NumberFormatException
	 *             Ako godina upisa ili broj indeksa nisu uneti u ispravnom formatu,
	 *             koji može da se parsira u ceo broj.
	 * 
	 */
	public void setBrojIndeksa(String brojIndeksa) {
		if (brojIndeksa != null) {
			if (brojIndeksa.length() != 9) {
				throw new RuntimeException("Broj indeksa nije ispravno unet, mora da ima 9 karaktera.");
			}
			String godUpisaS = brojIndeksa.substring(0, 4);

			String brS = brojIndeksa.substring(5, 9);

			int god = Integer.parseInt(godUpisaS);

			if (god < 1990) {
				throw new RuntimeException(
						"Broj indeksa nije ispravno unet, prva 4 karaktera treba da budu godina upisa.");
			}

			int br = Integer.parseInt(brS);

			if (br < 1) {
				throw new RuntimeException(
						"Broj indeksa nije ispravno unet, poslednja 4 karaktera treba da budu prirodan broj.");
			}
		}
		this.brojIndeksa = brojIndeksa;
	}

	/**
	 * Vraća ime studenta.
	 * 
	 * @return Ime studenta, tipa <b>String</b>.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime studenta na novu vrednost.
	 * 
	 * @param ime
	 *            Ime student, tipa <b>String</b>.
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
	 * Vraća prezime studenta.
	 * 
	 * @return Prezime studenta, tipa <b>String</b>.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime studenta na novu vrednost.
	 * 
	 * @param prezime
	 *            Prezme studenta, tipa <b>String</b>.
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

	/**
	 * Vraća logičku vrednost koja predstavlja da li je student polozio ispit.
	 * 
	 * @return <b>true</b> ako je student polozio ispit, a <b>false</b> ako nije.
	 */
	public boolean isPolozio() {
		return polozio;
	}

	/**
	 * Postavlja atribut polozio na novu vrednost.
	 * 
	 * @param polozio
	 *            <b>Boolean</b> vrednost koja predstavlja da li je student polozio
	 *            ispit.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako student polozio ispit, a prosleđena vrednost je <b>false</b>.
	 */
	public void setPolozio(boolean polozio) {
		if (this.polozio && !polozio) {
			throw new RuntimeException("Student je položio ispit, ovaj atribut ne može da se postavi na false.");
		}
		this.polozio = polozio;
	}

	/**
	 * Vraća objekat koji predstavlja predmet koji je student prijavio.
	 * 
	 * @return Predmet koji je student prijavio, kao objekat klase <b>Predmet</b>.
	 */
	public Predmet getPredmet() {
		return predmet;
	}

	/**
	 * Postavlja predmet koji je student prijavio na novu vrednost.
	 * 
	 * @param predmet
	 *            Predmet koji je student prijavio, objekat klase <b>Predmet</b>.
	 */
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	@Override
	public Long getSifra() {
		return sifra;
	}

	@Override
	public void setSifra(Long sifra) {
		if (sifra == null) {
			throw new NullPointerException("Šifra ne može da bude null.");
		}
		if (sifra < 0) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = sifra;
	}

	@Override
	public String vratiNazivTabele() {
		return "Student s";
	}

	@Override
	public String vratiJoinKlauzulu() {
		return " LEFT JOIN predmet p on (s.predmet = p.sifra)";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "s.sifra, s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet, p.naziv, p.uslov";
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append((brojIndeksa == null ? null : ("'" + brojIndeksa + "'"))).append(",")
				.append((ime == null ? null : ("'" + ime + "'"))).append(",")
				.append((prezime == null ? null : ("'" + prezime + "'"))).append(",").append(polozio ? 1 : 0)
				.append(",").append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(", ").append((brojIndeksa == null ? null : ("'" + brojIndeksa + "'"))).append(",")
				.append((ime == null ? null : ("'" + ime + "'"))).append(",")
				.append((prezime == null ? null : ("'" + prezime + "'"))).append(",").append(polozio ? 1 : 0)
				.append(",").append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "s.brojIndeksa = " + (brojIndeksa == null ? null : ("'" + brojIndeksa + "'")) + ", s.ime = '" + ime
				+ "', s.prezime = '" + prezime + "', s.polozio = " + (polozio ? 1 : 0) + ", s.predmet = "
				+ (predmet == null ? null : predmet.getSifra());
	}

	@Override
	public String vratiUslovZaSelect() {
		return " WHERE s.brojIndeksa = '" + brojIndeksa + "'";
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO Student (brojIndeksa, ime, prezime, polozio, predmet) VALUES (" + vratiVrednostiBezSifre()
				+ ")";
	}
}
