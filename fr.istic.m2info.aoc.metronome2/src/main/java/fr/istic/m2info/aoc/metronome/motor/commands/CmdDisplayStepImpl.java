package fr.istic.m2info.aoc.metronome.motor.commands;

import fr.istic.m2info.aoc.metronome.controler.Controler;

/**
 * Commande concrete de EventMotorManager<p>
 * Permet de flasher la led marquant le temps
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class CmdDisplayStepImpl implements CommandMotor {

	private Controler controler;
	
	/**
	 * Constructeur : La commande doit connaitre le controleur
	 * @param controler
	 */
	public CmdDisplayStepImpl(Controler controler) {
		this.controler = controler;
	}
	
	/**
	 * Execute la methode displayStep du controleur
	 */
	public void execute() {
		controler.displayStep();
	}

}
