package rs.ac.bg.fon.ai.npcommon.domain;

public class ListaStudenata implements OpstiDomenskiObjekat {

	private static final long serialVersionUID = 1L;

	private Long sifra;
	private String rok;
	private Predmet predmet;

	public ListaStudenata() {
	}

	public ListaStudenata(Long sifra) {
		setSifra(sifra);
	}

	public ListaStudenata(Long sifra, String rok, Predmet predmet) {
		setSifra(sifra);
		setRok(rok);
		setPredmet(predmet);
	}

	@Override
	public Long getSifra() {
		return sifra;
	}

	@Override
	public void setSifra(Long sifra) {
		if (sifra == null) {
			throw new NullPointerException("Šifra ne može da bude null.");
		}
		if (sifra < 1) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
		this.sifra = sifra;
	}

	public String getRok() {
		return rok;
	}

	public void setRok(String rok) {
		if (rok != null && (rok != "Januar" || rok != "Februar" || rok != "Jun" || rok != "Jul" || rok != "Septembar"
				|| rok != "Oktobar")) {
			throw new RuntimeException("Rok mora da bude u skupu: [Januar, Februar, Jun, Jul, Septembar, Oktobar] ");
		}
		this.rok = rok;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		if (predmet == null) {
			throw new NullPointerException("Predmet ne može da bude null.");
		}
		this.predmet = predmet;
	}

	@Override
	public String vratiNazivTabele() {
		return "ListaStudenata ls";
	}

	@Override
	public String vratiSvaImenaKolona() {
		return "ls.sifra, ls.rok, ls.predmet";
	}

	@Override
	public String vratiVrednostiBezSifre() {
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(rok).append("'").append(",").append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiImenaKolonaBezSife() {
		return "ls.rok, ls.predmet";
	}

	@Override
	public String vratiSveVrednosti() {
		StringBuilder sb = new StringBuilder();
		sb.append(sifra).append(",").append("'").append(rok).append("'").append(",")
				.append(predmet == null ? null : predmet.getSifra());
		return sb.toString();
	}

	@Override
	public String vratiVrednostiZaUpdate() {
		return "ls.rok = '" + rok + "', ls.predmet = " + (predmet == null ? null : predmet.getSifra());
	}

	@Override
	public String vratiUslovZaSelect() {
		return "WHERE ls.sifra = " + sifra;
	}

	@Override
	public String vratiJoinKlauzulu() {
		return "JOIN Predmet p on (p.sifra = ls.predmet)";
	}

	@Override
	public String vratiUpitZaInsert() {
		return "INSERT INTO ListaStudenata (rok, predmet) VALUES (" + vratiVrednostiBezSifre() + ")";
	}
}
