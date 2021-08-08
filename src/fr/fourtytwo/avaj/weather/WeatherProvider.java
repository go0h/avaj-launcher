
package fr.fourtytwo.avaj.weather;

import fr.fourtytwo.avaj.aircraft.Coordinates;

public class WeatherProvider {

	private static WeatherProvider weatherProvider;
	private static String[] weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() { };

	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int i = (31 * coordinates.getLongitude() +
			31 * coordinates.getLatitude() +
			31 *  coordinates.getHeight()) % weather.length;
		return weather[i];
	}
}
