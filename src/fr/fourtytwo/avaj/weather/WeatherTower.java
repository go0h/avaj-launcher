package fr.fourtytwo.avaj.weather;

import fr.fourtytwo.avaj.aircraft.*;

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
		System.out.println("Tower says: " + flyable + " registered to weather tower.");
	}

	@Override
	public void unregister(Flyable flyable) {
		super.unregister(flyable);
		System.out.println("Tower says: " + flyable + " unregistered from weather tower.");
	}

	void changeWeather() {
		conditionsChanged();
	}

	public void simulateWeatherChanges(int cycles) {
		while (cycles-- > 0) {
			this.changeWeather();
			System.out.println("Cycle to go " + cycles);
		}

	}
}
