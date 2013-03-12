package fr.istic.m2info.aoc.metronome.simulator;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import fr.istic.m2info.aoc.metronome.Metronome;

public class SoundEmitterImpl implements SoundEmitter {

	public void clicEmitter(int clicNumber) {
		if (Metronome.AUDIO_ACTIVATED) {
			switch (clicNumber) {
			case CLIC_BEAT:
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
				break;

			case CLIC_MEASURE:
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
				break;

			default:
				throw new Error("Sound unspecified");
			}
		}
	}
}
