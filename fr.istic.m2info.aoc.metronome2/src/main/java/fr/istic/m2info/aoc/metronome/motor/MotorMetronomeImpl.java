package fr.istic.m2info.aoc.metronome.motor;

import java.util.ArrayList;
import java.util.List;

import fr.istic.m2info.aoc.metronome.controler.ObserverMotorTempo;
import fr.istic.m2info.aoc.metronome.motor.commands.CommandMotor;
import fr.istic.m2info.aoc.metronome.utils.Horloge;
import fr.istic.m2info.aoc.metronome.utils.HorlogeImpl;

public class MotorMetronomeImpl implements MotorMetronome {

	private List<ObserverMotorTempo> observersList;
	
	/**
	 * Valeur du tempo
	 */
	private int tempo;
	
	private int steps = 4;
	
	private boolean started;

	private Horloge horloge;
	
	private CommandMotor cmdDisplayStep;

	/**
	 * Constructeur :<p>
	 * <li> Instanciation de la liste d'observateurs
	 */
	public MotorMetronomeImpl() {
		observersList = new ArrayList<ObserverMotorTempo>();
		horloge = new HorlogeImpl();
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
		if (started) {
			double delayStep = (60.0 / tempo) * 1000;
			horloge.periodicallyActivate(cmdDisplayStep, delayStep);
		} else {
			horloge.desactivate(cmdDisplayStep);
		}
	}

	public void setCmdDisplayStep(CommandMotor cmd) {
		cmdDisplayStep = cmd;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
		if (started) {
			double delayStep = (60.0 / tempo) * 1000;
			horloge.desactivate(cmdDisplayStep);
			horloge.periodicallyActivate(cmdDisplayStep, delayStep);
		}
		updateObservers();
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	
	/*===================== Observer =====================*/
	
	public void registerObserver(ObserverMotorTempo o) {
		observersList.add(o);	
	}

	public void unregisterObserver(ObserverMotorTempo o) {
		observersList.remove(o);		
	}

	public void updateObservers() {
		for (ObserverMotorTempo o : observersList) {
			o.updateDisplayTempo(this);
		}
	}
	
}
