package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest extends OpstiDomenskiObjekatTest{
	
	Student s;

	@BeforeEach
	void setUp() throws Exception {
		odo = new Student();
		s = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		s = null;
	}

	@Test
	void testStudent() {
		s = new Student();
		assertNotNull(s);
	}

	@Test
	void testStudentLong() {
		s = new Student(3l);
		assertNotNull(s);
		assertTrue(s.getSifra().equals(3l));
	}

	@Test
	void testStudentLongStringStringStringBooleanPredmet() {
		Predmet p = new Predmet(1l, "predmetA", 10);
		s = new Student(4l, "2017/0001", "Pera", "Peric", false, p);
		assertNotNull(s);
		assertTrue(s.getSifra().equals(4l));
		assertEquals("2017/0001", s.getBrojIndeksa());
		assertEquals("Pera", s.getIme());
		assertEquals("Peric", s.getPrezime());
		assertEquals(false, s.isPolozio());
		assertTrue(p.getSifra().equals(s.getPredmet().getSifra()));
		assertEquals(p.getNaziv(), s.getPredmet().getNaziv());
		assertEquals(p.getUslov(), s.getPredmet().getUslov());
	}

	@Test
	void testSetBrojIndeksa() {
		s.setBrojIndeksa("2019/0202");
		assertEquals("2019/0202", s.getBrojIndeksa());
	}
	
	@Test
	void testSetBrojIndeksaGodinaPre1990() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setBrojIndeksa("1966/0003"));
	}
	
	@Test
	void testSetBrojIndeksaNulaBroj() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setBrojIndeksa("2018/0000"));
	}
	
	@Test
	void testSetBrojIndeksaPrekratak() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setBrojIndeksa("18/33"));
	}
	
	@Test
	void testSetBrojIndeksaGodinaNijeBroj() {
		assertThrows(java.lang.NumberFormatException.class,
				() -> s.setBrojIndeksa("2ur8/0540"));
	}
	
	@Test
	void testSetBrojIndeksaLosFromatBroja() {
		assertThrows(java.lang.NumberFormatException.class,
				() -> s.setBrojIndeksa("2018/00cc"));
	}


	@Test
	void testSetIme() {
		s.setIme("Mika");
		assertEquals("Mika", s.getIme());
	}
	
	@Test
	void testSetImePrekratko() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setIme("A"));
	}

	@Test
	void testSetPrezime() {
		s.setPrezime("Mikic");
		assertEquals("Mikic", s.getPrezime());
	}
	
	@Test
	void testSetPrezimePrekratko() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setPrezime("A"));
	}

	@Test
	void testSetPolozio() {
		s.setPolozio(true);
		assertTrue(s.isPolozio());
	}
	
	@Test
	void testSetPolozioNaFalse() {
		s.setPolozio(true);
		assertThrows(java.lang.RuntimeException.class, 
				() -> s.setPolozio(false));
	}

	@Test
	void testSetPredmet() {
		Predmet p = new Predmet(1l, "predmetA", 10);
		s.setPredmet(p);
		assertTrue(p.getSifra().equals(s.getPredmet().getSifra()));
		assertEquals(p.getNaziv(), s.getPredmet().getNaziv());
		assertEquals(p.getUslov(), s.getPredmet().getUslov());
	}

	@Test
	void testSetSifra() {
		s.setSifra(55l);
		assertTrue(s.getSifra().equals(55l));
	}
	
	@Test
	void testSetSifraNegativna() {
		assertThrows(java.lang.RuntimeException.class,
				() -> s.setSifra(-60l));
	}

}
