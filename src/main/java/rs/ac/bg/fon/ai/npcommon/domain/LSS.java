package rs.ac.bg.fon.ai.npcommon.domain;

/**
 * Klasa koja predstavlja pojavljivanje studenta u listi studenata koji su
 * ostvarili uslov za izlazak na ispit.
 * 
 * Kao atribute ima objekat klase <b>Student</b> i objekat klase
 * <b>ListaStudenata</b>.
 */
public class LSS implements OpstiDomenskiObjekat {

	/**
	 * Jedinstveni identifikator verzije serije klase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Student koji je pripada listi, objekat klase <b>Student</b>.
	 */
	private Student student;
	/**
	 * Lista u kojoj se relevantni student nalazi, objekat klase
	 * <b>ListaStudenata</b>.
	 */
	private ListaStudenata listaStudenata;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>LSS</b>.
	 */
	public LSS() {
		
	}
	
	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>LSS</b> i postavlja vrednosti
	 * atributa koji predstavljaju studenta i listu u kojoj se evidentira ko je
	 * ostvario uslov da polaže ispit u roku na koji se odnosi lista.
	 * 
	 * @param student
	 *            Student koji je učestvovao u eksperimentu, objekat klase
	 *            <b>Student</b>.
	 * @param listaStudenata
	 *            Lista studenata u kojoj se nalazi student, objekat klase
	 *            <b>ListaStudenata</b>.
	 */
	public LSS(Student student, ListaStudenata listaStudenata) {
		setStudent(student);
		setListaStudenata(listaStudenata);
	}

	/**
	 * Vraća studenta koji je je u listi.
	 * 
	 * @return Student koji se nalazi u listi, kao objekat klase <b>Student</b>.
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Postavlja vrednost za studenta koji je se nalazi u listi.
	 * 
	 * @param student
	 *            Student koji je u listi, objekat klase <b>Student</b>.
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
	 * Vraća listu studenata u kojoj se nalazi relevantni student.
	 * 
	 * @return Lista studenata u kojoj se nalazi student, objekat klase
	 *         <b>ListaStudenata</b>.
	 */
	public ListaStudenata getListaStudenata() {
		return listaStudenata;
	}

	/**
	 * Postavlja vrednost za listu studenata koji su ostvarili uslov.
	 * 
	 * @param listaStudenata
	 *            Lista studenata koji su ostvarili uslov, objekat klase
	 *            <b>ListaStudenata</b>.
	 * 
	 * @throws java.lang.NullPointerException
	 *             Ako je prosleđena lista studenata null.
	 */
	public void setListaStudenata(ListaStudenata listaStudenata) {
		if (listaStudenata == null) {
			throw new NullPointerException("Lista studenata ne sme da bude null.");
		}
		this.listaStudenata = listaStudenata;
	}

	@Override
	public String vratiNazivTabele() {
		return "LSS";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "student, listaStudenata";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append(student.getSifra()).append(",").append(listaStudenata.getSifra());
		return sb.toString();
	}

	@Override
	public void setSifra(Long id) {

	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "student, listaStudenata";
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(student.getSifra()).append(",").append(listaStudenata.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "student = " + student.getSifra() + ", listaStudenata = " + listaStudenata.getSifra();
	}

	@Override
	public Long getSifra() {
		return null;
	}

	@Override
	public String vratiUslovZaSelect() {
		return "WHERE student = " + student.getSifra() + " AND listaStudenata = " + listaStudenata.getSifra();
	}

	@Override
	public String vratiJoinKlauzulu() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO LSS (student, listaStudenata) VALUES (" + vratiVrednostiBezSifre() + ")";
	}
}
