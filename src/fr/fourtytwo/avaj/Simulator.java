package fr.fourtytwo.avaj;

import java.io.*;
import java.util.ArrayList;
import fr.fourtytwo.avaj.aircraft.*;
import fr.fourtytwo.avaj.weather.*;

public class Simulator {

	private int numOfCycles = 0;
	private String scenarioFile = null;
	private String outFile = null;
	private PrintStream writer = System.out;

	public Simulator(String scenarioFile, String out) {
		this.scenarioFile = scenarioFile;
		this.outFile = out;
	}

	public void run() {

		try {
			this.writer = new PrintStream(outFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		ArrayList<Flyable> flyables = readScenario(this.scenarioFile);
		WeatherTower tower = new WeatherTower();
		tower.registerWriter(writer);

		for (Flyable flyable: flyables) {
			flyable.registerTower(tower);
			flyable.registerWriter(writer);
		}

		tower.simulateWeatherChanges(numOfCycles);
	}

	ArrayList<Flyable> readScenario(String filename) {

		ArrayList<Flyable> flyables = new ArrayList<Flyable>();
		File file = new File(filename);
		BufferedReader reader = null;

		try {
			String line = null;
			int numLine = 0;

			reader = new BufferedReader(new FileReader(file));
			if ((line = reader.readLine()) != null) {
				numOfCycles = Utils.parseInt(line, "numOfCycles");
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
			System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
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
		return flyables;
	}
}
