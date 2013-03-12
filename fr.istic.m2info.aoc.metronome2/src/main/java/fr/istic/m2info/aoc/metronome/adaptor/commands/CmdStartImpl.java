package fr.istic.m2info.aoc.metronome.adaptor.commands;

import fr.istic.m2info.aoc.metronome.controler.Controler;

/**
 * Commande concrete de EventButtonManager<p>
 * Permet de demarrer le metronome
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class CmdStartImpl implements CommandAdaptor {

	private Controler controler;
	
	/**
	 * Constructeur : La commande doit connaitre le controleur
	 * @param controler
	 */
	public CmdStartImpl(Controler controler) {
		this.controler = controler;
	}
	
	/**
	 * Execute la methode start du controleur
	 */
	public void execute() {
		controler.start();
	}

}
