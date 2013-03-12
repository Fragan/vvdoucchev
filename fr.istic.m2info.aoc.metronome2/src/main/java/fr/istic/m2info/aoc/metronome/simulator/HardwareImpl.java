package fr.istic.m2info.aoc.metronome.simulator;

import fr.istic.m2info.aoc.metronome.Metronome;
import fr.istic.m2info.aoc.metronome.simulator.commands.CmdDecImpl;
import fr.istic.m2info.aoc.metronome.simulator.commands.CmdIncImpl;
import fr.istic.m2info.aoc.metronome.simulator.commands.CmdStartImpl;
import fr.istic.m2info.aoc.metronome.simulator.commands.CmdStopImpl;
import fr.istic.m2info.aoc.metronome.simulator.commands.EventButtonMouseListener;
import fr.istic.m2info.aoc.metronome.simulator.commands.EventSliderObserver;

public class HardwareImpl implements Hardware {
	
	private Timer timer;
	private Keyboard keyboard;
	private Wheel wheel;
	private	SoundEmitter soundEmitter;
	private Display display;
	private IHMImpl ihm;
	
	public HardwareImpl() {
		timer = new TimerImpl();
		keyboard = new KeyboardImpl();
		wheel = new WheelImpl();
		soundEmitter = new SoundEmitterImpl();
		
		ihm = new IHMImpl();
		ihm.setDisplayTempo(Metronome.INITIAL_TEMPO);
		ihm.setCmdButtonStart(new EventButtonMouseListener(new CmdStartImpl(
				this)));
		ihm.setCmdButtonStop(new EventButtonMouseListener(new CmdStopImpl(
				this)));
		ihm.setCmdButtonInc(new EventButtonMouseListener(new CmdIncImpl(
				this)));
		ihm.setCmdButtonDec(new EventButtonMouseListener(new CmdDecImpl(
				this)));
		ihm.setCmdSliderChange(new EventSliderObserver(ihm, wheel));
		
		display = new DisplayImpl(ihm);
	}
	
	public Timer getTimer() {
		return timer;
	}

	public Keyboard getKeyBoard() {
		return keyboard;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public SoundEmitter getSoundEmitter() {
		return soundEmitter;
	}

	public Display getDisplay() {
		return display;
	}
	
	public IHMImpl getIHM() {
		return ihm;
	}

}
