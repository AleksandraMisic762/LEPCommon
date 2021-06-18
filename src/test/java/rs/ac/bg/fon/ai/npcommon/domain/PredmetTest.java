package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PredmetTest extends OpstiDomenskiObjekatTest{
	
	Predmet p;

	@BeforeEach
	void setUp() throws Exception {
		odo = new Predmet();
		p = new Predmet();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		p = null;
	}

	@Test
	void testPredmet() {
		p = new Predmet();
		assertNotNull(p);
	}

	@Test
	void testPredmetLong() {
		p = new Predmet(2l);
		assertNotNull(p);
		assertEquals(2l, p.getSifra());
	}

	@Test
	void testPredmetLongStringInt() {
		p = new Predmet(2l, "nazivPredmeta", 7);
		assertNotNull(p);
		assertEquals(2l, p.getSifra());
		assertEquals("nazivPredmeta", p.getNaziv());
		assertEquals(7, p.getUslov());
	}

	@Test
	void testSetSifra() {
		p.setSifra(9l);
		assertEquals(9l, p.getSifra());
	}
	
//	@Test
//	void testSetSifraNull() {
//		assertThrows(java.lang.NullPointerException.class, 
//				() -> p.setSifra(null));
//	}
	
	@Test
	void testSetSifraNegativna() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> p.setSifra(-6l));
	}

	@Test
	void testSetNaziv() {
		p.setNaziv("Ucenje");
		assertEquals("Ucenje", p.getNaziv());
	}
	
	@Test
	void testSetNazivPrekratak() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> p.setNaziv("na"));
	}

	@Test
	void testSetUslov() {
		p.setUslov(12);
		assertEquals(12, p.getUslov());
	}
	
	@Test
	void testSetUslovNegativan() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> p.setUslov(-5));
	}

	@Test
	void testToString() {
		p.setSifra(4l);
		p.setUslov(6);
		p.setNaziv("Pamcenje");
		assertEquals(p.getNaziv(), p.toString());
	}

}
