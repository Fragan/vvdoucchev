package fr.istic.m2info.aoc.metronome.simulator;


public class DisplayImpl implements Display {

	private IHMImpl ihm;
	
	public DisplayImpl(IHMImpl ihm) {
		this.ihm = ihm;
	}
	
	public void switchOnLED(int ledNumber) {
		switch (ledNumber) {
		case STEP_LED:
			ihm.switchOnLEDStep();
			break;
		case MEASURE_LED:
			ihm.switchOnLEDMeasure();
			break;
		default:
			throw new Error("Unknown LED");
		}
	}

	public void switchOffLED(int ledNumber) {
		switch (ledNumber) {
		case STEP_LED:
			ihm.switchOffLEDStep();
			break;
		case MEASURE_LED:
			ihm.switchOffLEDMeasure();
			break;
		default:
			throw new Error("Unknown LED");
		}
	}

	public void displayTemo(int tempoValue) {
		ihm.setDisplayTempo(tempoValue);
	}

}
