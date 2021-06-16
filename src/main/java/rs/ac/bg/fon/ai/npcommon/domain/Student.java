package rs.ac.bg.fon.ai.npcommon.domain;

public class Student implements OpstiDomenskiObjekat {

	private static final long serialVersionUID = 1L;

	private Long sifra;
	private String brojIndeksa;
	private String ime;
	private String prezime;
	private boolean polozio;
	private Predmet predmet;

	public Student() {
	}

	public Student(Long sifra) {
		setSifra(sifra);
	}

	public Student(Long sifra, String brojIndeksa, String ime, String prezime, boolean polozio, Predmet predmet) {
		setSifra(sifra);
		setBrojIndeksa(brojIndeksa);
		setIme(ime);
		setPrezime(prezime);
		setPredmet(predmet);
		setPolozio(polozio);
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		if (brojIndeksa != null) {
			if (brojIndeksa.length() != 9) {
				throw new RuntimeException("Broj indeksa nije ispravno unet, mora da ima 9 karaktera.");
			}
			String godUpisaS = brojIndeksa.substring(0, 4);

			String brS = brojIndeksa.substring(5, 9);

			int god = Integer.parseInt(godUpisaS);

			if (god < 1990) {
				throw new RuntimeException(
						"Broj indeksa nije ispravno unet, prva 4 karaktera treba da budu godina upisa.");
			}

			int br = Integer.parseInt(brS);

			if (br < 1) {
				throw new RuntimeException(
						"Broj indeksa nije ispravno unet, poslednja 4 karaktera treba da budu prirodan broj.");
			}
		}
		this.brojIndeksa = brojIndeksa;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		if (ime !=null && ime.length() < 2) {
			throw new RuntimeException("Ime mora da ima bar 2 karaktera.");
		}
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if (prezime !=null && prezime.length() < 2) {
			throw new RuntimeException("Prezime mora da ima bar 2 karaktera.");
		}
		this.prezime = prezime;
	}

	public boolean isPolozio() {
		return polozio;
	}

	public void setPolozio(boolean polozio) {
		if (this.polozio && !polozio) {
			throw new RuntimeException("Student je položio ispit, ovaj atribut ne može da se postavi na false.");
		}
		this.polozio = polozio;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Long getSifra() {
		return sifra;
	}

	public void setSifra(Long sifra) {
		if (sifra == null) {
			throw new NullPointerException("Šifra ne može da bude null.");
		}
		if (sifra < 1) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = sifra;
	}

	@Override
	public String vratiNazivTabele() {
		return "Student s";
	}

	@Override
	public String vratiJoinKlauzulu() {
		return " LEFT JOIN predmet p on (s.predmet = p.sifra)";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "s.sifra, s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet, p.naziv, p.uslov";
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "s.brojIndeksa, s.ime, s.prezime, s.polozio, s.predmet";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append((brojIndeksa == null ? null : ("'" + brojIndeksa + "'"))).append(",")
				.append((ime == null ? null : ("'" + ime + "'"))).append(",")
				.append((prezime == null ? null : ("'" + prezime + "'"))).append(",").append(polozio ? 1 : 0)
				.append(",").append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(", ").append((brojIndeksa == null ? null : ("'" + brojIndeksa + "'"))).append(",")
				.append((ime == null ? null : ("'" + ime + "'"))).append(",")
				.append((prezime == null ? null : ("'" + prezime + "'"))).append(",").append(polozio ? 1 : 0)
				.append(",").append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "s.brojIndeksa = " + (brojIndeksa == null ? null : ("'" + brojIndeksa + "'")) + ", s.ime = '" + ime
				+ "', s.prezime = '" + prezime + "', s.polozio = " + (polozio ? 1 : 0) + ", s.predmet = "
				+ (predmet == null ? null : predmet.getSifra());
	}

	@Override
	public String vratiUslovZaSelect() {
		return " WHERE s.brojIndeksa = '" + brojIndeksa + "'";
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO Student (brojIndeksa, ime, prezime, polozio, predmet) VALUES (" + vratiVrednostiBezSifre()
				+ ")";
	}
}
