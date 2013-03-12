package fr.istic.m2info.aoc.metronome.simulator;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import fr.istic.m2info.aoc.metronome.Metronome;
import fr.istic.m2info.aoc.metronome.simulator.commands.EventButtonMouseListener;
import fr.istic.m2info.aoc.metronome.simulator.commands.EventSliderObserver;

/**
 * Implémentation de l'IHM en SWING
 * 
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class IHMImpl extends JFrame {

	private static final long serialVersionUID = -6575092568910649858L;
	
	/**
	 * Molette
	 */
	private JSlider slider;

	/**
	 * Afficheur
	 */
	private JLabel labelTempo;

	/**
	 * Boutons
	 */
	JButton bStart;
	JButton bStop;
	JButton bIncTempo;
	JButton bDecTempo;

	/**
	 * leds
	 */
	private JPanel led1;
	private JPanel led2;

	public IHMImpl() {
		setTitle(Metronome.TITLE_APP);
		setSize(Metronome.SIZE_X, Metronome.SIZE_Y);
		this.initialisation();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Initialise l'interface
	 */
	public void initialisation() {
		JPanel panelContainer = new JPanel();
		panelContainer.setLayout(new GridLayout(2, 1));

		// Panel Screen
		JPanel panelScreen = new JPanel();
		panelContainer.add(panelScreen);

		slider = new JSlider();
		
		labelTempo = new JLabel();

		JPanel ledContainer = new JPanel();
		ledContainer.setLayout(new GridLayout(3, 1));

		led1 = new JPanel();
		led1.setName("ledStep");
		led1.setBackground(Metronome.LED_OFF);
		ledContainer.add(led1);

		ledContainer.add(new JPanel());

		led2 = new JPanel();
		led2.setName("ledMeasure");
		led2.setBackground(Metronome.LED_OFF);
		ledContainer.add(led2);

		panelScreen.add(slider);
		panelScreen.add(labelTempo);
		panelScreen.add(ledContainer);

		// Panel Buttons
		JPanel panelButtons = new JPanel();
		panelContainer.add(panelButtons);

		bStart = new JButton(Metronome.BUTTON_START);
		bStart.setName(Metronome.BUTTON_START);
		bStop = new JButton(Metronome.BUTTON_STOP);
		bStop.setName(Metronome.BUTTON_STOP);
		bIncTempo = new JButton(Metronome.BUTTON_INC_TEMPO);
		bIncTempo.setName(Metronome.BUTTON_INC_TEMPO);
		bDecTempo = new JButton(Metronome.BUTTON_DEC_TEMPO);
		bDecTempo.setName(Metronome.BUTTON_DEC_TEMPO);

		panelButtons.add(bStart);
		panelButtons.add(bStop);
		panelButtons.add(bIncTempo);
		panelButtons.add(bDecTempo);
		
		this.setContentPane(panelContainer);
	}

	public void setCmdButtonStart(EventButtonMouseListener cmd) {
		bStart.addMouseListener(cmd);
	}

	public void setCmdButtonStop(EventButtonMouseListener cmd) {
		bStop.addMouseListener(cmd);
	}

	public void setCmdButtonInc(EventButtonMouseListener cmd) {
		bIncTempo.addMouseListener(cmd);
	}

	public void setCmdButtonDec(EventButtonMouseListener cmd) {
		bDecTempo.addMouseListener(cmd);
	}
	
	public void setCmdSliderChange(EventSliderObserver cmd) {
		slider.addChangeListener(cmd);
	}

	public float getSliderValue() {
		return (float) (slider.getValue()/100.0);
	}

	public void setDisplayTempo(int tempo) {
		labelTempo.setText(Integer.toString(tempo));
	}

	public void switchOnLEDStep() {
		led1.setBackground(Metronome.LED_ON);
	}

	public void switchOnLEDMeasure() {
		led2.setBackground(Metronome.LED_ON);
	}

	public void switchOffLEDStep() {
		led1.setBackground(Metronome.LED_OFF);
	}

	public void switchOffLEDMeasure() {
		led2.setBackground(Metronome.LED_OFF);
	}

}
