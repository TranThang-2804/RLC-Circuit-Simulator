package backend;

import circuit.Circuit;

public interface CalculateInterface {
	public void calculateRcomponent(Circuit c);
	public void calculateIcomponent(Circuit c) throws CalculateException;
	public void calculateUcomponent(Circuit c);
}	

