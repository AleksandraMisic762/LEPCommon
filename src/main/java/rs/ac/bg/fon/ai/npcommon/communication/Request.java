package rs.ac.bg.fon.ai.npcommon.communication;

import java.io.Serializable;

/**
 * Klasa koja predstavlja zahtev koji klijent šalje serveru preko mreže.
 * 
 * Atributi klase <b>Request</b>:
 * <ul>
 * <li>operation, enum vrednost <b>Operation</b></li>
 * <li>argument, objekat klase <b>Object</b></li>
 * </ul>
 * 
 */
public class Request implements Serializable {

	/**
	 * Operacija koju klijent zahteva od servera, kao enum <b>Operation</b>.
	 */
	private Operation operation;
	/**
	 * Argument operacije koju klijent zahteva od servera, kao objekat klase
	 * <b>Object</b>.
	 */
	private Object argument;

	/**
	 * Konstruktor koji samo inicijalizuje objekat klase <b>Request</b>.
	 */
	public Request() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Request</b> i postavlja
	 * vrednosti svih atributa objekta.
	 * 
	 * @param operation
	 *            Sistemska operacija koja se zahteva od servera, enum
	 *            <b>Operation</b>.
	 * @param argument
	 *            Argument operacije koja se zahteva, kao objekat klase
	 *            <b>Object</b>.
	 */
	public Request(Operation operation, Object argument) {
		this.operation = operation;
		this.argument = argument;
	}

	/**
	 * Vraća operaciju koja se zahteva.
	 * 
	 * @return Operacija koja se zahteva, tipa enum <b>Operation</b>.
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Operaciju koja se zahteva postavlja na novu vrednost.
	 * 
	 * @param argument
	 *            Operacija koja se zahteva, enum tipa <b>Operation</b>.
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * Vraća argument operacije koja se zahteva.
	 * 
	 * @return Argument operacije koja se zahteva, tipa <b>Object</b>.
	 */
	public Object getArgument() {
		return argument;
	}

	/**
	 * Postavlja argument operacije koja se zahteva na novu vrednost.
	 * 
	 * @param argument
	 *            Argument koji se prosleđuje operaciji koja se zahteva, tipa
	 *            <b>Object</b>.
	 */
	public void setArgument(Object argument) {
		this.argument = argument;
	}

}
