package edu.ft.simulator.flyable.Aircraft;

import java.io.IOException;

import edu.ft.simulator.Coordinates;
import edu.ft.simulator.exception.UnhandledWeather;
import edu.ft.simulator.exception.UnimplementedMethod;
import edu.ft.simulator.flyable.Flyable;

public class Aircraft extends Flyable {

	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;

	public void updateConditions() throws UnhandledWeather, IOException {
		throw new UnimplementedMethod("updateConditions");
	}

	public String getIdentification() {
		throw new UnimplementedMethod("getIdentification");
	}

	public boolean	isFlying()
	{
		return this.coordinates.getHeight() > 0;
	}


	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
	{
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	}
}
