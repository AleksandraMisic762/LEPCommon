package rs.ac.bg.fon.ai.npcommon.domain;

/**
 * Klasa koja predstavlja predmet na fakultetu.
 * 
 * Predmet ima atribute:
 * <ul>
 * <li>sifra, tipa <b>Long</b></li>
 * <li>naziv, tipa <b>String</b></li>
 * <li>uslov, tipa <b>int</b></li>
 * </ul>
 */
public class Predmet implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Jedinstvena šifra predmeta, tipa <b>Long</b>.
	 */
	private Long sifra;
	/**
	 * Naziv predmeta, tipa <b>String</b>.
	 */
	private String naziv;
	/**
	 * Uslov za polaganje predmeta, tipa <b>int</b>.
	 */
	private int uslov;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>Predmet</b>.
	 */
	public Predmet() {

	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Predmet</b> i postavlja
	 * vrednost atributa koja predstavlja jedinstvenu šifru predmet.
	 * 
	 * @param sifra
	 *            Šifra predmeta, tipa <b>Long</b>.
	 */
	public Predmet(Long sifra) {
		setSifra(sifra);
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Predmet</b> i postavlja
	 * vrednost svih atributa predmeta.
	 * 
	 * @param sifra
	 *            Šifra predmeta, tipa <b>Long</b>.
	 * @param naziv
	 *            Naziv predmeta, tipa <b>String</b>.
	 * @param uslov
	 *            Uslov koji student treba da ostvari da bi izašao na ispit, tipa
	 *            <b>int</b>.
	 */
	public Predmet(Long sifra, String naziv, int uslov) {
		setSifra(sifra);
		setNaziv(naziv);
		setUslov(uslov);
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

	/**
	 * Vraća naziv predmeta.
	 * 
	 * @return Naziv predmeta, tipa <b>String</b>.
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja naziv predmeta na novu vrednost.
	 * 
	 * @param naziv
	 *            Naziv predmeta, tipa <b>String</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen naziv koji je kraći od 3 karaktera.
	 */
	public void setNaziv(String naziv) {
		if (naziv != null && naziv.length() < 3) {
			throw new RuntimeException("Naziv mora da ima bar 3 karaktera.");
		}
		this.naziv = naziv;
	}

	/**
	 * Vraća uslov za izlazak na ispit, odnosno broj bodova koje student treba da
	 * ostvari da polagao ispit.
	 * 
	 * @return Broj bodova koje student treba da ostvari da bi izašao na ispit, tipa
	 *         <b>int</b>.
	 */
	public int getUslov() {
		return uslov;
	}

	/**
	 * Postavlja broj bodova koje student treba da ostvari da bi izašao na ispit.
	 * 
	 * @param uslov
	 *            Broj bodova koje student treba da ostvari da bi izašao na ispit,
	 *            tipa <b>int</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen broj manji od 0.
	 */
	public void setUslov(int uslov) {
		if (uslov < 0) {
			throw new RuntimeException("Uslov ne sme da bude negativan.");
		}
		this.uslov = uslov;
	}

	/**
	 * @return Vraća <b>String</b> koji je samo naziv predmeta.
	 */
	@Override
	public String toString() {
		return naziv;
	}

	@Override
	public String vratiNazivTabele() {
		return "Predmet p";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "p.sifra, p.naziv, p.uslov";
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "p.naziv, p.uslov";
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(",").append("'").append(naziv).append("'").append(",").append(uslov).append(",");
		return sb.toString();
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(naziv).append("'").append(",").append(uslov).append(",");
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "p.naziv = '" + naziv + "', p.uslov = " + uslov;
	}

	@Override
	public String vratiUslovZaSelect() {
		return "WHERE p.sifra = " + sifra;
	}

	@Override
	public String vratiJoinKlauzulu() {
		return null;
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO Predmet (naziv, uslov) VALUES (" + vratiVrednostiBezSifre() + ")";
	}

}
