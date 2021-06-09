package backend;

import circuit.Circuit;

public interface CalculateInterface {
	public void calculateRcomponent(Circuit c) ; // rieng tung cai
	public void calculateIcomponent(Circuit c) throws CalculateException; // rieng tung cai
	public void calculateUcomponent(Circuit c) ; // chung
}	

