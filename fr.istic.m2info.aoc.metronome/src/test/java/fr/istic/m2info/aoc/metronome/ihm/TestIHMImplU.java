package fr.istic.m2info.aoc.metronome.ihm;

import static org.junit.Assert.assertTrue;

import java.awt.Frame;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.istic.m2info.aoc.metronome.Metronome;
import fr.istic.m2info.aoc.metronome.controler.Controler;
import fr.istic.m2info.aoc.metronome.controler.ControlerImpl;
import fr.istic.m2info.aoc.metronome.controler.ObserverMotorTempo;
import fr.istic.m2info.aoc.metronome.controler.ObserverWheel;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdDecImpl;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdIncImpl;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdStartImpl;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdStopImpl;
import fr.istic.m2info.aoc.metronome.motor.MotorMetronomeImpl;
import fr.istic.m2info.aoc.metronome.motor.commands.CmdDisplayStepImpl;

public class TestIHMImplU {
	
	private FrameFixture IHMFix;
	private MotorMetronomeImpl motor;

	@Before
	/**
	 * Demarrage complet du metronome
	 * @throws Exception
	 */
	public void setUp() throws Exception {		
		Controler controler = new ControlerImpl();

		motor = new MotorMetronomeImpl();
		motor.setCmdDisplayStep(new CmdDisplayStepImpl(controler));
		motor.setTempo(Metronome.INITIAL_TEMPO);

		IHM window = new IHMImpl();
		window.setDisplayTempo(Metronome.INITIAL_TEMPO);
		window.setCmdButtonStart(new CmdStartImpl(
				controler));
		window.setCmdButtonStop(new CmdStopImpl(
				controler));
		window.setCmdButtonInc(new CmdIncImpl(
				controler));
		window.setCmdButtonDec(new CmdDecImpl(
				controler));
		
		controler.setIHM(window);
		controler.setMotor(motor);
		
		// motor est sujet de l'observateur controler.
		motor.registerObserver((ObserverMotorTempo) controler);
		
		// IHM est sujet de l'observateur controler pour la moelette.
		window.registerObserver((ObserverWheel) controler);
		
		IHMFix = new FrameFixture((Frame) window);
        IHMFix.show();
	}

	@After
	public void tearDown() throws Exception {
		IHMFix.cleanUp();
	}
	
	/**
	 * Test du demarrage du metronome (Bouton Start)
	 */
	@Test
	public void testSetCmdButtonStart() {
		IHMFix.button(Metronome.BUTTON_START).click();
		assertTrue("Test du demarrage du metronome (Bouton Start)", motor.isStarted());
	}

	/**
	 * Test de l'arret du metronome (Bouton Stop)
	 */
	@Test
	public void testSetCmdButtonStop() {
		IHMFix.button(Metronome.BUTTON_START).click();
		IHMFix.button(Metronome.BUTTON_STOP).click();
		assertTrue("Test de l'arret du metronome (Bouton Stop)", !motor.isStarted());
	}

	/**
	 * Test de l'incrementation d'une step (Bouton Inc)
	 */
	@Test
	public void testSetCmdButtonInc() {
		int steps = motor.getSteps();
		IHMFix.button(Metronome.BUTTON_INC_TEMPO).click();
		assertTrue("Test de l'incrementation d'une step (Bouton Inc)", motor.getSteps()==steps+1);
	}

	/**
	 * Test de la decrementation d'une step (Bouton Dec)
	 */
	@Test
	public void testSetCmdButtonDec() {
		int steps = motor.getSteps();
		IHMFix.button(Metronome.BUTTON_DEC_TEMPO).click();
		assertTrue("Test de la decrementation d'une step (Bouton Dec)", motor.getSteps()==steps-1);
	}

	/**
	 * Test de l'affichage du tempo
	 */
	@Test
	public void testSetDisplayTempo() {
		motor.setTempo(Metronome.MAX_TEMPO);
		assertTrue("Test de l'affichage du tempo", IHMFix.label().text().contains(String.valueOf(Metronome.MAX_TEMPO)));
	}

	/**
	 * Test de l'affichage d'une step
	 */
	@Test
	public void testFlashStep() {
		boolean res = false;
		motor.setStarted(true);
		
		long start = System.currentTimeMillis();
		while (!res && start+1500 > System.currentTimeMillis()) {
			if (IHMFix.panel("ledStep").background().target().equals(Metronome.LED_ON))
				res = true;
		}
		
		assertTrue("Test de l'affichage d'une step", res);
	}

	/**
	 * Test de l'affichage d'une mesure
	 */
	@Test
	public void testFlashMeasure() {
		boolean res = false;
		motor.setStarted(true);
		
		long start = System.currentTimeMillis();
		while (!res && start+500 > System.currentTimeMillis()) {
			if (IHMFix.panel("ledMeasure").background().target().equals(Metronome.LED_ON))
				res = true;
		}
		
		assertTrue("Test de l'affichage d'une mesure", res);
	}
	
}
