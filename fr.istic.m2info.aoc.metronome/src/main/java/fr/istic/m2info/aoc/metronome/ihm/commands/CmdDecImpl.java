package fr.istic.m2info.aoc.metronome.ihm.commands;

import fr.istic.m2info.aoc.metronome.controler.Controler;

/**
 * Commande concrete de EventButtonManager<p>
 * Permet de decrementer le tempo
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class CmdDecImpl implements CommandAdaptor {

	private Controler controler;
	
	/**
	 * Constructeur : La commande doit connaitre le controleur
	 * @param controler
	 */
	public CmdDecImpl(Controler controler) {
		this.controler = controler;
	}
	
	/**
	 * Execute la methode dec du controleur
	 */
	public void execute() {
		controler.dec();
	}

}
