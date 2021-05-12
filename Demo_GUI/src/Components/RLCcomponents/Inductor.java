package Components.RLCcomponents;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Inductor extends RLCcomponent{

	public Inductor(double spec, String name){
		super(spec, name);
	}

	@Override
	public Image getComponentImage(boolean connectType) {
		return new ImageIcon(Resistor.class.getResource("/imgs/series/inductor_Serie.png")).getImage();
	}

}
