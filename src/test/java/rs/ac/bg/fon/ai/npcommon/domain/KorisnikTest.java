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
		assertEquals(4l, k.getSifra());
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
		k.setSifra(10l);
		assertEquals(10l, k.getSifra());
	}

//	@Test
//	void testSetSifraNull() {
//		assertThrows(java.lang.NullPointerException.class, 
//				() -> k.setSifra(null));
//	}
	
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
		"1l, noviKorisnik, sifra#3$A, 1l, noviKorisnik, sifra#3$A, true",
		"1l, noviKorisnik, sifra#3$A, 5l, noviKorisnik, sifra#3$A, true",
		"1l, noviKorisnik, sifra#3$A, 1l, noviKorisnik, razlicitaSifra, true",
		"1l, noviKorisnik, sifra#3$A, 1l, drugiKorisnik, sifra#3$A, false",
	})
	void testEqualsObject(Long s1, String kIme1, String pass1, Long s2, String kIme2, String pass2, boolean equals) {
		Korisnik k1 = new Korisnik(s1, kIme1, pass1);
		Korisnik k2 = new Korisnik(s2, kIme2, pass2);
		
		assertEquals(k1.equals(k2), equals);
	}

}
