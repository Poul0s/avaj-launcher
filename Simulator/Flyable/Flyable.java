package Simulator.Flyable;

import java.io.IOException;

import Simulator.Exception.UnhandledWeather;
import Simulator.Tower.WeatherTower;

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