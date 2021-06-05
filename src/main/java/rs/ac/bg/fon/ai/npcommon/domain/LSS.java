package rs.ac.bg.fon.ai.npcommon.domain;

public class LSS implements OpstiDomenskiObjekat{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Student student;
    private ListaStudenata listaStudenata;

    public LSS(Student student, ListaStudenata listaStudenata) {
        this.student = student;
        this.listaStudenata = listaStudenata;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ListaStudenata getListaStudenata() {
        return listaStudenata;
    }

    public void setListaStudenata(ListaStudenata listaStudenata) {
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
        sb.append(student.getSifra()).append(",")
                .append(listaStudenata.getSifra());
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
        sb.append(student.getSifra()).append(",")
                .append(listaStudenata.getSifra());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public String vratiUpitZaInsert() {
        return "INSERT INTO LSS (student, listaStudenata) VALUES (" + vratiVrednostiBezSifre() + ")";
    }
}
