package rs.ac.bg.fon.ai.npcommon.communication;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Klasa koja predstavlja pošiljaoca poruka.
 * 
 * Kao atribute ima samo soket, klase <b>java.net.Socket</b>.
 */
public class Sender {
	/**
	 * Soket preko koga se šalju poruke, objekat klase <b>java.net.Socket</b>.
	 */
	private final Socket socket;

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Sender</b> i postavlja
	 * atribut soket na prosleđeni soket.
	 * 
	 * @param socket
	 *            Soket preko koga se šalju poruke, objekat klase
	 *            <b>java.net.Socket</b>.
	 */
	public Sender(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Otvara output stream koji, preko soketa, šalje objekat prosleđen preko
	 * parametra metode.
	 * 
	 * @param object
	 *            Objekat koji se šalje preko soketa, klase <b>Object</b>.
	 * @throws Exception
	 *             Kada se javi neka ulazno/izlazna greška, pri otvaranju stream-a,
	 *             ako je soket null, nije povezan ili pri slanju poruke.
	 */
	public void send(Object object) throws Exception {
		try {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(object);
			out.flush();
		} catch (Exception ex) {
			socket.close();
			throw ex;
		}
	}
}
