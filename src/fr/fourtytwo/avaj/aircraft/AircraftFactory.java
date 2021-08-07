
package fr.fourtytwo.avaj.aircraft;

import fr.fourtytwo.avaj.Utils;

public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		Flyable flyable;
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.toLowerCase().equals("helicopter")) {
			flyable = new Helicopter(name, coordinates);
		}
		else if (type.toLowerCase().equals("jetplane")) {
			flyable = new JetPlane(name, coordinates);
		}
		else if (type.toLowerCase().equals("baloon")) {
			flyable = new Baloon(name, coordinates);
		}
		else {
			throw new IllegalArgumentException("Can't create " + type + " flyable");
		}
		return flyable;
	}

	public static Flyable newAircraft(String type, String name, String longitude, String latitude, String height) {
		return newAircraft(type, name,
			Utils.parseInt(longitude, "longitude"),
			Utils.parseInt(latitude, "latitude"),
			Utils.parseInt(height, "height"));
	}
}
