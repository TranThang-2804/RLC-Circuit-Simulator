package Components.source;

import java.awt.Image;

import javax.swing.ImageIcon;

import Components.RLCcomponents.Resistor;

public class DCsource extends Source{
	public DCsource(double spec, double frequency, String name) {
		super(spec, frequency, name);
	}
	
	@Override
	public Image getComponentImage() {
		return new ImageIcon(Resistor.class.getResource("/imgs/DCsource.png")).getImage();
	}
}
