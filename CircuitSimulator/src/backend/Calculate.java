package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import circuit.Circuit;
import complex.Complex;
import components.rlccomponents.*;
import components.source.ACsource;
import components.source.DCsource;
import components.source.Source;

public class Calculate {
	private static Circuit circuit = new Circuit();

	public Calculate(Circuit cir) {
		circuit = cir;
		this.CalculateR();
		
		if (circuit.getConnectType()) {
			//true serial
			this.CalculateI();
			this.CalculateU();
		}
		else {
			// false parallel
			this.CalculateU();
			this.CalculateI();
			
		}
		
	}
	
	public static Complex CalculateReq() {
		Complex com = new Complex(0.0,0.0),Req = new Complex(0.0,0.0);
		ArrayList<RLCcomponent> components = circuit.getComponents();
		
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
	
	public void CalculateR() {
		ArrayList<RLCcomponent> components = new ArrayList<RLCcomponent>();
		components = circuit.getComponents();

		for (RLCcomponent temp: components) {
				temp.calculateRcomponent(circuit);
		}	
	}
	
	public void CalculateI() {
		ArrayList<RLCcomponent> components = new ArrayList<RLCcomponent>();
		components = circuit.getComponents();

		for (RLCcomponent temp: components) {
			try {
				temp.calculateIcomponent(circuit);}
			catch (CalculateException e) {
				JOptionPane.showMessageDialog(null,"Short circuit! (Inductor" +temp.getName()+" in parallel circuit)\n Please remove this Inductor!");
			}
		}
	}
	
	public void CalculateU() {
		ArrayList<RLCcomponent> components = new ArrayList<RLCcomponent>();
		components = circuit.getComponents();

		for (RLCcomponent temp: components) {
				temp.calculateUcomponent(circuit);
		}
	}
/******************************************************************************************************
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
//*******************************************************************************************
*/

	public static void main(String[] args) {
		Source s = new ACsource(220,100,"source1");
	Circuit c = new Circuit(true,s);
	RLCcomponent ca = new Capacitor(1.6/(10*10*10*10*10),"c1");
	RLCcomponent r = new Resistor(100,"r1");
	RLCcomponent l = new Inductor(0.16,"l1");
		c.addComponent(ca);
		c.addComponent(r);
		c.addComponent(l);
		
		c.calculate();

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