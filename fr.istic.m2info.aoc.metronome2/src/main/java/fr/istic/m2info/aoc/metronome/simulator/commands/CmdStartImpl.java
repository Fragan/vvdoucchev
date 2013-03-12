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
public class CmdStartImpl implements EventButtonManager {

	private Hardware hardware;

	/**
	 * Constructeur : La commande doit connaitre le hardware pour acceder au
	 * keyboard
	 */
	public CmdStartImpl(Hardware hardware) {
		this.hardware = hardware;
	}

	/**
	 * Met l'etat du bouton START a active
	 */
	public void executeOnClick() {
		hardware.getKeyBoard().setKeyState(Keyboard.START, true);
	}

	/**
	 * Met l'etat du bouton START a desactive
	 */
	public void executeOnRelease() {
		hardware.getKeyBoard().setKeyState(Keyboard.START, false);
	}

}
