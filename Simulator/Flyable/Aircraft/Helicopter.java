package Simulator.Flyable.Aircraft;

import java.io.IOException;

import Simulator.Exception.UnhandledWeather;
import Simulator.util.Coordinates;
import Simulator.util.OutfileWriter;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public String	getIdentification()
	{
		return "Helicopter#" + this.name + "(" + this.id + ")";
	}

	public void	updateConditions() throws UnhandledWeather, IOException
	{
		String weather = weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates.add(new Coordinates(10, 0, 2));
				OutfileWriter.println(this.getIdentification() + " : This is hot.");
				break;
			case "RAIN":
				this.coordinates.add(new Coordinates(5, 0, 0));
				OutfileWriter.println(this.getIdentification() + " : rain."); // todo another
				break;
			case "FOG":
				this.coordinates.add(new Coordinates(1, 0, 0));
				OutfileWriter.println(this.getIdentification() + " : fog."); // todo another
				break;
			case "SNOW":
				this.coordinates.add(new Coordinates(0, 0, -12));
				OutfileWriter.println(this.getIdentification() + " : My rotor is going to freeze!");
				break;
		
			default:
				throw new UnhandledWeather(weather);
		}
		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);
		else if (this.coordinates.getHeight() <= 0)
		{
			OutfileWriter.println(getIdentification() + " landing.");
		}
	}
}
