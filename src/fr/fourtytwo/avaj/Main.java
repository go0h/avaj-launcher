package fr.fourtytwo.avaj;

import java.io.*;
import java.util.ArrayList;
import fr.fourtytwo.avaj.aircraft.*;
import fr.fourtytwo.avaj.weather.*;

public class Main {
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Usage: java -jar avaj-launcher.jar scenarioFile");
			System.exit(0);
		}

		File file = new File(args[0]);
		BufferedReader reader = null;

		ArrayList<Flyable> flyables = new ArrayList<Flyable>();
		Integer cycles = 0;

		try {
			String line = null;
			int numLine = 0;

			reader = new BufferedReader(new FileReader(file));
			if ((line = reader.readLine()) != null) {
				cycles = Utils.parseInt(line, "numOfCycles");
				++numLine;
			}

			while ((line = reader.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;
				String[] params = line.split("\\s+", 5);
				if (params.length != 5) {
					System.out.println(
						"Wrong input format at line " + numLine + "\n" +
						"Need: AircraftType Name Longitude Latitude Height\n" +
						"Got: " + line
					);
					System.exit(1);
				}
				flyables.add(AircraftFactory.newAircraft(params[0], params[1], params[2], params[3], params[4]));
				++numLine;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}

		WeatherTower tower = new WeatherTower();
		for (Flyable flyable: flyables) {
			flyable.registerTower(tower);
		}

		tower.simulateWeatherChanges(cycles);
	}
}
