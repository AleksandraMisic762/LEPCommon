package rs.ac.bg.fon.ai.npcommon.domain;

public class Eksperimentator implements OpstiDomenskiObjekat {

    private Long sifra;
    private String ime;
    private String prezime;

    public Eksperimentator() {
    }
    
    public Eksperimentator(Long id) {
        this.sifra = id;
    }

    public Eksperimentator(Long id, String ime, String prezime) {
        this.sifra = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    @Override
    public Long getSifra() {
        return sifra;
    }
    
    @Override
    public void setSifra(Long id) {
        this.sifra = id;
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

    @Override
    public String vratiNazivTabele() {
        return "Eksperimentator e2";
    }

    @Override
    public String vratiSvaImenaKolona() {
        return "e2.sifra, e2.ime, e2.prezime";
    }

    @Override
    public String vratiImenaKolonaBezSife() {
        return "e2.ime, e2.prezime";
    }

    @Override
    public String vratiSveVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifra).append(",")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("'");
        return sb.toString();
    }
    
    @Override
    public String vratiVrednostiBezSifre() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("',")
                .append("'").append(prezime).append("'");
        return sb.toString();
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
       return "e2.ime = '" + ime + "', e2.prezime = '" + prezime + "'";
    }
    
    @Override
    public String vratiUslovZaSelect() {
        return "WHERE e2.sifra = " + sifra;
    }

    @Override
    public String vratiJoinKlauzulu() {
        return null;
    }
    
    @Override
    public String vratiUpitZaInsert() {
        return "INSERT INTO Eksperimentator (ime, prezime) VALUES (" + vratiVrednostiBezSifre() + ")"; 
    }
}
