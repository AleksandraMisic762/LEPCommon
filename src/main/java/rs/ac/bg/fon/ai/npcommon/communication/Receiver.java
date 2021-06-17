package rs.ac.bg.fon.ai.npcommon.communication;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Klasa koja predstavlja primalaca poruka.
 * 
 * Kao atribute ima samo soket, klase <b>java.net.Socket</b>.
 */
public class Receiver {
	/**
	 * Soket preko koga se primaju poruke, objekat klase <b>java.net.Socket</b>.
	 */
	private Socket socket;

	/**
	 * Konstruktor koji inicijalizuje objekat klase <b>Receiver</b> i postavlja
	 * atribut soket na prosleđeni soket.
	 * 
	 * @param socket
	 *            Soket preko koga se primaju poruke, objekat klase
	 *            <b>java.net.Socket</b>.
	 */
	public Receiver(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Otvara input stream koji, iz soketa, prima objekat koji je prosleđen preko
	 * soketa i vraća ga kao objekat klase <b>Object</b>.
	 * 
	 * @return Odgovor koji je primljen preko soketa, objekat klase <b>Object</b>.
	 * 
	 * @throws Exception
	 *             Kada se javi neka ulazno/izlazna greška, pri otvaranju stream-a,
	 *             ako je soket zatvoren, nije povezan ili pri primanju poruke.
	 */
	public Object receive() throws Exception {
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			return in.readObject();
		} catch (Exception ex) {
			throw new Exception("Greska pri primanju objekta!\n" + ex.getMessage());
		}
	}
}
