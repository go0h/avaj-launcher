package fr.fourtytwo.avaj;

import java.util.ArrayList;

import fr.fourtytwo.avaj.aircraft.Flyable;

public abstract class Tower {

	private ArrayList<Flyable> observes;

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
		for (Flyable flyable: observes) {
			flyable.updateConditions();
		}
	}
}
