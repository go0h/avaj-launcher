
package fr.fourtytwo.avaj.aircraft;


public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longtitude, int latitude, int height) {

		Flyable flyable;
		Coordinates coordinates = new Coordinates(longtitude, latitude, height);

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
}
