package edu.ft.simulator.exception;

public class BadInput extends Exception {
	public BadInput(String line, String error)
	{
		super("Bad input for line `" + line + "' (" + error + ")");
	}
}
