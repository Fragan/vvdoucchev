package fr.istic.m2info.aoc.metronome.adaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import fr.istic.m2info.aoc.metronome.Metronome;
import fr.istic.m2info.aoc.metronome.adaptor.commands.CommandAdaptor;
import fr.istic.m2info.aoc.metronome.controler.ObserverWheel;
import fr.istic.m2info.aoc.metronome.simulator.Display;
import fr.istic.m2info.aoc.metronome.simulator.Hardware;
import fr.istic.m2info.aoc.metronome.simulator.Keyboard;
import fr.istic.m2info.aoc.metronome.simulator.SoundEmitter;
import fr.istic.m2info.aoc.metronome.utils.Horloge;
import fr.istic.m2info.aoc.metronome.utils.HorlogeImpl;

public class AdapterImpl implements IHM {

	private List<ObserverWheel> observersList;

	private Hardware hardware;
	private boolean[] previousKeysState;
	private float previousWheelPosition;
	private int nbIterationSlider;
	private boolean wheelStateChangeValue;

	private CommandAdaptor cmdButtonStart;
	private CommandAdaptor cmdButtonStop;
	private CommandAdaptor cmdButtonInc;
	private CommandAdaptor cmdButtonDec;

	public AdapterImpl(Hardware hardware) {
		this.hardware = hardware;

		observersList = new ArrayList<ObserverWheel>();

		Horloge horloge = new HorlogeImpl();
		horloge.periodicallyActivate(new CmdReadHardwareImpl(this), Metronome.TIME_READ_HARDWARE);

		previousKeysState = new boolean[5];
		for (int i = 0; i < previousKeysState.length; i++) {
			previousKeysState[i] = false;
		}

		nbIterationSlider = 0;
		wheelStateChangeValue = false;
	}

	public void readHardware() {

		// Read keys
		boolean current = hardware.getKeyBoard().pressedKey(Keyboard.START);
		if (current != previousKeysState[Keyboard.START]) {
			if (current)
				cmdButtonStart.execute();
			previousKeysState[Keyboard.START] = current;
		}

		current = hardware.getKeyBoard().pressedKey(Keyboard.STOP);
		if (current != previousKeysState[Keyboard.STOP]) {
			if (current)
				cmdButtonStop.execute();
			previousKeysState[Keyboard.STOP] = current;
		}
		
		current = hardware.getKeyBoard().pressedKey(Keyboard.INC);
		if (current != previousKeysState[Keyboard.INC]) {
			if (current)
				cmdButtonInc.execute();
			previousKeysState[Keyboard.INC] = current;
		}

		current = hardware.getKeyBoard().pressedKey(Keyboard.DEC);
		if (current != previousKeysState[Keyboard.DEC]) {
			if (current)
				cmdButtonDec.execute();
			previousKeysState[Keyboard.DEC] = current;
		}

		// Limite l'envoi d'update par la molette

		// Reinitialise les valeurs en cas de changement
		if (previousWheelPosition != hardware.getWheel().position()) {
			previousWheelPosition = hardware.getWheel().position();
			nbIterationSlider = 0;
			wheelStateChangeValue = true;
		}

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

	public float getWheelPosition() {
		return previousWheelPosition;
	}
	
	public void setDisplayTempo(int tempo) {
		hardware.getDisplay().displayTemo(tempo);
	}

	public void flashStep() {
		hardware.getDisplay().switchOnLED(Display.STEP_LED);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				hardware.getDisplay().switchOffLED(Display.STEP_LED);
			}
		}, 100);
	}

	public void flashMeasure() {
		hardware.getDisplay().switchOnLED(Display.MEASURE_LED);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				hardware.getDisplay().switchOffLED(Display.MEASURE_LED);
			}
		}, 100);
	}

	public void clicEmitterStep() {
		hardware.getSoundEmitter().clicEmitter(SoundEmitter.CLIC_BEAT);
	}

	public void clicEmitterMeasure() {
		hardware.getSoundEmitter().clicEmitter(SoundEmitter.CLIC_MEASURE);
	}

	public void setCmdButtonStart(CommandAdaptor cmd) {
		cmdButtonStart = cmd;
	}

	public void setCmdButtonStop(CommandAdaptor cmd) {
		cmdButtonStop = cmd;
	}

	public void setCmdButtonInc(CommandAdaptor cmd) {
		cmdButtonInc = cmd;
	}

	public void setCmdButtonDec(CommandAdaptor cmd) {
		cmdButtonDec = cmd;
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
