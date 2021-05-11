package Components.Source;

import java.awt.Image;

import javax.swing.ImageIcon;

import Components.RLCcomponents.Resistor;

public class DCsource extends Source{
	public DCsource(double spec, double frequency, String name) {
		super(spec, frequency, name);
	}
	
	
	@Override
	public Image getComponentImage(boolean connectType) {
		if(connectType==false)
			return new ImageIcon(Resistor.class.getResource("/imgs/parallel/AC_source.png")).getImage();
		else if(connectType == true)
			return new ImageIcon(Resistor.class.getResource("/imgs/series/source.png")).getImage();
		return null;
	}
}
