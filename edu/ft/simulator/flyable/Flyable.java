package edu.ft.simulator.flyable;

import java.io.IOException;

import edu.ft.simulator.exception.UnhandledWeather;
import edu.ft.simulator.tower.WeatherTower;

public abstract class Flyable {
	protected WeatherTower weatherTower;

	public abstract void	updateConditions() throws UnhandledWeather, IOException;
	public abstract String	getIdentification();
	public abstract boolean	isFlying();


	public void registerTower(WeatherTower p_tower) throws IOException
	{
		weatherTower = p_tower;
		weatherTower.register(this);
	}
}