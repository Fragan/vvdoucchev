package fr.istic.m2info.aoc.metronome.simulator;

public interface Display {

	public static final int STEP_LED = 1;
	public static final int MEASURE_LED = 2;
	
	/**
	 * Controle d'allumage des LEDs<p>
	 * Les constantes ledNumber sont definies dans cette interface
	 * @param ledNumber
	 */
	public void switchOnLED(int ledNumber);

	/**
	 * Controle d'eteignage des LEDs<p>
	 * Les constantes ledNumber sont definies dans cette interface
	 * @param ledNumber
	 */
	public void switchOffLED(int ledNumber);
	
	/**
	 * Affiche un entier sur l'afficheur externe du metronome
	 * @param tempoValue
	 */
	public void displayTemo(int tempoValue);
}
