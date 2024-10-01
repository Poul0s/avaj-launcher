package Simulator.util;

public final class WeatherProvider {
	private String[]				weather;
	private static WeatherProvider	instance;

	private WeatherProvider()
	{
		weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
	}

	public static WeatherProvider	getInstance()
	{
		if (instance == null)
			instance = new WeatherProvider();
		return	instance;
	}

	public String getCurrentWeather(Coordinates p_coordinates)
	{
		int weatherIdx = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4;
		return weather[weatherIdx];
	}
}
