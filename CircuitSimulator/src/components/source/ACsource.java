package components.source;

import java.awt.Image;

import javax.swing.ImageIcon;

import components.rlccomponents.Resistor;

public class ACsource extends Source{
	public ACsource(double spec, double frequency, String name) {
		super(spec, frequency, name);
	}
	
	@Override
	public Image getComponentImage() {
		return new ImageIcon(Resistor.class.getResource("/imgs/ACsource.png")).getImage();
	}
}
