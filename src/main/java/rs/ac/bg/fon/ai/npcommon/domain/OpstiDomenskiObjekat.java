package rs.ac.bg.fon.ai.npcommon.domain;

import java.io.Serializable;

public interface OpstiDomenskiObjekat extends Serializable {

    String vratiNazivTabele();

    String vratiSvaImenaKolona();

    String vratiImenaKolonaBezSife();
    
    String vratiSveVrednosti();
    
    String vratiVrednostiBezSifre();
    
    String vratiVrednostiZaUpdate();

    void setSifra(Long id);
    
    Long getSifra();
    
    String vratiUslovZaSelect();
    
    String vratiJoinKlauzulu();
    
    String vratiUpitZaInsert();    
}
