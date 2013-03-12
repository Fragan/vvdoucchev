package fr.istic.m2info.aoc.metronome.controler;

import fr.istic.m2info.aoc.metronome.adaptor.IHM;
import fr.istic.m2info.aoc.metronome.motor.MotorMetronome;

/**
 * Interface du controleur
 * 
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public interface Controler extends ObserverMotorTempo, ObserverWheel {
	
	/**
	 * @param ihm
	 *            Acces a l'ihm
	 */
	public void setIHM(IHM ihm);

	/**
	 * @param motor
	 *            Acces au moteur
	 */
	public void setMotor(MotorMetronome motor);

	/**
	 * Commande permettant de demarrer le moteur via le controleur
	 */
	public void start();

	/**
	 * Commande permettant de stoper le moteur via le controleur
	 */
	public void stop();

	/**
	 * Commande permettant d'incrementer le tempo
	 */
	public void inc();

	/**
	 * Commande permettant de decrementer le tempo
	 */
	public void dec();

	/**
	 * Commande permettant de flasher la led marquant le temps
	 */
	public void displayStep();
}
