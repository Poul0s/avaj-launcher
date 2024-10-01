package Simulator.Exception;

public class UnimplementedMethod extends RuntimeException {
	public UnimplementedMethod(String method)
	{
		super("Unimplemented method '" + method + "'. This happen when a method should not be called.");
	}
}
