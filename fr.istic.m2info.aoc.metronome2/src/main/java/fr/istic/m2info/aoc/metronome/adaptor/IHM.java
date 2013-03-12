package fr.istic.m2info.aoc.metronome.adaptor;

import fr.istic.m2info.aoc.metronome.adaptor.commands.CommandAdaptor;
import fr.istic.m2info.aoc.metronome.controler.SubjectWheel;


/**
 * Interface de l'adaptateur
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public interface IHM extends SubjectWheel {
	
	/**
	 * @return Retourne la valeur actuelle de la molette (de 0 a 1)
	 */
	public float getWheelPosition();

	/**
	 * Permet de mettre a jour l'affichage du tempo
	 * @param tempo Valeur du tempo à afficher
	 */
	public void setDisplayTempo(int tempo);
	
	/**
	 * Affiche un flash de la LED de step
	 */
	public void flashStep();

	/**
	 * Affiche un flash de la LED de mesure
	 */
	public void flashMeasure();
	
	/**
	 * Permet d'emettre un click de step
	 */
	public void clicEmitterStep();
	
	/**
	 * Permet d'emettre un click de mesure
	 */
	public void clicEmitterMeasure();
	
	/**
	 * Permet de changer la CommandAdaptor a executer sur le bouton start 
	 */
	public void setCmdButtonStart(CommandAdaptor cmd);
	
	/**
	 * Permet de changer la CommandAdaptor a executer sur le bouton stop 
	 */
	public void setCmdButtonStop(CommandAdaptor cmd);
	
	/**
	 * Permet de changer la CommandAdaptor a executer sur le bouton inc 
	 */
	public void setCmdButtonInc(CommandAdaptor cmd);
	
	/**
	 * Permet de changer la CommandAdaptor a executer sur le bouton dec 
	 */
	public void setCmdButtonDec(CommandAdaptor cmd);
}
