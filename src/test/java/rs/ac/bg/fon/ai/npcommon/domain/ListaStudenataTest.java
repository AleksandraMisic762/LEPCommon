package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaStudenataTest extends OpstiDomenskiObjekatTest{
	
	ListaStudenata ls;

	@BeforeEach
	void setUp() throws Exception {
		odo = new ListaStudenata();
		ls = new ListaStudenata();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		ls = null;
	}

	@Test
	void testListaStudenata() {
		ls = new ListaStudenata();
		assertNotNull(ls);
	}

	@Test
	void testListaStudenataLong() {
		ls = new ListaStudenata(3l);
		assertNotNull(ls);
		assertTrue(ls.getSifra().equals(3l));
	}

	@Test
	void testListaStudenataLongStringPredmet() {
		Predmet p = new Predmet(5l, "Pamcenje", 10);
		ls = new ListaStudenata(3l, "Jun", p);
		assertNotNull(ls);
		assertTrue(ls.getSifra().equals(3l));
		assertEquals("Jun", ls.getRok());
		assertTrue(p.getSifra().equals(ls.getPredmet().getSifra()));	
		assertEquals(p.getNaziv(), ls.getPredmet().getNaziv());
		assertEquals(p.getUslov(), ls.getPredmet().getUslov());
	}

	@Test
	void testSetSifra() {
		Long l = 55l;
		ls.setSifra(l);
		assertTrue(l.equals(ls.getSifra()));
	}
	
	@Test
	void testSetSifraNegativna() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ls.setSifra(-60l));
	}

	@Test
	void testSetRok() {
		String rok = "Januar";
		ls.setRok(rok);
		assertEquals(rok, ls.getRok());
	}
	
	@Test
	void testSetRokNeDozvoljenaVrednost() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ls.setRok("nnnn"));
	}

	@Test
	void testSetPredmet() {
		Predmet p = new Predmet(1l, "predmetA", 10);
		ls.setPredmet(p);
		assertTrue(ls.getPredmet().getSifra().equals(1l));
		assertEquals(p.getNaziv(), ls.getPredmet().getNaziv());
		assertEquals(p.getUslov(), ls.getPredmet().getUslov());
	}

}
