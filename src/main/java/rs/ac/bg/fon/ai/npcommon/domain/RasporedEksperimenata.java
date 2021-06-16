package rs.ac.bg.fon.ai.npcommon.domain;

import java.sql.Date;

public class RasporedEksperimenata implements OpstiDomenskiObjekat {

	private static final long serialVersionUID = 1L;
		
	private Long sifra;
    private Date datumOd;
    private Date datumDo;

    public RasporedEksperimenata(Long id) {
    	setSifra(id);
    }

    public RasporedEksperimenata(Long id, Date datumOd, Date datumDo) {
        setSifra(id);
        setDatumOd(datumOd);;
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
		if (sifra < 1) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
        this.sifra = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
    	if(datumOd == null) {
    		throw new NullPointerException("Datum početka ne može da bude null.");
    	}
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
    	if(datumDo == null) {
    		throw new NullPointerException("Datum kraja ne može da bude null.");
    	}
    	if(datumDo.before(datumOd)) {
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
