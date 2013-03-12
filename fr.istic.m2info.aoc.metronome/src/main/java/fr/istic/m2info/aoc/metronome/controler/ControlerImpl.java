package fr.istic.m2info.aoc.metronome.controler;

import fr.istic.m2info.aoc.metronome.Metronome;
import fr.istic.m2info.aoc.metronome.ihm.IHM;
import fr.istic.m2info.aoc.metronome.motor.MotorMetronome;

public class ControlerImpl implements Controler {

	/**
	 * Acces au hardware
	 */
	private IHM view;

	/**
	 * Acces au MoteurMetronome
	 */
	private MotorMetronome motor;

	/**
	 * Temps actuel du metronome
	 */
	private int actualStep = 0;

	public void setIHM(IHM view) {
		this.view = view;
	}

	public void setMotor(MotorMetronome motor) {
		this.motor = motor;
	}

	public void start() {
		if (!motor.isStarted()) {
			actualStep = 0;
			motor.setStarted(true);
		}
	}

	public void stop() {
		if (motor.isStarted())
			motor.setStarted(false);
	}

	public void inc() {
		int steps = motor.getSteps();
		if (steps < Metronome.MAX_STEPS)
			motor.setSteps(steps + 1);
	}

	public void dec() {
		int steps = motor.getSteps();
		if (steps > Metronome.MIN_STEPS)
			motor.setSteps(steps - 1);
	}

	public void displayStep() {
		if (actualStep == 0) {
			view.clicEmitterMeasure();
			view.flashMeasure();
		} else {
			view.clicEmitterStep();
			view.flashStep();
		}
		actualStep = (actualStep + 1) % motor.getSteps();
	}

	/* ===================== Observer ===================== */

	public void updateDisplayTempo(SubjectMotorTempo s) {
		view.setDisplayTempo(((MotorMetronome) s).getTempo());
	}

	public void updateWheel(SubjectWheel s) {
		int tempo = Metronome.MIN_TEMPO
				+ (int) (((IHM) s).getWheelPosition() * (Metronome.MAX_TEMPO - Metronome.MIN_TEMPO));
		motor.setTempo(tempo);
	}
}
