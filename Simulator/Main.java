package Simulator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Simulator.Exception.UnhandledWeather;
import Simulator.Exception.BadInput;
import Simulator.Flyable.Flyable;
import Simulator.Tower.WeatherTower;
import Simulator.util.AircraftFactory;
import Simulator.util.Coordinates;
import Simulator.util.OutfileWriter;

public class Main {

	private static Flyable	parseFlyable(String line, AircraftFactory factory) throws BadInput
	{
		String[]	params = line.split("( |\t)+");
		Coordinates	coordinates;
		
		if (params.length != 5)
			throw new BadInput(line, "wrong parameter number");
		try {
			int longitude = Integer.parseInt(params[2]);
			int latitude = Integer.parseInt(params[3]);
			int height = Integer.parseInt(params[4]);
			coordinates = new Coordinates(longitude, latitude, height);
		} catch (NumberFormatException exception) {
			throw new BadInput(line, exception.getMessage());
		}

		if (coordinates.getLongitude() < 0 || coordinates.getLatitude() < 0 || coordinates.getHeight() < 0)
			throw new BadInput(line, "Coordinate cannot be negative");
		if (coordinates.getHeight() > 100)
			throw new BadInput(line, "Height cannot be superior than 100");
		
		Flyable flyable = factory.newAircraft(params[0], params[1], coordinates);
		if (flyable == null)
			throw new BadInput(line, "Flyable type not found");
		return flyable;
	}

	private static Integer	parseSimulationNumber(String line) throws BadInput
	{
		Integer res;
		try {
			res = Integer.valueOf(line);
		} catch(NumberFormatException exception) {
			throw new BadInput(line, exception.getMessage());
		}
		if (res <= 0)
			throw new BadInput(line, "Number of simulation must be a positive number");
		return res;
	}

	public static void main(String[] argv)
	{
		if (argv.length != 1)
		{
			System.err.printf("Wrong number of arguments. Expected 1 got %d.\n", argv.length);
			System.exit(1);
		}

		Integer			numberSimulation = null;
		WeatherTower	tower = new WeatherTower();
		AircraftFactory	factory = AircraftFactory.getInstance();
		
		try {
			File file = new File(argv[0]);
			Scanner scanner = new Scanner(file);
			OutfileWriter.open("simulation.txt");
			
			while (scanner.hasNextLine())
			{
				String	line = scanner.nextLine();
				if (numberSimulation == null)
					numberSimulation = parseSimulationNumber(line);
				else
				{
					Flyable flyable = parseFlyable(line, factory);
					flyable.registerTower(tower);
				}
			}
			for (int i = 0; i < numberSimulation; i++)
			{
				tower.changeWeather();
			}
			scanner.close();
			OutfileWriter.close();
		} catch (BadInput | UnhandledWeather | IOException exception) {
			if (exception instanceof FileNotFoundException)
				System.err.println("Error: Cannot open file " + exception.getMessage());
			else if (exception instanceof IOException)
				System.err.println("Erroro: Cannot write/read from file " + exception.getMessage());
			else
				System.err.println(exception.getMessage());
			System.exit(1);
		}
	}
}
