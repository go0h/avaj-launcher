package fr.fourtytwo.avaj.weather;

import java.util.ArrayList;

import fr.fourtytwo.avaj.aircraft.Coordinates;

public class WeatherTower extends Tower {

	private static final WeatherTower weatherTower = new WeatherTower();
	private static final ArrayList<String> weather = new ArrayList<String>();

	private WeatherTower() {};

	public String getWeather(Coordinates coordinates) {
		return weather.get(coordinates.getHeight());
	}

	void changeWeather() {
		//TODO
	}

	public static WeatherTower getProvider() {
		return weatherTower;
	}
}
