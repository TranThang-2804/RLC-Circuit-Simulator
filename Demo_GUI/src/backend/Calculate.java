package backend;

import java.util.ArrayList;

import Circuit.Circuit;
import Complex.Complex;
import Components.RLCcomponents.*;
import Components.Source.ACsource;
import Components.Source.Source;

public class Calculate {
	private Circuit circuit = new Circuit();
	
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
					com = new Complex(0.0,-2*Math.PI*((Source) circuit.getSource()).getFrequency()*temp.getSpec());
					temp.setR(com);
				}
				else if (temp instanceof Inductor) {
					com = new Complex(0.0,1/(2*Math.PI*((Source) circuit.getSource()).getFrequency()*temp.getSpec()));
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
	
	public Complex CalculateReq() {
		Complex com = new Complex(0.0,0.0),Req = new Complex(0.0,0.0);
		this.CalculateR();
		ArrayList<RLCcomponent> components = this.circuit.getComponents();
		
		if (circuit.isConnectType()) {
			for (RLCcomponent temp: components) {		
				Req = Req.plus(temp.getR());

			}
			return Req;
		}
		else {
			for (RLCcomponent temp: components) {
				com.plus(new Complex(1,0.0).divides(temp.getR()));
			}
			Req = new Complex(1,0.0).divides(com);
			return Req;
		}
	}
	
	public void CalculateU() {
		Complex com;
		ArrayList<RLCcomponent> components = new ArrayList<RLCcomponent>();
		components = circuit.getComponents();
		
		this.CalculateI();
		
		if (circuit.isConnectType()) {
			//true serial
			for (RLCcomponent temp: components) {
				com = temp.getI().times(temp.getR());
				temp.setU(com);
			}
			
		}
		else {
			//false parallel
			for (RLCcomponent temp: components) {
				com = new Complex(circuit.getSource().getSpec(),0.0);
				temp.setU(com);
			}
			
		}
		
	}
	
	public void CalculateI() {
		Complex com,Req = this.CalculateReq();
		ArrayList<RLCcomponent> components = new ArrayList<RLCcomponent>();
		components = circuit.getComponents();	
	
		if (circuit.isConnectType()) {
			//true serial
			for (RLCcomponent temp: components) {
				com = new Complex(circuit.getSource().getSpec(),0.0).divides(Req); 
				temp.setI(com);
			}
		}
		else {
			//false parallel
			for (RLCcomponent temp: components) {
				if (temp instanceof Resistor) {
					com = new Complex(circuit.getSource().getSpec(),0.0).divides(temp.getR()); 
					temp.setI(com);
				}
				else if (temp instanceof Inductor) {
					System.out.println("Short circuit! (Inductor in parallel circuit) "); // TO-DO deal with GUI
				}
				else if (temp instanceof Capacitor) {
					temp.setI(new Complex(0.0,0.0));
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Source s = new ACsource(10,5,"source1");
		Circuit c = new Circuit(true,s);
		RLCcomponent ca = new Capacitor(1,"c1");
		RLCcomponent r = new Resistor(10,"r1");
		RLCcomponent l = new Inductor(1,"l1");
		c.addComponent(ca);
		c.addComponent(r);
		c.addComponent(l);
		
		Calculate cal = new Calculate(c);
		
		cal.CalculateR();
		cal.CalculateReq();
		cal.CalculateI();
		cal.CalculateU();
		Complex com;
		
		
		ArrayList<RLCcomponent> components = new ArrayList<RLCcomponent>();
		components = c.getComponents();	
		for (RLCcomponent temp: components) {
			com = temp.getU();
			System.out.println(com.toString());
			com = temp.getI();
			System.out.println(com.toString());

			com = temp.getR();
			System.out.println(com.toString());
			System.out.println();


		}

	}
}
