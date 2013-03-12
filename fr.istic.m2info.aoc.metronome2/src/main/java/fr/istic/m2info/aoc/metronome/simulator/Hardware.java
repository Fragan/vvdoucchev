package fr.istic.m2info.aoc.metronome.simulator;



public interface Hardware {

	/**
	 * Permet d'acceder a l'interface de controle de l'horloge
	 * @return
	 */
	public Timer getTimer();
	
	/**
	 * Permet d'acceder a l'interface de controle du clavier
	 * @return
	 */
	public Keyboard getKeyBoard();
	
	/**
	 * Permet d'acceder a l'interface de controle de la molette
	 * @return
	 */
	public Wheel getWheel();
	
	/**
	 * Permet d'acceder a l'interface de controle de l'emetteur sonore
	 * @return
	 */
	public SoundEmitter getSoundEmitter();
	
	/**
	 * Permet d'acceder a l'interface de controle de l'afficheur
	 * @return
	 */
	public Display getDisplay();
	
	/**
	 * Retourne la Frame
	 */
	public IHMImpl getIHM();
}
