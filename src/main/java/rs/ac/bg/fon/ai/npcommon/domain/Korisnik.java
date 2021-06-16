package rs.ac.bg.fon.ai.npcommon.domain;

import java.util.Objects;

public class Korisnik implements OpstiDomenskiObjekat {

	private static final long serialVersionUID = 1L;
		
	private Long sifra;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(Long id, String username, String password) {
        setSifra(id);
        setUsername(username);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    	if (password == null) {
			throw new NullPointerException("Password ne može da bude null.");
		}
		if (password.length() < 8) {
			throw new RuntimeException("Password mora da ima bar 8 karaktera.");
		}
        this.password = password;
    }

    public Long getSifra() {
        return sifra;
    }

    public void setSifra(Long id) {
    	if (sifra == null) {
			throw new NullPointerException("Šifra ne sme da bude null.");
		}
    	if (sifra < 1) {
			throw new RuntimeException("Šifra mora da bude veća od 0.");
		}
        this.sifra = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
    	if (username == null) {
			throw new NullPointerException("Korisničko ime ne sme da bude null.");
		}
    	if (username.length() < 8) {
			throw new RuntimeException("Korisničko ime mora da ima 8 karaktera.");
		}
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "korisnik";
    }

    @Override
    public String vratiSvaImenaKolona() {
        return "sifra, username, password";
    }

    @Override
    public String vratiImenaKolonaBezSife() {
        return "username, password";
    }

    @Override
    public String vratiSveVrednosti() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifra).append(", '").append(username).append("', '").append(password).append("'");
        return sb.toString();
    }

    @Override
    public String vratiVrednostiBezSifre() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(username).append("', '").append(password).append("'");
        return sb.toString();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " username = '" + username + "', password = '" + password + "'";
    }

    @Override
    public String vratiUslovZaSelect() {
        return " WHERE sifra = " + sifra;
    }

    @Override
    public String vratiJoinKlauzulu() {
        return null;
    }

    @Override
    public String vratiUpitZaInsert() {
        return "INSERT INTO korisnik (username, password) VALUES (" + vratiVrednostiBezSifre() + ")";
    }

}
