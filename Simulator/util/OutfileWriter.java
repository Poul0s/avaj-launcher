package Simulator.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class OutfileWriter {
	private static File			file;
	private static FileWriter	writer;

	public static void	open(String path) throws IOException
	{
		if (file != null)
			OutfileWriter.close();
		file = new File(path);
		writer = new FileWriter(file);
	}

	public static void	close() throws IOException
	{
		writer.close();
	}

	public static void	println(String line) throws IOException
	{
		writer.write(line + "\n");
	}
}
