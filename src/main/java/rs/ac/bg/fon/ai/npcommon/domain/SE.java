package rs.ac.bg.fon.ai.npcommon.domain;

public class SE implements OpstiDomenskiObjekat{
    private Student student;
    private Eksperiment eksperiment;

    public SE() {
    }
    
    public SE(Student student, Eksperiment eksperiment) {
        this.student = student;
        this.eksperiment = eksperiment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Eksperiment getEksperiment() {
        return eksperiment;
    }

    public void setEksperiment(Eksperiment eksperiment) {
        this.eksperiment = eksperiment;
    }

    @Override
    public String vratiNazivTabele() {
        return "SE";
    }

    @Override
    public String vratiSvaImenaKolona() {
        return "s.sifra, s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet, " + 
                "e1.sifra, e1.naziv, e1.datumOdrzavanja, SUM(e1.bodovi) as uk_bodova";
    }

    @Override
    public String vratiVrednostiBezSifre() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(student.getSifra()).append("'")
                .append(",").append(eksperiment.getSifra());
        return sb.toString();
    }

    @Override
    public void setSifra(Long id) {
        
    }

    @Override
    public String vratiImenaKolonaBezSife() {
        return "s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet, " + 
                "e1.naziv, e1.datumOdrzavanja, SUM(e1.bodovi) as uk_bodova";
    }

    @Override
    public String vratiSveVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(student.getSifra()).append("'")
                .append(",").append(eksperiment.getSifra());
        return sb.toString();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "SE.student = " + student.getSifra() + ", SE.eksperiment = " +  eksperiment.getSifra();
    }

    @Override
    public Long getSifra() {
        return null;
    }
    
    @Override
    public String vratiUslovZaSelect() {
        return "WHERE SE.student = " + student.getSifra() + " AND SE.eksperiment = " + eksperiment.getSifra();
    }

    @Override
    public String vratiJoinKlauzulu() {
        return " JOIN student s on (s.sifra = SE.student) JOIN eksperiment e1 on (e1.sifra = SE.eksperiment) " +
                " GROUP BY SE.student ";
    }

    @Override
    public String vratiUpitZaInsert() {
        return "INSERT INTO SE (student, eksperiment) VALUES (" + vratiSveVrednosti() + ")";
    }
    
    public String zaGetAll(){
         return " JOIN student s on (s.sifra = SE.student) JOIN eksperiment e1 on (e1.sifra = SE.eksperiment) ";
    }
    
}
