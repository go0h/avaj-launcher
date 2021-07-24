package fr.fourtytwo.avaj.aircraft;

import fr.fourtytwo.avaj.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}
