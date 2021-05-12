package Components.RLCcomponents;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Capacitor extends RLCcomponent{
	
	public Capacitor(double spec, String name){
		super(spec, name);
	}

	@Override
	public Image getComponentImage() {
		return new ImageIcon(Capacitor.class.getResource("/imgs/capacitor.png")).getImage();
	}
}
