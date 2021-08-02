package fr.fourtytwo.avaj;

import fr.fourtytwo.avaj.aircraft.*;

public class Main {
    public static void main(String[] args) {

        Flyable flyable = AircraftFactory.newAircraft("Helicopter", "alligator", 3, 2, 3);

        System.out.println(flyable);
    }
}