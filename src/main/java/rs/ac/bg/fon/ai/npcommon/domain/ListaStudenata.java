package rs.ac.bg.fon.ai.npcommon.domain;

/**
 * Klasa koja predstavlja listu studenata koji su ostvarili uslov da u određenom
 * roku izađu na ispit.
 * 
 * Lista studenata ima atribute:
 * <ul>
 * <li>sifra, tipa <b>Long</b></li>
 * <li>rok, tipa String</li>
 * <li>predmet, objekat klase <b>Predmet</b></li>
 * </ul>
 * 
 */
public class ListaStudenata implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Jedinstvena šifra liste studenata, tipa <b>Long</b>.
	 */
	private Long sifra;
	/**
	 * Ispitni rok na koji se lista odnosi, tipa <b>String</b>.
	 */
	private String rok;
	/**
	 * Predmet za koji je lista, kao objekat klase <b>Predmet</b>.
	 */
	private Predmet predmet;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>ListaStudenata</b>.
	 */
	public ListaStudenata() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>ListaStudenata</b> i postavlja
	 * vrednost atributa koja predstavlja jedinstvenu šifru liste studenata.
	 * 
	 * @param sifra
	 *            Šifra liste studenata, tipa <b>Long</b>.
	 */
	public ListaStudenata(Long sifra) {
		setSifra(sifra);
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>ListaStudenata</b> i
	 * postavlja vrednost svih atributa liste studenata.
	 * 
	 * @param sifra
	 *            Šifra liste studenata, tipa <b>Long</b>.
	 * @param rok
	 *            Ispitni rok na koji se odnosi lista, tipa <b>String</b>.
	 * @param predmet
	 *            Predmet za čiji ispit važi data lista, kao objekat klase
	 *            <b>Predmet</b>.
	 */
	public ListaStudenata(Long sifra, String rok, Predmet predmet) {
		setSifra(sifra);
		setRok(rok);
		setPredmet(predmet);
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
		if (sifra < 1) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = sifra;
	}

	/**
	 * Vraća ispitni rok za koji važi lista.
	 * 
	 * @return Ispitni rok za koji važi lista, tipa <b>String</b>.
	 */
	public String getRok() {
		return rok;
	}

	/**
	 * Postavlja ispitni rok za koji važi lista na novu vrednost.
	 * 
	 * @param rok
	 *            Ispitni rok, tipa <b>String</b>.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen ispitni rok nije jedan od:
	 *             <ul>
	 *             <li>Januar</li>
	 *             <li>Februar</li>
	 *             <li>Jun</li>
	 *             <li>Jul</li>
	 *             <li>Septembar</li>
	 *             <li>Oktobar</li>
	 *             </ul>
	 */
	public void setRok(String rok) {
		if (rok != null && (rok != "Januar" || rok != "Februar" || rok != "Jun" || rok != "Jul" || rok != "Septembar"
				|| rok != "Oktobar")) {
			throw new RuntimeException("Rok mora da bude u skupu: [Januar, Februar, Jun, Jul, Septembar, Oktobar] ");
		}
		this.rok = rok;
	}

	/**
	 * Vraća objekat koji predstavlja predmet za koji važi lista.
	 * 
	 * @return Predmet za koji je lista, kao objekat klase <b>Predmet</b>.
	 */
	public Predmet getPredmet() {
		return predmet;
	}

	/**
	 * Postavlja predmet za koji lista važi na novu vrednost.
	 * 
	 * @param predmet
	 *            Predmet za koji važi lista, objekat klase <b>Predmet</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             Ako je prosleđeni predmet null.
	 */
	public void setPredmet(Predmet predmet) {
		if (predmet == null) {
			throw new NullPointerException("Predmet ne može da bude null.");
		}
		this.predmet = predmet;
	}

	@Override
	public String vratiNazivTabele() {
		return "ListaStudenata ls";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "ls.sifra, ls.rok, ls.predmet";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(rok).append("'").append(",").append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "ls.rok, ls.predmet";
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(",").append("'").append(rok).append("'").append(",")
				.append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "ls.rok = '" + rok + "', ls.predmet = " + (predmet == null ? null : predmet.getSifra());
	}

	@Override
	public String vratiUslovZaSelect() {
		return "WHERE ls.sifra = " + sifra;
	}

	@Override
	public String vratiJoinKlauzulu() {
		return "JOIN Predmet p on (p.sifra = ls.predmet)";
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO ListaStudenata (rok, predmet) VALUES (" + vratiVrednostiBezSifre() + ")";
	}
}
