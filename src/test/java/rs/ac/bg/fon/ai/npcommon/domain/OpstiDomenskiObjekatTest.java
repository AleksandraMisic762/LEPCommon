package rs.ac.bg.fon.ai.npcommon.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class OpstiDomenskiObjekatTest {

	protected OpstiDomenskiObjekat odo;
	
	@Test
	void testSetSifra() {
		odo.setSifra(1l);
		assertNotNull(odo.getSifra());
	}
	
	@Test
	void testSetSifraNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> odo.setSifra(null));
	}
}
