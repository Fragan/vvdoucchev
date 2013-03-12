package fr.istic.m2info.aoc.metronome;

import java.awt.Color;

import fr.istic.m2info.aoc.metronome.controler.Controler;
import fr.istic.m2info.aoc.metronome.controler.ControlerImpl;
import fr.istic.m2info.aoc.metronome.controler.ObserverMotorTempo;
import fr.istic.m2info.aoc.metronome.controler.ObserverWheel;
import fr.istic.m2info.aoc.metronome.ihm.IHM;
import fr.istic.m2info.aoc.metronome.ihm.IHMImpl;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdDecImpl;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdIncImpl;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdStartImpl;
import fr.istic.m2info.aoc.metronome.ihm.commands.CmdStopImpl;
import fr.istic.m2info.aoc.metronome.motor.MotorMetronome;
import fr.istic.m2info.aoc.metronome.motor.MotorMetronomeImpl;
import fr.istic.m2info.aoc.metronome.motor.commands.CmdDisplayStepImpl;

/**
 * Client des PCs Command
 * 
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class Metronome {

	public static final String TITLE_APP = "Métronome";
	public static final int SIZE_X = 500;
	public static final int SIZE_Y = 200;
	public static final String BUTTON_START = "Démarrer";
	public static final String BUTTON_STOP = "Arreter";
	public static final String BUTTON_INC_TEMPO = "Inc.";
	public static final String BUTTON_DEC_TEMPO = "Dec.";
	public static final int MIN_TEMPO = 50;
	public static final int MAX_TEMPO = 200;
	public static final int MIN_STEPS = 2;
	public static final int MAX_STEPS = 7;
	public static final int NB_ITERATION_SLIDER_BEFORE_UPDATE = 2;
	public static final boolean AUDIO_ACTIVATED = true;
	public static final String URL_CLICK_STEP = "file://"
			+ System.getProperty("user.dir") + "/ressource/ClickStep.wav";
	public static final String URL_CLICK_MEASURE = "file://"
			+ System.getProperty("user.dir") + "/ressource/ClickMeasure.wav";
	public static final int INITIAL_TEMPO = (MIN_TEMPO + MAX_TEMPO) / 2;
	public static final Color LED_OFF= Color.GRAY;
	public static final Color LED_ON = Color.GREEN;
	
	public static void main(String[] args) {

		Controler controler = new ControlerImpl();

		MotorMetronome motor = new MotorMetronomeImpl();
		motor.setCmdDisplayStep(new CmdDisplayStepImpl(controler));
		motor.setTempo(INITIAL_TEMPO);

		IHM window = new IHMImpl();
		window.setDisplayTempo(INITIAL_TEMPO);
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
	}
}
