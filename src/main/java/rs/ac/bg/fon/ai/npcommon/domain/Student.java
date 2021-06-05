package rs.ac.bg.fon.ai.npcommon.domain;

public class Student implements OpstiDomenskiObjekat {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long sifra;
    private String brojIndeksa;
    private String ime;
    private String prezime;
    private boolean polozio;
    private Predmet predmet;

    public Student() {
    }

    public Student(Long sifra) {
        this.sifra = sifra;
    }

    public Student(Long sifra, String brojIndeksa, String ime, String prezime, boolean polozio, Predmet predmet) {
        this.sifra = sifra;
        this.brojIndeksa = brojIndeksa;
        this.ime = ime;
        this.prezime = prezime;
        this.polozio = polozio;
        this.predmet = predmet;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean isPolozio() {
        return polozio;
    }

    public void setPolozio(boolean polozio) {
        this.polozio = polozio;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Long getSifra() {
        return sifra;
    }

    public void setSifra(Long sifra) {
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
        sb.append((brojIndeksa == null? null : ("'" + brojIndeksa + "'"))).append(",")
                .append((ime == null? null : ("'" + ime + "'"))).append(",")
                .append((prezime == null? null : ("'" + prezime + "'"))).append(",")
                .append(polozio ? 1 : 0).append(",")
                .append(predmet == null ? null : predmet.getSifra());
        return sb.toString();
    }

    @Override
    public String vratiSveVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifra).append(", ")
                .append((brojIndeksa == null? null : ("'" + brojIndeksa + "'"))).append(",")
                .append((ime == null? null : ("'" + ime + "'"))).append(",")
                .append((prezime == null? null : ("'" + prezime + "'"))).append(",")
                .append(polozio ? 1 : 0).append(",")
                .append(predmet == null ? null : predmet.getSifra());
        return sb.toString();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "s.brojIndeksa = " + (brojIndeksa == null? null : ("'" + brojIndeksa + "'")) + ", s.ime = '" + ime + "', s.prezime = '" + prezime + "', s.polozio = " + (polozio ? 1 : 0) + ", s.predmet = " + (predmet == null ? null : predmet.getSifra());
    }

    @Override
    public String vratiUslovZaSelect() {
       return " WHERE s.brojIndeksa = '" + brojIndeksa + "'";
    }

    @Override
    public String vratiUpitZaInsert() {
        return "INSERT INTO Student (brojIndeksa, ime, prezime, polozio, predmet) VALUES (" + vratiVrednostiBezSifre() + ")"; 
    }    
}
