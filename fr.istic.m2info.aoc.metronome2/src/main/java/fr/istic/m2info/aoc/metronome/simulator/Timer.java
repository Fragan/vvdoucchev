package fr.istic.m2info.aoc.metronome.simulator;


public interface Timer {

	/**
	 * Appel periodique de l'operation execute() de cmd, toutes les
	 * perdiodInMiliSeconds, avec une precision d'une milliseconde
	 * 
	 * @param cmd
	 * @param perdiodInSeconds
	 */
	public void periodicallyActivate(CommandSimulator cmd,
			double perdiodInMiliSeconds);

	/**
	 * Appel de l'operation execute() de cmd, apres un delai de
	 * delayInMiliSeconds avec une precision d'une milliseconde
	 * 
	 * @param cmd
	 * @param delayInMiliSeconds
	 */
	public void afterDelayActivate(CommandSimulator cmd,
			double delayInMiliSeconds);

	/**
	 * Desactivation de la commande
	 */
	public void desactivate(CommandSimulator cmd);
}
