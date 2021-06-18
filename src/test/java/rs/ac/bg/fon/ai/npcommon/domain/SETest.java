package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SETest extends OpstiDomenskiObjekatTest{
	
	SE se;

	@BeforeEach
	void setUp() throws Exception {
		odo = new SE();
		se = new SE();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		se = null;
	}

	@Test
	void testSE() {
		se = new SE();
		assertNotNull(se);
	}

	@Test
	void testSEStudentEksperiment() {
		Student s = new Student(1l);
		Eksperiment e = new Eksperiment(2l);
		se = new SE(s,e);
		assertNotNull(se);
		assertTrue(se.getStudent().getSifra().equals(1l));
		assertTrue(e.getSifra().equals(se.getEksperiment().getSifra()));
	}

	@Test
	void testSetStudent() {
		Student s = new Student(1l);
		se.setStudent(s);
		assertNotNull(se.getStudent());
		assertTrue(s.getSifra().equals(se.getStudent().getSifra()));
	}
	
	@Test
	void testSetStudentNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> se.setStudent(null));
	}

	@Test
	void testSetEksperiment() {
		Eksperiment e = new Eksperiment(2l);
		se.setEksperiment(e);
		assertNotNull(se.getEksperiment());
		assertTrue(e.getSifra().equals(se.getEksperiment().getSifra()));
	}
	
	@Test
	void testSetEksperimentNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> se.setEksperiment(null));
	}
}
