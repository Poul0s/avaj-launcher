package Simulator.Tower;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;

import Simulator.Exception.UnhandledWeather;
import Simulator.Flyable.Flyable;
import Simulator.util.OutfileWriter;

public class Tower {
	private List<Flyable>	observers = new LinkedList<>();

	public void	register(Flyable p_flyable) throws IOException
	{
		observers.add(p_flyable);
		OutfileWriter.println("Tower says: " + p_flyable.getIdentification() + " registered to weather tower.");
	}

	public void	unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
	}

	protected void	conditionChanged() throws UnhandledWeather, IOException
	{
		Iterator<Flyable> it = observers.iterator();

		while (it.hasNext())
		{
			Flyable current = it.next();
			current.updateConditions();
			if (!current.isFlying())
			{
				it.remove();
				OutfileWriter.println("Tower says: " + current.getIdentification() + " unregistered from weather tower.");
			}
		}
	}
}