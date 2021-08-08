package fr.fourtytwo.avaj.aircraft;

import fr.fourtytwo.avaj.weather.WeatherTower;
import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	private static HashMap<String, int[]> weatherReflection = new HashMap<String, int[]>();

	/* SUN - Longitude increases with 2, Height increases with 4
	 * RAIN - Height decreases with 5
	 * FOG - Height decreases with 3
	 * SNOW - Height decreases with 15 */
	static {
		weatherReflection.put("RAIN", new int[]{0, 0, -5});
		weatherReflection.put("FOG", new int[]{0, 0, -3});
		weatherReflection.put("SUN", new int[]{2, 0, 4});
		weatherReflection.put("SNOW", new int[]{0, 0, -15});
	}

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		if (weatherTower != null) {

			String weather = this.weatherTower.getWeather(this.coordinates);
			if (!weatherReflection.keySet().contains(weather)) {
				throw new IllegalArgumentException("Can't recognize weather type " + weather);
			}
			System.out.println(this.toString() + ": got " + weather.toLowerCase() + "ified seriously");

			int[] deltas = weatherReflection.get(weather);
			this.coordinates = new Coordinates(
				coordinates.getLongitude() + deltas[0],
				coordinates.getLatitude() + deltas[1],
				coordinates.getHeight() + deltas[2]);
			if (coordinates.getHeight() <= 0) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
				System.out.println(this.toString() + " is landing");
				this.weatherTower.unregister(this);
			}
			if (coordinates.getHeight() >= 100) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
			}
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
