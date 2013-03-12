package fr.istic.m2info.aoc.metronome.simulator;

public interface SoundEmitter {

	public static final int CLIC_BEAT = 1;
	public static final int CLIC_MEASURE = 2;
	
	/**
	 * Emission d'un son pour marquer le temps
	 * @param clicNumber Numero du clic a jouer
	 */
	public void clicEmitter(int clicNumber);
}
