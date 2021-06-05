package rs.ac.bg.fon.ai.npcommon.domain;

public class ListaStudenata implements OpstiDomenskiObjekat {

    private Long sifra;
    private String rok;
    private Predmet predmet;

    public ListaStudenata() {
    }
    
    public ListaStudenata(Long sifra) {
        this.sifra = sifra;
    }

    public ListaStudenata(Long sifra, String rok, Predmet predmet) {
        this.sifra = sifra;
        this.rok = rok;
        this.predmet = predmet;
    }

    @Override
    public Long getSifra() {
        return sifra;
    }

    @Override
    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
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
        sb.append("'").append(rok).append("'")
                .append(",").append(predmet == null ? null : predmet.getSifra());
        return sb.toString();
    }

    @Override
    public String vratiImenaKolonaBezSife() {
        return "ls.rok, ls.predmet";
    }

    @Override
    public String vratiSveVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifra).append(",")
                .append("'").append(rok).append("'")
                .append(",").append(predmet == null ? null : predmet.getSifra());
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
