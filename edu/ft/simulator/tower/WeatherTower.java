package edu.ft.simulator.tower;

import java.io.IOException;

import edu.ft.simulator.Coordinates;
import edu.ft.simulator.exception.UnhandledWeather;
import edu.ft.simulator.util.WeatherProvider;

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
