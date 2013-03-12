package fr.istic.m2info.aoc.metronome.adaptor;


public class CmdReadHardwareImpl implements CommandTimer {

	private AdapterImpl adaptor;
	
	public CmdReadHardwareImpl(AdapterImpl adaptor) {
		this.adaptor = adaptor;
	}
	
	public void execute() {
		adaptor.readHardware();
	}
	
}

