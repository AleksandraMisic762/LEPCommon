package rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;

/**
 * Klasa koja predstavlja odgovor koji server šalje preko mreže klijentu.
 * 
 * Atributi klase <b>Response</b>:
 * <ul>
 * <li>result, objekat klase <b>Object</b></li>
 * <li>exception, objekat klase <b>Exception</b></li>
 * </ul>
 * 
 */
public class Response implements Serializable {
	/**
	 * Objekat koji predstavlja odgovor na zahtev koji je klijent poslao, tipa
	 * <b>Object</b>.
	 */
	private Object result;
	/**
	 * Izuzetak koji nastaje ukoliko dođe do neke greške prilikom izvršavanja
	 * sistemske operacije koju je klijent zahtevao, kao objekat tipa
	 * <b>Exception</b>.
	 */
	private Exception exception;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>Response</b>.
	 */
	public Response() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Response</b> i postavlja
	 * vrednosti svih atributa objekta.
	 * 
	 * @param result
	 *            Rezultat izvršavanja sistemske operacije koju je klijent zahtevao
	 *            od servera, koji server vraća klijentu preko mreže, enum
	 *            <b>Object</b>.
	 * @param exception
	 *            Izuzetak pri izvršenju operacije koja se zahteva, kao objekat
	 *            klase <b>Exception</b>. Ako je <b>null</b>, znači da se operacija
	 *            sprovela bez izuzetaka.
	 */
	public Response(Object result, Exception exception) {
		this.result = result;
		this.exception = exception;
	}

	/**
	 * Vraća rezultat operacije koju je klijent zahtevao, ako je uspešno izvršena.
	 * 
	 * @return Rezultat sistemske operacije kao objekat klase <b>Object</b>.
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Postavlja rezultat operacije koja je izvršena i koji se prosleđuje klijentu.
	 * 
	 * @param result
	 *            Rezultat izvršavanja sistemske operacije, objekat klase
	 *            <b>Object</b>.
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * Vraća izuzetak koji je možda nastao tokom izvršenja sistemske operacije.
	 * 
	 * @return Izuzetak koji je nastao tokom izvršenja operacije, koji server vraća
	 *         klijentu, objekat klase <b>Exception</b>. <b>null</b> ako nije došlo
	 *         do izuzetka.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Postavlja izuzetak koji (i ako) je nastao tokom izvršenja operacije, kao
	 * objekat klase <b>Exception</b>.
	 * 
	 * @param exception
	 *            Izuzetak koji je nastao tokom izvršenja operacije, objekat klase
	 *            <b>Exception</b>.
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

}
