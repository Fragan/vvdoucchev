package fr.istic.m2info.aoc.metronome.simulator.commands;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.istic.m2info.aoc.metronome.simulator.IHMImpl;
import fr.istic.m2info.aoc.metronome.simulator.Wheel;

public class EventSliderObserver implements ChangeListener {

	/**
	 * IHM
	 */
	private IHMImpl ihm;
	
	/**
	 * Wheel
	 */
	private Wheel wheel; 
	
	/**
	 * Permet de definir le controleur à notifier en cas de changement
	 * @param c Controleur
	 */
	public EventSliderObserver(IHMImpl ihm, Wheel wheel) {
		this.ihm = ihm;
		this.wheel = wheel;
	}
	
	public void stateChanged(ChangeEvent e) {
		wheel.setWheelPostition(ihm.getSliderValue());
	}

}
