package rs.ac.bg.fon.ai.npcommon.domain;

import java.sql.Date;

/**
 * Klasa koja predstavlja raspored eksperimenta za određeni vremenski period.
 * 
 * Raspored eksperimenata ima atribute:
 * <ul>
 * <li>sifra, tipa <b>Long</b></li>
 * <li>datumOd, tipa <b>java.sql.Date</b></li>
 * <li>datumDo, tipa <b>java.sql.Date</b></li>
 * </ul>
 */
public class RasporedEksperimenata implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Jedinstvena šifra rasporeda eksperimenata, tipa <b>Long</b>.
	 */
	private Long sifra;
	/**
	 * Datum kojim počinje raspored eksperimenata, tipa <b>java.sql.Date</b>.
	 */
	private Date datumOd;
	/**
	 * Datum kojim se završava raspored eksperimenata, tipa <b>java.sql.Date</b>.
	 */
	private Date datumDo;

	/**
	 * Konstruktor koji inicijalizuje objekat klase tipa
	 * <b>RasporedEksperimenata</b> i postavlja vrednost atributa koji predstavlja
	 * jedinstvenu šifru rasporeda.
	 * 
	 * @param id
	 *            Šifra rasporeda eksperimenata, tipa <b>Long</b>.
	 */
	public RasporedEksperimenata(Long id) {
		setSifra(id);
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>RasporedEksperimenata</b> i
	 * postavlja vrednost svih atributa rasporeda.
	 * 
	 * @param id
	 *            Šifra rasporeda eksperimenata, tipa <b>Long</b>.
	 * @param datumOd
	 *            Datum početka rasporeda eksperimenata, tipa <b>java.sql.Date</b>.
	 * @param datumDo
	 *            Datum kraja rasporeda eksperimenata, tipa <b>java.sql.Date</b>.
	 *
	 */
	public RasporedEksperimenata(Long id, Date datumOd, Date datumDo) {
		setSifra(id);
		setDatumOd(datumOd);
		;
		setDatumDo(datumDo);
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
	 * Vraća datum početka rasporeda.
	 * 
	 * @return Datum početka rasporeda, tipa <b>java.sql.Date</b>.
	 */
	public Date getDatumOd() {
		return datumOd;
	}

	/**
	 * Postavlja vrednost za datum na koji počinje raspored.
	 * 
	 * @param datumOd
	 *            Datum na koji počinje raspored, tipa <b>java.sql.Date</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             Ako je prosleđeni početni datum null.
	 */
	public void setDatumOd(Date datumOd) {
		if (datumOd == null) {
			throw new NullPointerException("Datum početka ne može da bude null.");
		}
		this.datumOd = datumOd;
	}

	/**
	 * Vraća datum kraja rasporeda.
	 * 
	 * @return Datum kraja rasporeda, tipa <b>java.sql.Date</b>.
	 */
	public Date getDatumDo() {
		return datumDo;
	}

	/**
	 * Postavlja vrednost za datum na koji se završava raspored.
	 * 
	 * @param datumDo
	 *            Datum na koji se završava raspored, tipa <b>java.sql.Date</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             Ako je prosleđeni krajnji datum null.
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđen datum kraja rasporeda pre datuma početka
	 *             rasporeda.
	 */
	public void setDatumDo(Date datumDo) {
		if (datumDo == null) {
			throw new NullPointerException("Datum kraja ne može da bude null.");
		}
		if (datumDo.before(datumOd)) {
			throw new RuntimeException("Datum kraja ne sme da bude pre datuma početka.");
		}
		this.datumDo = datumDo;
	}

	@Override
	public String vratiNazivTabele() {
		return "RasporedEksperimenata r";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "r.sifra, r.datumOd, r.datumDo";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(datumOd == null ? null : datumOd).append("',").append("'")
				.append(datumDo == null ? null : datumDo).append("'");
		return sb.toString();
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "r.datumOd, r.datumDo";

	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(",").append("'").append(datumOd == null ? null : datumOd).append("',").append("'")
				.append(datumDo == null ? null : datumDo).append("'");
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "r.datumOd = " + (datumOd == null ? null : "'" + datumOd + "'") + ", r.datumDo = "
				+ (datumDo == null ? null : "'" + datumDo + "'");
	}

	@Override
	public String vratiUslovZaSelect() {
		return "WHERE r.sifra = " + sifra;
	}

	@Override
	public String vratiJoinKlauzulu() {
		return null;
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO RasporedEksperimenata (datumOd, datumDo) VALUES (" + vratiVrednostiBezSifre() + ")";
	}
}
