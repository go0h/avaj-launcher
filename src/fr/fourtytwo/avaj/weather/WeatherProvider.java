
package fr.fourtytwo.avaj.weather;


public class WeatherProvider {

    private static final WeatherProvider weatherProvider = new WeatherProvider();
	private static final ArrayList<String> weather = new ArrayList<String>();

    private WeatherProvider { };
    
    public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        if (coordinates.getLongtitude() > 100) {
            return "RAIN";
        }
        return "SUNNY";
    }


}