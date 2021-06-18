package rs.ac.bg.fon.ai.npcommon.domain;

/**
 * Klasa koja predstavlja učešće studenta u eksperimetu, odnosno uspostavlja
 * vezu između studenata i eksperimenata u kojima su učestvovali.
 * 
 * Kao atrbute ima objekat klase <b>Student</b> i objekat klase <b>Eksperiment</b>.
 */
public class SE implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Student koji je učestvovao u eksperimentu, objekat klase <b>Student</b>.
	 */
	private Student student;
	/**
	 * Eksperiment u kome je student učestvovao, objekat klase <b>Eksperiment</b>.
	 */
	private Eksperiment eksperiment;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>SE</b>.
	 */
	public SE() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>SE</b> i postavlja vrednosti
	 * atributa koji predstavljaju studenta i eksperiment u kome se evidentira
	 * učešće.
	 * 
	 * @param student
	 *            Student koji je učestvovao u eksperimentu, objekat klase <b>Student</b>.
	 * @param eksperiment
	 *            Eksperiment u kom je učestvovao, objekat klase <b>Eksperiment</b>.
	 */
	public SE(Student student, Eksperiment eksperiment) {
		setStudent(student);
		setEksperiment(eksperiment);
	}

	/**
	 * Vraća studenta koji je učestvovao u eksperimentu.
	 * 
	 * @return Student čije je učešće evidentirano u objektu, objekat klase <b>Student</b>.
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Postavlja vrednost za studenta koji je učestvovao u eksperimentu.
	 * 
	 * @param student
	 *            Student koji je učestvovao u eksperimentu, objekat klase <b>Student</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             Ako je prosleđeni student null.
	 */
	public void setStudent(Student student) {
		if (student == null) {
			throw new NullPointerException("Student ne sme da bude null.");
		}
		this.student = student;
	}

	/**
	 * Vraća eksperiment u kome je učešće evidentirano.
	 * 
	 * @return Eksperiment u kome je student učestvovao, objekat klase <b>Eksperiment</b>.
	 */
	public Eksperiment getEksperiment() {
		return eksperiment;
	}

	/**
	 * Postavlja vrednost za eksperiment u kome je učestvovano.
	 * 
	 * @param eksperiment
	 *            Eksperiment u kome je učestvovano, objekat klase <b>Eksperiment</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             Ako je prosleđeni eksperiment null.
	 */
	public void setEksperiment(Eksperiment eksperiment) {
		if (eksperiment == null) {
			throw new NullPointerException("Eksperiment ne sme da bude null.");
		}
		this.eksperiment = eksperiment;
	}

	@Override
	public String vratiNazivTabele() {
		return "SE";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "s.sifra, s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet, "
				+ "e1.sifra, e1.naziv, e1.datumOdrzavanja, SUM(e1.bodovi) as uk_bodova";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(student.getSifra()).append("'").append(",").append(eksperiment.getSifra());
		return sb.toString();
	}

	@Override
	public void setSifra(Long id) {
		
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet, "
				+ "e1.naziv, e1.datumOdrzavanja, SUM(e1.bodovi) as uk_bodova";
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(student.getSifra()).append("'").append(",").append(eksperiment.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "SE.student = " + student.getSifra() + ", SE.eksperiment = " + eksperiment.getSifra();
	}

	@Override
	public Long getSifra() {
		return 0l;
	}

	@Override
	public String vratiUslovZaSelect() {
		return "WHERE SE.student = " + student.getSifra() + " AND SE.eksperiment = " + eksperiment.getSifra();
	}

	@Override
	public String vratiJoinKlauzulu() {
		return " JOIN student s on (s.sifra = SE.student) JOIN eksperiment e1 on (e1.sifra = SE.eksperiment) "
				+ " GROUP BY SE.student ";
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO SE (student, eksperiment) VALUES (" + vratiSveVrednosti() + ")";
	}

	/**
	 * Vraća join klauzulu za operaciju get all.
	 * 
	 * @return <b>String</b> koji sadrži join klauzulu u upitu u kom se vraćaju sva
	 *         učešća studenata u eksperimentma.
	 */
	public String zaGetAll() {
		return " JOIN student s on (s.sifra = SE.student) JOIN eksperiment e1 on (e1.sifra = SE.eksperiment) ";
	}

}
