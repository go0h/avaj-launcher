package fr.fourtytwo.avaj.aircraft;

import java.io.PrintStream;
import fr.fourtytwo.avaj.weather.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);

	public void registerWriter(PrintStream writer);
}
