package fr.fourtytwo.avaj.aircraft;

import fr.fourtytwo.avaj.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		System.out.println(this.getClass().getSimpleName() + " updateConditions");
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
