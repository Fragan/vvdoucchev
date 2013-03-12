package fr.istic.m2info.aoc.metronome.simulator.commands;

import fr.istic.m2info.aoc.metronome.simulator.Hardware;
import fr.istic.m2info.aoc.metronome.simulator.Keyboard;

/**
 * Commande concrete de EventButtonManager
 * <p>
 * Permet de mettre le bon etat de l'IHM dans le keyboard
 * 
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class CmdStopImpl implements EventButtonManager {

	private Hardware hardware;

	/**
	 * Constructeur : La commande doit connaitre le hardware pour acceder au
	 * keyboard
	 */
	public CmdStopImpl(Hardware hardware) {
		this.hardware = hardware;
	}

	/**
	 * Met l'etat du bouton STOP a active
	 */
	public void executeOnClick() {
		hardware.getKeyBoard().setKeyState(Keyboard.STOP, true);
	}

	/**
	 * Met l'etat du bouton STOP a desactive
	 */
	public void executeOnRelease() {
		hardware.getKeyBoard().setKeyState(Keyboard.STOP, false);
	}

}
