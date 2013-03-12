package fr.istic.m2info.aoc.metronome.simulator;

public interface Wheel {

	/**
	 * Retourne la position de la molette, entre 0.0 et 1.0, en flotant simple
	 * precision
	 * @return
	 */
	public float position();
	
	/**
	 * Change la position de la molette<p>
	 * Methode dediee a l'IHM
	 * @param position
	 */
	public void setWheelPostition(float position);
}
