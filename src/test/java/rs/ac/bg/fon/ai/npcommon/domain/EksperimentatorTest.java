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
		e = new Eksperimentator(4l);
		assertNotNull(e);
		assertTrue(e.getSifra().equals(4l));
	}

	@Test
	void testEksperimentatorLongStringString() {
		e = new Eksperimentator(5l, "Mita", "Mitic");
		assertNotNull(e);
		assertTrue(e.getSifra().equals(5l));
		assertEquals("Mita", e.getIme());
		assertEquals("Mitic", e.getPrezime());
	}

	@Test
	void testSetSifra() {
		e.setSifra(10l);
		assertTrue(e.getSifra().equals(10l));
	}

	
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
