package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
		assertEquals(3l, ls.getSifra());
	}

	@Test
	void testListaStudenataLongStringPredmet() {
		Predmet p = new Predmet(1l, "Pamcenje", 10);
		ls = new ListaStudenata(3l, "Jun", p);
		assertNotNull(ls);
		assertEquals(3l, ls.getSifra());
		assertEquals("Jun", ls.getRok());
		assertEquals(p.getSifra(), ls.getPredmet().getSifra());	
		assertEquals(p.getNaziv(), ls.getPredmet().getNaziv());
		assertEquals(p.getUslov(), ls.getPredmet().getUslov());
	}

	@Test
	void testSetSifra() {
		ls.setSifra(55l);
		assertEquals(55l, ls.getSifra());
	}
	
//	@Test
//	void testSetSifraNull() {
//		assertThrows(java.lang.NullPointerException.class,
//				() -> ls.setSifra(null));
//	}
	
	@Test
	void testSetSifraNegativna() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ls.setSifra(-60l));
	}

	@ParameterizedTest
	@CsvSource({
		"Januar", "Februar", "Jun", "Jul", "Septembar", "Oktobar"
	})
	void testSetRok(String rok) {
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
		assertEquals(p.getSifra(), ls.getPredmet().getSifra());	
		assertEquals(p.getNaziv(), ls.getPredmet().getNaziv());
		assertEquals(p.getUslov(), ls.getPredmet().getUslov());
	}

}
