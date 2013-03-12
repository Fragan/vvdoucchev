package fr.istic.m2info.aoc.metronome.controler;

/**
 * 
 * @author "Chevallier - Douchement"
 *
 */
public interface SubjectWheel {
	
	/**
	 * Ajouter au sujet un nouvel observateur
	 * @param o
	 */
	public void registerObserver(ObserverWheel o);
	
	/**
	 * Retirer au sujet un observateur
	 * @param o
	 */
	public void unregisterObserver(ObserverWheel o);
	
	/**
	 * Notifier les observateurs que le sujet a change
	 */
	public void updateObservers();
}
