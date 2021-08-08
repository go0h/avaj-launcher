package fr.fourtytwo.avaj.weather;

import java.util.ArrayList;
import fr.fourtytwo.avaj.aircraft.Flyable;

public abstract class Tower {

	private ArrayList<Flyable> observes = new ArrayList<Flyable>();

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
}
