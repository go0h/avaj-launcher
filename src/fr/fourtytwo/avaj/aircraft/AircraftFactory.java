
package fr.fourtytwo.avaj.aircraft;


class AircraftFactory {

	public Flyable newAircraft(String type, String name, int longtitude, int latitude, int height) {

		Flyable flyable;
		Coordinates coordinates = new Coordinates(longtitude, latitude, height);

		if (type.equals("Helicopter")) {
			flyable = new Helicopter(name, coordinates);
		}
		else if (type.equals("JetPlane")) {
			flyable = new JetPlane(name, coordinates);
		}
		else if (type.equals("Baloon")) {
			flyable = new JetPlane(name, coordinates);
		}
		else {
			throw new IllegalArgumentException("Can't create " + type + " flyable");
		}
		return flyable;
	}
}
