package backend;

import java.util.ArrayList;

import Circuit.Circuit;
import Complex.Complex;
import Components.RLCcomponents.*;

public class Calculate {
	private Circuit circuit;
	
	public Calculate(Circuit circuit) {
		this.circuit = circuit;
	}
	
	public void CalculateR() {
		Complex com;
		ArrayList<RLCcomponent> components = new ArrayList<RLCcomponent>();
		components = circuit.getComponents();
		
		if (circuit.getSourceType()) {
			// ACsource
			for (RLCcomponent temp: components) {
				if (temp instanceof Resistor) {
					com = new Complex(temp.getSpec(),0.0);
					temp.setR(com);
				}
				else if (temp instanceof Capacitor) {
					com = new Complex(0.0,-2*Math.PI*circuit.getSource().getF()*temp.getSpec());
					temp.setR(com);
				}
				else if (temp instanceof Inductor) {
					com = new Complex(0.0,1/(2*Math.PI*circuit.getSource().getF()*temp.getSpec()));
					temp.setR(com);
				}
			}
			
		}
		else {
			// DCsource
			
			for (RLCcomponent temp: components) {
				if (temp instanceof Resistor) {
					com = new Complex(temp.getSpec(),0.0);
					temp.setR(com);
				}
				else if (temp instanceof Inductor) {
					com = new Complex(0.0,0.0);
					temp.setR(com);
				}
				else if (temp instanceof Capacitor) {
					com = new Complex(Double.POSITIVE_INFINITY,0.0);
					temp.setR(com);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
