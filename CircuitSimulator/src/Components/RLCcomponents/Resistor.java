package Components.RLCcomponents;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Resistor extends RLCcomponent{
	public Resistor(double spec, String name){
		super(spec, name);
	}

	@Override
	public Image getComponentImage() {
		return new ImageIcon(Resistor.class.getResource("/imgs/registor.png")).getImage();
	}
}
