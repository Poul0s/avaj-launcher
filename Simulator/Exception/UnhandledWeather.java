package Simulator.Exception;

public class UnhandledWeather extends Exception
{
	public UnhandledWeather(String weather)
	{
		super("Unhandled weather `" + weather + "'.");
	}
}
