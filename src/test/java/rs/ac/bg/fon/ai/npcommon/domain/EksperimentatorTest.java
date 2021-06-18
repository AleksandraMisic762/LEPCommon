package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EksperimentatorTest extends OpstiDomenskiObjekatTest{
	
	Eksperimentator e;

	@BeforeEach
	void setUp() throws Exception {
		odo = new Eksperimentator();
		e = new Eksperimentator();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		e = null;
	}

	@Test
	void testEksperimentator() {
		e = new Eksperimentator();
		assertNotNull(e);
	}

	@Test
	void testEksperimentatorLong() {
		e = new Eksperimentator(5l);
		assertNotNull(e);
		assertEquals(5l, e.getSifra());
	}

	@Test
	void testEksperimentatorLongStringString() {
		e = new Eksperimentator(5l, "Mita", "Mitic");
		assertNotNull(e);
		assertEquals(5l, e.getSifra());
		assertEquals("Mita", e.getIme());
		assertEquals("Mitic", e.getPrezime());
	}

	@Test
	void testSetSifra() {
		e.setSifra(10l);
		assertEquals(10l, e.getSifra());
	}

//	@Test
//	void testSetSifraNull() {
//		assertThrows(java.lang.NullPointerException.class, 
//				() -> e.setSifra(null));
//	}
	
	@Test
	void testSetSifraNegativna() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> e.setSifra(-9l));
	}
	

	@Test
	void testSetIme() {
		e.setIme("Mika");
		assertEquals("Mika", e.getIme());
	}
	
	@Test
	void testSetImePrekratko() {
		assertThrows(java.lang.RuntimeException.class,
				() -> e.setIme("A"));
	}

	@Test
	void testSetPrezime() {
		e.setPrezime("Mikic");
		assertEquals("Mikic", e.getPrezime());
	}
	
	@Test
	void testSetPrezimePrekratko() {
		assertThrows(java.lang.RuntimeException.class,
				() -> e.setPrezime("A"));
	}

}
