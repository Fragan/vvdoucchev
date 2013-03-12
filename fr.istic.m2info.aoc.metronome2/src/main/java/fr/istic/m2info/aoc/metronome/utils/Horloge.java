package fr.istic.m2info.aoc.metronome.utils;

import fr.istic.m2info.aoc.metronome.utils.Command;

public interface Horloge {

	/**
	 * Appel periodique de l'operation execute() de cmd, toutes les
	 * perdiodInMiliSeconds, avec une precision d'une milliseconde
	 * 
	 * @param cmd
	 * @param perdiodInSeconds
	 */
	public void periodicallyActivate(Command cmd, double perdiodInMiliSeconds);

	/**
	 * Desactivation de la commande
	 */
	public void desactivate(Command cmd);
}