package edu.ft.simulator.util;

import edu.ft.simulator.flyable.Flyable;
import edu.ft.simulator.flyable.Aircraft.*;

public final class AircraftFactory {
	private int	nextId = 0;
	private static AircraftFactory	instance;

	public static AircraftFactory getInstance()
	{
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		switch (p_type)
		{
			case "Baloon":
				return new Baloon(nextId++, p_name, p_coordinates);
			case "Helicopter":
				return new Helicopter(nextId++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(nextId++, p_name, p_coordinates);
			default:
				return null;
		}
	}
}
