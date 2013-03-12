package fr.istic.m2info.aoc.metronome.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class HorlogeImpl implements Horloge {

	private Timer timer = new Timer();
	private Map<Command, TimerTask> tasks = new HashMap<Command, TimerTask>();

	public void periodicallyActivate(final Command cmd,
			double perdiodInMiliSeconds) {
		TimerTask task = new TimerTask() {
			public void run() {
				cmd.execute();
			}
		};
		if (cmd != null)
			timer.schedule(task, 0, (long) perdiodInMiliSeconds);
		
		tasks.put(cmd, task);
	}

	public void desactivate(Command cmd) {
		tasks.get(cmd).cancel();
	}
}
