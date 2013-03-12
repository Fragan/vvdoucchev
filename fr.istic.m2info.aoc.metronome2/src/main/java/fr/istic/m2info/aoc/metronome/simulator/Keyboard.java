package fr.istic.m2info.aoc.metronome.simulator;

/**
 * Interface Keyboard
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public interface Keyboard {

	public static final int START = 1;
	public static final int STOP = 2;
	public static final int INC = 3;
	public static final int DEC = 4;
	
	/**
	 * Retourne Vrai si le bouton keyNumber est enfoncé, Faux s'il est relache<p>
	 * Les constantes keyNumber sont definies dans cette interface
	 * @param keyBumber
	 * @return
	 */
	public boolean pressedKey(int keyNumber);
	
	/**
	 * Change l'etat du bouton keyNumber desire par le parametre state<p>
	 * Methode dediee a l'IHM
	 */
	public void setKeyState(int keyNumber, boolean state);
}
