package fr.fourtytwo.avaj;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;

	Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private static long nextId() {
		return idCounter++;
	}
}

class Coordinates {
	private int longtitude;
	private int latitude;
	private int height;

	Coordinates(int longtitude, int latitude, int height) {
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongtitude() {
		return longtitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}
}
