package fr.istic.m2info.aoc.metronome.ihm;

import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.istic.m2info.aoc.metronome.Metronome;
import fr.istic.m2info.aoc.metronome.controler.ObserverWheel;
import fr.istic.m2info.aoc.metronome.ihm.commands.CommandAdaptor;
import fr.istic.m2info.aoc.metronome.ihm.commands.EventButtonMouseListener;

/**
 * Implémentation de l'IHM en SWING
 * 
 * @author "Chevallier - Douchement"
 * @version 1.0
 */
public class IHMImpl extends JFrame implements IHM {

	private static final long serialVersionUID = -6575092568910649858L;
	
	private List<ObserverWheel> observersList;
	
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

	private float previousWheelPosition;
	protected int nbIterationSlider;
	protected boolean wheelStateChangeValue;

	public IHMImpl() {
		setTitle(Metronome.TITLE_APP);
		setSize(Metronome.SIZE_X, Metronome.SIZE_Y);
		this.initialisation();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		observersList = new ArrayList<ObserverWheel>();
		
		nbIterationSlider = 0;
		wheelStateChangeValue = false;
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
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				// Reinitialise les valeurs en cas de changement
				float newVal = (float) (slider.getValue()/100.0);
				if (previousWheelPosition != newVal) {
					previousWheelPosition = newVal;
					nbIterationSlider = 0;
					wheelStateChangeValue = true;
				}
				System.out.println(newVal);

				// Si la nouvelle valeur est egale a la valeur de l'ancien update, on
				// incremente un compteur
				if (wheelStateChangeValue) {
					nbIterationSlider++;
					// Si il y a eu assez d'iteration sur cette valeur
					if (nbIterationSlider >= Metronome.NB_ITERATION_SLIDER_BEFORE_UPDATE) {
						updateObservers();
						wheelStateChangeValue = false;
					}
				}
			}
		});
		
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

	public void setCmdButtonStart(CommandAdaptor cmd) {
		bStart.addMouseListener(new EventButtonMouseListener(cmd));
	}

	public void setCmdButtonStop(CommandAdaptor cmd) {
		bStop.addMouseListener(new EventButtonMouseListener(cmd));
	}

	public void setCmdButtonInc(CommandAdaptor cmd) {
		bIncTempo.addMouseListener(new EventButtonMouseListener(cmd));
	}

	public void setCmdButtonDec(CommandAdaptor cmd) {
		bDecTempo.addMouseListener(new EventButtonMouseListener(cmd));
	}

	public float getWheelPosition() {
		return (float) (slider.getValue()/100.0);
	}

	public void setDisplayTempo(int tempo) {
		labelTempo.setText(Integer.toString(tempo));
	}

	public void flashStep() {
		led1.setBackground(Metronome.LED_ON);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				led1.setBackground(Metronome.LED_OFF);
			}
		}, 100);
	}

	public void flashMeasure() {
		led2.setBackground(Metronome.LED_ON);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				led2.setBackground(Metronome.LED_OFF);
			}
		}, 100);
	}
	
	public void clicEmitterStep() {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(new URL(
									Metronome.URL_CLICK_STEP));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}

	public void clicEmitterMeasure() {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(new URL(
									Metronome.URL_CLICK_MEASURE));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}
	
	/* ===================== Observer ===================== */

	public void registerObserver(ObserverWheel o) {
		observersList.add(o);
	}

	public void unregisterObserver(ObserverWheel o) {
		observersList.remove(o);
	}

	public void updateObservers() {
		for (ObserverWheel o : observersList) {
			o.updateWheel(this);
		}
	}

}
