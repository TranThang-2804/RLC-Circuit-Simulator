package components.rlccomponents;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import backend.Calculate;
import backend.CalculateInterface;
import circuit.Circuit;
import complex.Complex;

public class Resistor extends RLCcomponent implements CalculateInterface{
	public Resistor(double spec, String name){
		super(spec, name);
	}
	@Override
	public void calculateRcomponent(Circuit circuit) {
		Complex com;
		if (circuit.getSourceType()) {
			// ACsource
				com = new Complex(this.getSpec(),0.0);
				this.setR(com);
		}
		else {
			// DCsource
				com = new Complex(this.getSpec(),0.0);
				this.setR(com);
		}
	}
	@Override
	public void calculateIcomponent(Circuit circuit) {
		Complex com,Req =circuit.calculateReq();
			if (circuit.getConnectType()) {
				//true serial
				com = new Complex(circuit.getSource().getSpec(),0.0).divides(Req); 
				this.setI(com);
			}
			else {
				//false parallel
					com = new Complex(circuit.getSource().getSpec(),0.0).divides(this.getR()); 
					this.setI(com);
						
			}
	}


	@Override
	public Image getComponentImage() {
		return new ImageIcon(Resistor.class.getResource("/imgs/registor.png")).getImage();
	}
}
