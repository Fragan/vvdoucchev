package fr.istic.m2info.aoc.metronome.simulator.commands;

/**
 * Interface du PC Command de l'IHM vers le controlleur
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public interface EventButtonManager {
	
	/**
	 * Methode du lancement de l'execution d'une commande au click
	 */
	public void executeOnClick();
	
	/**
	 * Methode du lancement de l'execution d'une commande au relachement
	 */
	public void executeOnRelease();
}
