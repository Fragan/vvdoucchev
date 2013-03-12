package fr.istic.m2info.aoc.metronome.motor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.istic.m2info.aoc.metronome.controler.Controler;
import fr.istic.m2info.aoc.metronome.controler.ControlerImpl;
import fr.istic.m2info.aoc.metronome.motor.commands.CmdDisplayStepImpl;
import fr.istic.m2info.aoc.metronome.motor.commands.CommandMotor;

public class TestMotorMetronomeImplU {

	private MotorMetronome mm;
	private CommandMotor cmd;
	private Controler cMock;

	@Before
	public void setUp() throws Exception {
		mm = new MotorMetronomeImpl();
		
		cMock = EasyMock.createMock(ControlerImpl.class); 
		EasyMock.replay(cMock);
		
		cmd = new CmdDisplayStepImpl(cMock);
	}

	@After
	public void tearDown() throws Exception {
		EasyMock.verify(cMock);
	}

	/**
	 * Test de MotorMetronome.setStep avec la valeur 43
	 */
	@Test
	public void testSetSteps() {
		mm.setSteps(43);
		assertEquals("Test de MotorMetronome.setStep avec la valeur 43",
				mm.getSteps(), 43);
	}

	/**
	 * Test de MotorMetronome.getStep avec la valeur 53
	 */
	@Test
	public void testGetSteps() {
		mm.setSteps(53);
		assertEquals("Test de MotorMetronome.getStep avec la valeur 53",
				mm.getSteps(), 53);
	}

	/**
	 * Test de MotorMetronome.setTarted et MotorMetronome.getStarted avec la
	 * valeur true (marche)
	 */
	@Test
	public void testSetGetStarted1() {
		mm.setStarted(true);
		assertTrue(
				"Test de MotorMetronome.setStarted et MotorMetronome.getStarted avec la valeur true (marche)",
				mm.isStarted());
	}

	/**
	 * Test de MotorMetronome.setTarted et MotorMetronome.getStarted avec la
	 * valeur false (arret)
	 */
	@Test
	public void testSetGetStarted2() {
		// Ajout d'une commande a l'horloge lors d'un start
		mm.setCmdDisplayStep(cmd);
		mm.setStarted(true);

		// Le test
		mm.setStarted(false);
		assertFalse(
				"Test de MotorMetronome.setStarted et MotorMetronome.getStarted avec la valeur false (arret)",
				mm.isStarted());
	}

	/**
	 * Test de MotorMetronome.setTempo et MotorMetronome.getTempo avec la valeur 100
	 */
	@Test
	public void testSetGetTempo1() {
		mm.setTempo(100);
		assertEquals("Test de MotorMetronome.setTempo et MotorMetronome.getTempo avec la valeur 100",
				mm.getTempo(), 100);
	}
	
	/**
	 * Test de MotorMetronome.setTempo et MotorMetronome.getTempo avec la valeur 101
	 */
	@Test
	public void testSetGetTempo2() {
		// Ajout d'une commande a l'horloge lors d'un start
		mm.setCmdDisplayStep(cmd);
		mm.setStarted(true);

		mm.setTempo(100);
		assertEquals("Test de MotorMetronome.setTempo et MotorMetronome.getTempo avec la valeur 101",
				mm.getTempo(), 100);
	}

	@Test
	public void testSetCmdDisplayStep() {
		mm.setCmdDisplayStep(null);
		mm.setStarted(true);
	}
}
