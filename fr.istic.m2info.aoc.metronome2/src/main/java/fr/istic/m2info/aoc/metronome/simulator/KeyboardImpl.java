package fr.istic.m2info.aoc.metronome.simulator;

/**
 * Implementation du clavier du simulateur
 * @author "Chevallier - Douchement"
 *
 */
public class KeyboardImpl implements Keyboard {

	private boolean[] keyBoardState;
	
	public KeyboardImpl() {
		keyBoardState = new boolean[5];
		for(int i=0; i<keyBoardState.length; i++) {
			keyBoardState[i]  = false;
		}
	}
	
	public boolean pressedKey(int keyNumber) {
		return keyBoardState[keyNumber];
	}
	
	public void setKeyState(int keyNumber, boolean state) {
		keyBoardState[keyNumber] = state;
	}

}
