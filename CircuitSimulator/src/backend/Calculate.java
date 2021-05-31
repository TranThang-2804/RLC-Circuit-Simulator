package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import circuit.Circuit;
import complex.Complex;
import components.rlccomponents.*;
import components.source.Source;

public class Calculate {
	private Circuit circuit = new Circuit();
	
	public Calculate(Circuit circuit) {
		this.circuit = circuit;
		if (circuit.getConnectType()) {
			//true serial
		this.CalculateR();
		this.CalculateReq();
		this.CalculateI();
		this.CalculateU();
		}
		else {
			// false parallel
			this.CalculateR();
			this.CalculateReq();
			this.CalculateU();
			this.CalculateI();
			
		}
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
					com = new Complex(0.0,-1/(2*Math.PI*((Source) circuit.getSource()).getFrequency()*temp.getSpec()));
					temp.setR(com);

				}
				else if (temp instanceof Inductor) {
					com = new Complex(0.0,2*Math.PI*((Source) circuit.getSource()).getFrequency()*temp.getSpec());
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
		
		if (circuit.getConnectType()) {
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
		
		
		if (circuit.getConnectType()) {
			this.CalculateI();
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
	
		if (circuit.getConnectType()) {
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
					if (circuit.getSourceType())
					{	//AC
						com = new Complex(circuit.getSource().getSpec(),0.0).divides(temp.getR()); 
						temp.setI(com);	
					}	
						else
						{//DC
						temp.setI(new Complex(Double.POSITIVE_INFINITY,0));
						JOptionPane.showMessageDialog(null,"Short circuit! (Inductor "+temp.getName() +" in parallel circuit)\n Please enter another non-negative value for this Inductor!"); // TO-DO deal with GUI
						}
					
				}
				else if (temp instanceof Capacitor) {
					if (circuit.getSourceType())
					{		//AC
						com = new Complex(circuit.getSource().getSpec(),0.0).divides(temp.getR()); 
						temp.setI(com);
					}
					else
						//DC
						temp.setI(new Complex(0.0,0.0));
				}
			}
		}
		
	}
}
