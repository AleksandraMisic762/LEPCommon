package rs.ac.bg.fon.ai.npcommon.domain;

import java.util.Objects;

/**
 * Klasa koja predstavlja korisnika aplikacije.
 * 
 * Korisnik ima atribute:
 * <ul>
 * <li>sifra, tipa <b>Long</b></li>
 * <li>username, tipa <b>String</b></li>
 * <li>password, tipa <b>String</b></li>
 * </ul>
 */
public class Korisnik implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Jedinstvena šifra korisnika, tipa <b>Long</b>.
	 */
	private Long sifra;
	/**
	 * Korisničko ime (username) korisnika, tipa <b>String</b>.
	 */
	private String username;
	/**
	 * Lozinka za pristupanje (password) korisnika, tipa <b>String</b>.
	 */
	private String password;

	/**
	 * Konstruktor koji samo inicijalizuje novi objekat klase <b>Korisnik</b>.
	 */
	public Korisnik() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Korisnik</b> i postavlja
	 * vrednost svih atributa korisnika.
	 * 
	 * @param id
	 *            Šifra korisnika tipa <b>Long</b>.
	 * @param username
	 *            Korisničko ime (username) korisnika, tipa <b>String</b>.
	 * @param password
	 *            Lozinka za pristupanje (password) korisnika, tipa <b>String</b>.
	 */
	public Korisnik(Long id, String username, String password) {
		setSifra(id);
		setUsername(username);
		setPassword(password);
	}

	/**
	 * Vraća lozinku (password) korisnika.
	 * 
	 * @return Password korisnika kao <b>String</b>.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Postavlja password korisnika na novu vrednost.
	 * 
	 * @param password
	 *            Lozinka korisnika kao <b>String</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             ako je uneta lozinka null.
	 * @throws java.lang.RuntimeException
	 *             Ako je uneta lozinka koje je kraća od 8 znakova.
	 */
	public void setPassword(String password) {
		if (password == null) {
			throw new NullPointerException("Password ne može da bude null.");
		}
		if (password.length() < 8) {
			throw new RuntimeException("Password mora da ima bar 8 karaktera.");
		}
		this.password = password;
	}

	@Override
	public Long getSifra() {
		return sifra;
	}

	@Override
	public void setSifra(Long id) {
		if (sifra == null) {
			throw new NullPointerException("Šifra ne sme da bude null.");
		}
		if (sifra < 0) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = id;
	}

	/**
	 * Vraca korisničko ime (username) korisnika.
	 * 
	 * @return Username korisnika kao <b>String</b>.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Postavlja username korisnika na novu vrednost.
	 * 
	 * @param username
	 *            Korisničko ime korisnika kao <b>String</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             ako je uneto korisničko ime null.
	 * @throws java.lang.RuntimeException
	 *             Ako je uneto korisničko ime koje je kraće od 8 znakova.
	 */
	public void setUsername(String username) {
		if (username == null) {
			throw new NullPointerException("Korisničko ime ne sme da bude null.");
		}
		if (username.length() < 8) {
			throw new RuntimeException("Korisničko ime mora da ima 8 karaktera.");
		}
		this.username = username;
	}

	/**
	 * Poredi dva korisnika i vraća <b>true</b> ako imaju isti username, a
	 * <b>false</b> ako nisu. Ne koristi password u poređenju.
	 * 
	 * Korisnici se porede po atributu username, koji moraju da budu isti.
	 * 
	 * @return <b>true</b> ako su oba objekta klase <b>Korisnik</b> i imaju isti
	 *         username i <b>false</b> u svi ostalim slučajevima.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Korisnik other = (Korisnik) obj;
		if (!Objects.equals(this.username, other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String vratiNazivTabele() {
		return "korisnik";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "sifra, username, password";
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "username, password";
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(", '").append(username).append("', '").append(password).append("'");
		return sb.toString();
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(username).append("', '").append(password).append("'");
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return " username = '" + username + "', password = '" + password + "'";
	}

	@Override
	public String vratiUslovZaSelect() {
		return " WHERE sifra = " + sifra;
	}

	@Override
	public String vratiJoinKlauzulu() {
		return null;
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO korisnik (username, password) VALUES (" + vratiVrednostiBezSifre() + ")";
	}

}
