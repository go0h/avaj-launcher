package fr.fourtytwo.avaj.weather;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import fr.fourtytwo.avaj.aircraft.Flyable;

public abstract class Tower {

	private List<Flyable> observes = new ArrayList<Flyable>();
	protected PrintStream writer = System.out;

	public void register(Flyable flyable) {
		if (!observes.contains(flyable)) {
			observes.add(flyable);
		}
	}

	public void unregister(Flyable flyable) {
		if (observes.contains(flyable)) {
			observes.remove(flyable);
		}
	}

	protected void conditionsChanged() {
		for (int i = 0; i < observes.size(); ++i) {
			observes.get(i).updateConditions();
		}
	}

	public void registerWriter(PrintStream writer) {
		this.writer = writer;
	}
}
