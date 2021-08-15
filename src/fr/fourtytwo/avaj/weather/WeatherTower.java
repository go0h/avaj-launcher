package fr.fourtytwo.avaj.weather;

import fr.fourtytwo.avaj.aircraft.Flyable;
import fr.fourtytwo.avaj.aircraft.Coordinates;

public class WeatherTower extends Tower {

	private WeatherProvider wProvider;

	public WeatherTower() {
		this.wProvider = WeatherProvider.getProvider();
	};

	public String getWeather(Coordinates coordinates) {
		return this.wProvider.getCurrentWeather(coordinates);
	}

	@Override
	public void register(Flyable flyable) {
		super.register(flyable);
		writer.println("Tower says: " + flyable + " registered to weather tower.");
	}

	@Override
	public void unregister(Flyable flyable) {
		super.unregister(flyable);
		writer.println("Tower says: " + flyable + " unregistered from weather tower.");
	}

	void changeWeather() {
		conditionsChanged();
	}

	public void simulateWeatherChanges(int cycles) {
		while (cycles-- > 0) {
			this.changeWeather();
		}
	}
}
