package Components.Source;

import java.awt.Image;

import javax.swing.ImageIcon;

import Components.RLCcomponents.Resistor;

public class ACsource extends Source{
	public ACsource(double spec, String name) {
		super(spec, name);
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
