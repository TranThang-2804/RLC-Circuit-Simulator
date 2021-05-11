package Components.Source;

import java.awt.Image;

import javax.swing.ImageIcon;

import Components.RLCcomponents.Resistor;

public class ACsource extends Source{
	public ACsource(double spec, double frequency, String name) {
		super(spec, frequency, name);
	}
	
	@Override
	public Image getComponentImage(boolean connectType) {
			return new ImageIcon(Resistor.class.getResource("/imgs/series/source.png")).getImage();
	}
}
