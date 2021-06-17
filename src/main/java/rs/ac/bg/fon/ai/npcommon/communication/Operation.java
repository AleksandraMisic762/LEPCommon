package rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;

/**
 * Enum koji predstavlja sve sistemske operacije koje se koriste u aplikaciji.
 */
public enum Operation implements Serializable {
	/**
	 * Vrednost koja predstavlja operaciju prijavljivanja na sistem.
	 */
	LOGIN,
	/**
	 * Vrednost koja predstavlja operaciju koja vraća sve eksperimente.
	 */
	GET_ALL_EKSPERIMENT,
	/**
	 * Vrednost koja predstavlja operaciju koja vraća sve eksperimentatore.
	 */
	GET_ALL_EKSPERIMENTATOR,
	/**
	 * Vrednost koja predstavlja operaciju koja vraća sve predmete.
	 */
	GET_ALL_PREDMET,
	/**
	 * Vrednost koja predstavlja operaciju kreiranja novog studenta.
	 */
	KREIRAJ_STUDENTA,
	/**
	 * Vrednost koja predstavlja operaciju koja čuva studenta sa svim vrednostima
	 * njegovih atributa.
	 */
	ZAPAMTI_STUDENTA,
	/**
	 * Vrednost koja predstavlja operaciju koja vraća rezultat pretrage studenta
	 * po nekom kriterijumu.
	 */
	PRETRAZI_STUDENTA,
	/**
	 * Vrednost koja predstavlja operaciju koja čuva učešće studenta na
	 * eksperimentu.
	 */
	ZAPAMTI_UCESCE,
	/**
	 * Vrednost koja predstavlja operaciju kreiranja novog eksperimenta.
	 */
	KREIRAJ_EKSPERIMENT,
	/**
	 * Vrednost koja predstavlja operaciju koja čuva eksperiment sa svim vrednostima
	 * njegovih atributa.
	 */
	ZAPAMTI_EKSPERIMENT,
	/**
	 * Vrednost koja predstavlja operaciju koja briše studenta iz sistema.
	 */
	OBRISI_EKSPERIMENT,
	/**
	 * Vrednost koja predstavlja operaciju koja vraća rezultat pretrage eksperimenta
	 * po nekom kriterijumu.
	 */
	PRETRAZI_EKSPERIMENT,
	/**
	 * Vrednost koja predstavlja operaciju kreiranja nove liste studenata.
	 */
	KREIRAJ_LISTU_STUDENTA,
	/**
	 * Vrednost koja predstavlja operaciju koja čuva listu studenata sa svim
	 * vrednostima njenih atributa.
	 */
	ZAPAMTI_LISTU_STUDENTA,
	/**
	 * Vrednost koja predstavlja operaciju kreiranja novog rasporeda eksperimenata.
	 */
	KREIRAJ_RASPORED_EKSPERIMENATA,
	/**
	 * Vrednost koja predstavlja operaciju koja čuva raspored eksperimenata sa svim
	 * vrednostima njegovih atributa.
	 */
	ZAPAMTI_RASPORED_EKSPERIMENATA,
	/**
	 * Vrednost koja predstavlja operaciju kreiranja novog eksperimentatora.
	 */
	KREIRAJ_EKSPERIMENTATORA,
	/**
	 * Vrednost koja predstavlja operaciju koja čuva eksperimentatora sa svim
	 * vrednostima njegovih atributa.
	 */
	ZAPAMTI_EKSPERIMENTATORA,
	/**
	 * Vrednost koja predstavlja operaciju koja vraća sve studente koji su ispunili
	 * uslov za polaganje uslova.
	 */
	GET_ALL_STUDENT_USLOV,
	/**
	 * Vrednost koja predstavlja operaciju koja vraća sva učešća studenata na nekom
	 * eksperimentu.
	 */
	GET_ALL_UCESCA_NA_EKSPERIMENTU
}
