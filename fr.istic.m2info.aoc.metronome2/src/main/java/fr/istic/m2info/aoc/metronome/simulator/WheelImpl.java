package fr.istic.m2info.aoc.metronome.simulator;


/**
 * Implementation de la molette du simulateur
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class WheelImpl implements Wheel {
	
	private float position;
	
	public float position() {
		return position;
	}
	
	public void setWheelPostition(float position) {
		this.position = position;
	}

}
