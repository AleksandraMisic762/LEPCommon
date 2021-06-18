package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LSSTest extends OpstiDomenskiObjekatTest{

	LSS lss;
	
	@BeforeEach
	void setUp() throws Exception {
//		odo = new LSS();
//		lss = new LSS();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		lss = null;
	}

	@Test
	void testLSS() {
//		lss = new LSS();
		assertNotNull(lss);
	}
	
	@Test
	void testLSSStudentListaStudenata() {
		Student s = new Student(1l);
		ListaStudenata ls = new ListaStudenata(6l);
		lss = new LSS(s, ls);
		assertNotNull(lss.getStudent());
		assertNotNull(lss.getListaStudenata());
		assertEquals(s.getSifra(), lss.getStudent().getSifra());
		assertEquals(ls.getSifra(), lss.getListaStudenata().getSifra());
	}
	
	@Test
	void testSetStudent() {
		Student s = new Student(1l);
		lss.setStudent(s);
		assertNotNull(lss.getStudent());
		assertEquals(s.getSifra(), lss.getStudent().getSifra());
	}
	
	@Test
	void testSetStudentNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> lss.setStudent(null));
	}

	@Test
	void testSetListaStudenata() {
		ListaStudenata ls = new ListaStudenata();
		lss.setListaStudenata(ls);
		assertNotNull(lss.getListaStudenata());
	}

}
