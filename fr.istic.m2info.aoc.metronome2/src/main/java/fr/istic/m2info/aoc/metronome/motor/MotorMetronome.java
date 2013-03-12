package fr.istic.m2info.aoc.metronome.motor;

import fr.istic.m2info.aoc.metronome.controler.SubjectMotorTempo;
import fr.istic.m2info.aoc.metronome.motor.commands.CommandMotor;


/**
 * Interface du Moteur de Metronome
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public interface MotorMetronome extends SubjectMotorTempo {
	
	/**
	 * Retourne l'état du métronome (true == marche, false == arret)
	 */
	public boolean isStarted();
	
	/**
	 * Change l'état du métronome (true == marche, false == arret)
	 */
	public void setStarted(boolean state);
	
	/**
	 * Permet de changer la commande pour marquer un temps 
	 */
	public void setCmdDisplayStep(CommandMotor cmd);
	
	/**
	 * @return the tempo
	 */
	public int getTempo();

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(int tempo);
	
	/**
	 * @return the steps
	 */
	public int getSteps();

	/**
	 * @param tempo the tempo to set
	 */
	public void setSteps(int steps);
}
