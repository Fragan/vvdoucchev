package fr.istic.m2info.aoc.metronome.ihm.commands;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventButtonMouseListener extends MouseAdapter {

	/**
	 * Commande a lancer au click
	 */
	private CommandAdaptor command;
	
	/**
	 * Permet de definir la commande a lancer au click
	 * @param cmd Nouvelle commande a lancer
	 */
	public EventButtonMouseListener(CommandAdaptor cmd) {
		this.command = cmd;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		this.command.execute();
	}
}
