package Simulator.Flyable.Aircraft;

import java.io.IOException;

import Simulator.Exception.UnhandledWeather;
import Simulator.util.Coordinates;
import Simulator.util.OutfileWriter;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public String	getIdentification()
	{
		return "Baloon#" + this.name + "(" + this.id + ")";
	}

	public void	updateConditions() throws UnhandledWeather, IOException
	{
		String weather = weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates.add(new Coordinates(2, 0, 4));
				OutfileWriter.println(this.getIdentification() + " :  Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				this.coordinates.add(new Coordinates(0, 0, -5));
				OutfileWriter.println(this.getIdentification() + " : Damn you rain! You messed up my baloon.");
				break;
			case "FOG":
				this.coordinates.add(new Coordinates(0, 0, -3));
				OutfileWriter.println(this.getIdentification() + " : Fog."); // todo another
				break;
			case "SNOW":
				this.coordinates.add(new Coordinates(0, 0, -15));
				OutfileWriter.println(this.getIdentification() + " :  It's snowing. We're gonna crash.");
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
