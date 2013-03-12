package fr.istic.m2info.aoc.metronome.controler;


public interface ObserverWheel {

	/**
	 * Observer<p>
	 * Recuperation de la mise a jour de la valeur de position de la molette
	 * @param s
	 */
	public void updateWheel(SubjectWheel s);
}
