package fr.istic.m2info.aoc.metronome.ihm.commands;

import fr.istic.m2info.aoc.metronome.controler.Controler;

/**
 * Commande concrete de EventButtonManager<p>
 * Permet d'arreter le metronome
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class CmdStopImpl implements CommandAdaptor {

	private Controler controler;
	
	/**
	 * Constructeur : La commande doit connaitre le controleur
	 * @param controler
	 */
	public CmdStopImpl(Controler controler) {
		this.controler = controler;
	}
	
	/**
	 * Execute la methode stop du controleur
	 */
	public void execute() {
		controler.stop();
	}

}
