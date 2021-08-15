package fr.fourtytwo.avaj.aircraft;

import java.io.PrintStream;
import java.util.HashMap;
import fr.fourtytwo.avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private PrintStream writer = System.out;

	private static HashMap<String, int[]> weatherReflection = new HashMap<String, int[]>();

	/* SUN - Longitude increases with 10, Height increases with 2
	 * RAIN - Longitude increases with 5
	 * FOG - Longitude increases with 1
	 * SNOW - Height decreases with 12 */
	static {
		weatherReflection.put("SUN", new int[]{10, 0, 2});
		weatherReflection.put("RAIN", new int[]{5, 0, 0});
		weatherReflection.put("FOG", new int[]{1, 0, 0});
		weatherReflection.put("SNOW", new int[]{0, 0, -12});
	}

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		if (weatherTower != null) {

			String weather = this.weatherTower.getWeather(this.coordinates);
			if (!weatherReflection.keySet().contains(weather)) {
				throw new IllegalArgumentException("Can't recognize weather type " + weather);
			}
			writer.println(this.toString() + ": got " + weather.toLowerCase() + "ified seriously");

			int[] deltas = weatherReflection.get(weather);
			this.coordinates = new Coordinates(
				coordinates.getLongitude() + deltas[0],
				coordinates.getLatitude() + deltas[1],
				coordinates.getHeight() + deltas[2]);
			if (coordinates.getHeight() <= 0) {
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
				writer.println(this.toString() + " is landing");
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

	@Override
	public void registerWriter(PrintStream writer) {
		this.writer = writer;
	}
}
