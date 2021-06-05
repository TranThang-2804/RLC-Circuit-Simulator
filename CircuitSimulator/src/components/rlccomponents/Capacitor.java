package components.rlccomponents;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import backend.Calculate;
import backend.CalculateInterface;
import circuit.Circuit;
import complex.Complex;
import components.source.Source;

public class Capacitor extends RLCcomponent implements CalculateInterface{
	
	public Capacitor(double spec, String name){
		super(spec, name);
	}
	
	@Override
	public void calculateRcomponent(Circuit circuit) {
		// TO-DO handle exception
		Complex com;		
		if (circuit.getSourceType()) {
			// ACsource
				com = new Complex(0.0,-1/(2*Math.PI*((Source) circuit.getSource()).getFrequency()*this.getSpec()));
				this.setR(com);
		}
		else {
			// DCsource
				com = new Complex(Double.POSITIVE_INFINITY,0.0);
				this.setR(com);
		}
	}
	@Override
	public void calculateIcomponent(Circuit circuit) {
		Complex com,Req = circuit.calculateReq();	
	
		if (circuit.getConnectType()) {
			//true serial
				com = new Complex(circuit.getSource().getSpec(),0.0).divides(Req); 
				this.setI(com);
		}
		else {
			//false parallel
			if (circuit.getSourceType()){		
				//AC
					com = new Complex(circuit.getSource().getSpec(),0.0).divides(this.getR()); 
					this.setI(com);
				}
			else {
				//DC
					this.setI(new Complex(0.0,0.0));
				}
			
		
		}	
	}


	@Override
	public Image getComponentImage() {
		return new ImageIcon(Capacitor.class.getResource("/imgs/capacitor.png")).getImage();
	}
}
