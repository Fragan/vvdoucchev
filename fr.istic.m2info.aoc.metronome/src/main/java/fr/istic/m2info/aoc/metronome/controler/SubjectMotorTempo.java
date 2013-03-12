package fr.istic.m2info.aoc.metronome.controler;

public interface SubjectMotorTempo {
	
	/**
	 * Ajouter au sujet un nouvel observateur
	 * @param o
	 */
	public void registerObserver(ObserverMotorTempo o);
	
	/**
	 * Retirer au sujet un observateur
	 * @param o
	 */
	public void unregisterObserver(ObserverMotorTempo o);
	
	/**
	 * Notifier les observateurs que le sujet a change
	 */
	public void updateObservers();
}
