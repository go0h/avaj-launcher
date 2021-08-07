
package fr.fourtytwo.avaj.weather;

import fr.fourtytwo.avaj.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() { };

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        if (coordinates.getLongtitude() > 100) {
            return "RAIN";
        }
        return "SUNNY";
    }

}
