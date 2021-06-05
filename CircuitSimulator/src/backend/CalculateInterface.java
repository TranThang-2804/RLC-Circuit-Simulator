package backend;

import circuit.Circuit;

public interface CalculateInterface {
	public void calculateRcomponent(Circuit c);
	public void calculateIcomponent(Circuit c);
	public void calculateUcomponent(Circuit c);
}
