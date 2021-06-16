package rs.ac.bg.fon.ai.npcommon.domain;

import java.io.Serializable;

/**
 * Interfejs koji definiše osnovne operacije koje se vrše nad svim domenskim
 * objektima u projektu LEP.
 * 
 * Nasleđuje interfejs Serializable.
 * 
 */
public interface OpstiDomenskiObjekat extends Serializable {

	/**
	 * Vraća naziv tabele u bazi.
	 * 
	 * @return Naziv tabele u bazi kao String.
	 */
	String vratiNazivTabele();

	/**
	 * Vraća imena svih kolona u bazi.
	 * 
	 * @return Imena svih kolona u tabeli kao String.
	 */
	String vratiSvaImenaKolona();

	/**
	 * Vraća imena kolona u bazi, bez naziva kolone u kojoj se čuva šifra.
	 * 
	 * @return Imena kolona u tabeli kao String, bez naziva kolone u kojoj se čuva
	 *         šifra.
	 */
	String vratiImenaKolonaBezSife();

	/**
	 * Vraća sve vrednosti atributa objekta.
	 * 
	 * @return Sve vrednosti atributa objekta kao String, razdvojene zarezima.
	 */
	String vratiSveVrednosti();

	/**
	 * Vraća vrednosti atributa objekta, osim vrednosti atributa koji predstavlja
	 * jedinstvenu šifru objekta.
	 * 
	 * @return Vrednosti atributa objekta, bez šifre, kao String, razdvojene
	 *         zarezima.
	 */
	String vratiVrednostiBezSifre();

	/**
	 * Vraća sve vrednosti atributa objekta koje mogu da se menjaju operacijom
	 * ažuriranja.
	 * 
	 * @return Vraća sve vrednosti atributa objekta koje mogu da se menjaju
	 *         operacijom ažuriranja, kao String.
	 */
	String vratiVrednostiZaUpdate();

	/**
	 * Postavlja vrednost za jedinstvenu šifru objekta.
	 * 
	 * @param id
	 *            Šifra objekta tipa Long.
	 * 
	 * @throws java.lang.NullPointerException
	 *             Ako je prosleđena šifra null.
	 * @throws java.lang.RuntimeException
	 *             Ako je prosleđena šifra koja nije prirodan broj.
	 * 
	 */
	void setSifra(Long id);

	/**
	 * Vraća vrednost jedinstvene šifre objekta.
	 * 
	 * @return Vraća vrednost jedinstvene šifre objekta, tipa Long.
	 */
	Long getSifra();

	/**
	 * Vraća uslov za upit operacije select.
	 * 
	 * @return Vraća uslov za upit operacije select, kao String.
	 */
	String vratiUslovZaSelect();

	/**
	 * Vraća kriterijum po kome se vrši join u SQL upitima.
	 * 
	 * @return Vraća kriterijum po kome se vrši join u SQL upitima, kao String.
	 *         Vraća null ako se nad tom tabelom ne vrši nikakvo spajanje sa drugom
	 *         tabelom.
	 */
	String vratiJoinKlauzulu();

	/**
	 * Vraća upit za operaciju ubacivanja novog rekorda u bazu.
	 * 
	 * @return Vraća ceo upit za operaciju ubacivanja novog rekorda u bazu, kao
	 *         String.
	 */
	String vratiUpitZaInsert();
}
