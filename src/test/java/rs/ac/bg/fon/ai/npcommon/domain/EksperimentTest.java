package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EksperimentTest extends OpstiDomenskiObjekatTest{
	
	Eksperiment e;

	@BeforeEach
	void setUp() throws Exception {
		odo = new Eksperiment();
		e = new Eksperiment();
	}

	@AfterEach
	void tearDown() throws Exception {
		odo = null;
		e = null;
	}

	@Test
	void testEksperiment() {
		e = new Eksperiment();
		assertNotNull(e);
	}

	@Test
	void testEksperimentLong() {
		e = new Eksperiment(1l);
		assertNotNull(e);
		assertEquals(1l, e.getSifra());
	}

	@Test
	void testEksperimentLongStringDateIntEksperimentatorRasporedEksperimenata() {
		Eksperimentator e1 = new Eksperimentator(5l, "Pera", "Peric");
		RasporedEksperimenata r = new RasporedEksperimenata(5l, 
				new Date(System.currentTimeMillis() - 2*86400000), 
				new Date(System.currentTimeMillis() + 5*86400000));
		e = new Eksperiment(1l, "Procesovanje viseznacnih reci", 
				new Date(System.currentTimeMillis() + 3*86400000), 
				6, e1, r);
		assertNotNull(e);
		assertEquals(1l, e.getSifra());
		
		assertEquals("Procesovanje viseznacnih reci", e.getNaziv());
		assertEquals(new Date(System.currentTimeMillis() + 3*86400000), e.getDatumOdrzavanja());
		assertEquals(6, e.getBodovi());
		assertEquals(e1.getSifra(), e.getEksperimenatator().getSifra());
		assertEquals(e1.getIme(), e.getEksperimenatator().getIme());
		assertEquals(e1.getPrezime(), e.getEksperimenatator().getPrezime());
		assertEquals(r.getSifra(), e.getRaspored().getSifra());
		assertEquals(r.getDatumOd(), e.getRaspored().getDatumOd());
		assertEquals(r.getDatumDo(), e.getRaspored().getDatumDo());
	}

	@Test
	void testSetSifra() {
		e.setSifra(4l);
		assertEquals(4l, e.getSifra());
	}
//	
//	@Test
//	void testSetSifraNull() {
//		assertThrows(java.lang.NullPointerException.class, 
//				() -> e.setSifra(null));
//	}
	
	@Test
	void testSetSifraNegativna() {
		assertThrows(java.lang.RuntimeException.class,
				() -> e.setSifra(-77l));
	}

	@Test
	void testSetNaziv() {
		e.setNaziv("Brzina reakcije");
		assertEquals("Brzina reakcije", e.getNaziv());
	}
	
	@Test
	void testSetNazivPrekratak() {
		assertThrows(java.lang.RuntimeException.class,
				() -> e.setNaziv("v"));
	}

	@Test
	void testSetDatumOdrzavanja() {
		e.setDatumOdrzavanja(new Date(System.currentTimeMillis() + 2*86400000));
		assertEquals(new Date(System.currentTimeMillis() + 2*86400000), e.getNaziv());
	}
	
	@Test
	void testSetDatumOdrzavanjaPreDanas() {
		assertThrows(java.lang.RuntimeException.class,
				() -> e.setDatumOdrzavanja(new Date(System.currentTimeMillis() - 2*86400000)));
	}

	@Test
	void testSetBodovi() {
		e.setBodovi(6);
		assertEquals(6, e.getBodovi());
	}
	
	@Test
	void testSetBodoviNegativni() {
		assertThrows(java.lang.RuntimeException.class,
				() -> e.setBodovi(-4));
	}

	@Test
	void testSetEksperimenatator() {
		Eksperimentator e1 = new Eksperimentator(5l, "Pera", "Peric");
		e.setEksperimenatator(e1);
		assertEquals(e1.getSifra(), e.getEksperimenatator().getSifra());
		assertEquals(e1.getIme(), e.getEksperimenatator().getIme());
		assertEquals(e1.getPrezime(), e.getEksperimenatator().getPrezime());
	}

	@Test
	void testSetRaspored() {
		e.setDatumOdrzavanja(new Date(System.currentTimeMillis() + 3*86400000));
		RasporedEksperimenata r = new RasporedEksperimenata(5l, 
				new Date(System.currentTimeMillis() - 2*86400000), 
				new Date(System.currentTimeMillis() + 5*86400000));
		e.setRaspored(r);
		assertEquals(r.getSifra(), e.getRaspored().getSifra());
		assertEquals(r.getDatumOd(), e.getRaspored().getDatumOd());
		assertEquals(r.getDatumDo(), e.getRaspored().getDatumDo());
	}
	
	//napravi parametrizovan test
	@Test
	void testSetRasporedVanOpsega() {
		e.setDatumOdrzavanja(new Date(System.currentTimeMillis() + 1*86400000));
		RasporedEksperimenata r = new RasporedEksperimenata(5l, 
				new Date(System.currentTimeMillis() + 3*86400000), 
				new Date(System.currentTimeMillis() + 7*86400000));
		
		assertThrows(java.lang.RuntimeException.class,
				() -> e.setRaspored(r));
		
	}

	@Test
	void testToString() {
		e.setNaziv("Bilingvalna prednost");
		assertEquals(e.getNaziv(), e.toString());
	}

}
