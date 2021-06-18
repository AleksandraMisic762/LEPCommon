package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KorisnikTest extends OpstiDomenskiObjekatTest{

	Korisnik k;
	
	@BeforeEach
	void setUp() throws Exception {
		odo = new Korisnik();
		k = new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		k = null;
	}

	@Test
	void testKorisnik() {
		k = new Korisnik();
		assertNotNull(k);
	}

	@Test
	void testKorisnikLongStringString() {
		k = new Korisnik(4l, "username111", "Sifra%pristup1");
		assertNotNull(k);
		assertTrue(k.getSifra().equals(4l));
		assertEquals("username111", k.getUsername());
		assertEquals("Sifra%pristup1", k.getPassword());
	}

	@Test
	void testSetPassword() {
		k.setPassword("sifra123!");
		assertEquals("sifra123!", k.getPassword());
	}
	
	@Test
	void testSetPasswordNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setPassword(null));
	}
	
	@Test
	void testSetPasswordPrekratko() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setPassword("da"));
	}

	@Test
	void testSetSifra() {
		k.setSifra(43l);
		assertTrue(k.getSifra().equals(43l));
	}
	
	@Test
	void testSetSifraNegativna() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setSifra(-9l));
	}
	
	@Test
	void testSetUsername() {
		k.setUsername("korisnickoIme");
		assertEquals("korisnickoIme", k.getUsername());
	}
	
	@Test
	void testSetUsernameNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> k.setUsername(null));
	}
	
	@Test
	void testSetUsernamePrektrako() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> k.setUsername("ki"));
	}

	@ParameterizedTest
	@CsvSource({
		"noviKorisnik, sifra#3$A, noviKorisnik, sifra#3$A, true",
		"noviKorisnik, sifra#3$A, noviKorisnik, razlicitaSifra, true",
		"noviKorisnik, sifra#3$A, drugiKorisnik, sifra#3$A, false",
	})
	void testEqualsObject(String kIme1, String pass1, String kIme2, String pass2, boolean equals) {
		Korisnik k1 = new Korisnik(1l, kIme1, pass1);
		Korisnik k2 = new Korisnik(1l, kIme2, pass2);
		
		assertEquals(k1.equals(k2), equals);
	}

}
