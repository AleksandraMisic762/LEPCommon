package rs.ac.bg.fon.ai.npcommon.domain;

import java.sql.Date;

public class RasporedEksperimenata implements OpstiDomenskiObjekat {

    private Long sifra;
    private Date datumOd;
    private Date datumDo;

    public RasporedEksperimenata(Long id) {
        this.sifra = id;
    }

    public RasporedEksperimenata(Long id, Date datumOd, Date datumDo) {
        this.sifra = id;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    @Override
    public Long getSifra() {
        return sifra;
    }

    @Override
    public void setSifra(Long id) {
        this.sifra = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
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
        sb.append("'").append(datumOd == null ? null :  datumOd ).append("',")
                .append("'").append(datumDo == null ? null :  datumDo ).append("'");
        return sb.toString();
    }

    @Override
    public String vratiImenaKolonaBezSife() {
        return "r.datumOd, r.datumDo";

    }

    @Override
    public String vratiSveVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifra).append(",")
                .append("'").append(datumOd == null ? null : datumOd ).append("',")
                .append("'").append(datumDo == null ? null : datumDo ).append("'");
        return sb.toString();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "r.datumOd = " + (datumOd == null ? null : "'" + datumOd + "'") 
                + ", r.datumDo = " + (datumDo == null ? null : "'" + datumDo + "'");
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
