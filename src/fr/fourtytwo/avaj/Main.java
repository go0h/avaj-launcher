package fr.fourtytwo.avaj;

public class Main {
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Usage: java -jar avaj-launcher.jar scenarioFile");
			System.exit(0);
		}

		Simulator simulator = new Simulator(args[0], "simulation.txt");
		simulator.run();
	}
}
