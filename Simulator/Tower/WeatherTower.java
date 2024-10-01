package Simulator.Tower;

import java.io.IOException;

import Simulator.Exception.UnhandledWeather;
import Simulator.util.Coordinates;
import Simulator.util.WeatherProvider;

public class WeatherTower extends Tower {
	public String	getWeather(Coordinates p_coordinates)
	{
		WeatherProvider provider = WeatherProvider.getInstance();
		return provider.getCurrentWeather(p_coordinates);
	}

	public void	changeWeather() throws UnhandledWeather, IOException
	{
		this.conditionChanged();
	}
}
