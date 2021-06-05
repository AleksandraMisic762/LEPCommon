package rs.ac.bg.fon.ai.npcommon.domain;

public class Predmet implements OpstiDomenskiObjekat{
    private Long sifra;
    private String naziv;
    private int uslov;

    public Predmet() {
        
    }

    public Predmet(Long sifra) {
        this.sifra = sifra;
    }
    
    public Predmet(Long sifra, String naziv, int uslov) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.uslov = uslov;
    }

    @Override
    public Long getSifra() {
        return sifra;
    }

    @Override
    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getUslov() {
        return uslov;
    }

    public void setUslov(int uslov) {
        this.uslov = uslov;
    }

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
        sb.append(sifra).append(",")
                .append("'").append(naziv).append("'")
                .append(",").append(uslov).append(",");
        return sb.toString();
    }
    
    @Override
    public String vratiVrednostiBezSifre() {
       StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("'")
                .append(",").append(uslov).append(",");
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
