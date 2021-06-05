package rs.ac.bg.fon.ai.npcommon.domain;

import java.util.Objects;

public class Korisnik implements OpstiDomenskiObjekat {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long sifra;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(Long id, String username, String password) {
        this.sifra = id;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSifra() {
        return sifra;
    }

    public void setSifra(Long id) {
        this.sifra = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.sifra);
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
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
