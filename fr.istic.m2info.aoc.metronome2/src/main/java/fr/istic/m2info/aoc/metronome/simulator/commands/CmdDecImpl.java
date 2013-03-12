package fr.istic.m2info.aoc.metronome.simulator.commands;

import fr.istic.m2info.aoc.metronome.simulator.Hardware;
import fr.istic.m2info.aoc.metronome.simulator.Keyboard;

/**
 * Commande concrete de EventButtonManager<p>
 * Permet de mettre le bon etat de l'IHM dans le keyboard
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class CmdDecImpl implements EventButtonManager {

	private Hardware hardware;

	/**
	 * Constructeur : La commande doit connaitre le hardware pour acceder au
	 * keyboard
	 */
	public CmdDecImpl(Hardware hardware) {
		this.hardware = hardware;
	}
	
	/**
	 * Met l'etat du bouton DEC a active
	 */
	public void executeOnClick() {
		hardware.getKeyBoard().setKeyState(Keyboard.DEC, true);
	}
	
	/**
	 * Met l'etat du bouton DEC a desactive
	 */
	public void executeOnRelease() {
		hardware.getKeyBoard().setKeyState(Keyboard.DEC, false);
	}

}
