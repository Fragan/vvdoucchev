package fr.istic.m2info.aoc.metronome.controler;


public interface ObserverMotorTempo {

	/**
	 * Observer<p>
	 * Recuperation de la mise a jour de la valeur de tempo du sujet
	 * @param s
	 */
	public void updateDisplayTempo(SubjectMotorTempo s);
}
