package fr.fourtytwo.avaj.aircraft;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private static long nextId() {
		return ++idCounter;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
	}

}
