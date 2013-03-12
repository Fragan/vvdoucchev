package fr.istic.m2info.aoc.metronome.adaptor.commands;

import fr.istic.m2info.aoc.metronome.controler.Controler;

/**
 * Commande concrete de EventButtonManager<p>
 * Permet d'incrementer le tempo
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class CmdIncImpl implements CommandAdaptor {

	private Controler controler;
	
	/**
	 * Constructeur : La commande doit connaitre le controleur
	 * @param controler
	 */
	public CmdIncImpl(Controler controler) {
		this.controler = controler;
	}
	
	/**
	 * Execute la methode inc du controleur
	 */
	public void execute() {
		controler.inc();
	}

}
