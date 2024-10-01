package Simulator.Flyable.Aircraft;

import java.io.IOException;

import Simulator.Exception.UnhandledWeather;
import Simulator.util.Coordinates;
import Simulator.util.OutfileWriter;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	public String	getIdentification()
	{
		return "JetPlane#" + this.name + "(" + this.id + ")";
	}

	public void	updateConditions() throws UnhandledWeather, IOException
	{
		String weather = weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates.add(new Coordinates(0, 10, 2));
				OutfileWriter.println(this.getIdentification() + " : sun."); // todo another
				break;
			case "RAIN":
				this.coordinates.add(new Coordinates(0, 5, 0));
				OutfileWriter.println(this.getIdentification() + " : It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				this.coordinates.add(new Coordinates(0, 1, 0));
				OutfileWriter.println(this.getIdentification() + " : fog."); // todo another
				break;
			case "SNOW":
				this.coordinates.add(new Coordinates(0, 0, -7)); 
				OutfileWriter.println(this.getIdentification() + " : OMG! Winter is coming!");
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
