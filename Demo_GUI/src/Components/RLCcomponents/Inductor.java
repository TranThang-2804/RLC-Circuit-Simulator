package Components.RLCcomponents;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Inductor extends RLCcomponent{

	public Inductor(double spec, String name){
		super(spec, name);
	}

	@Override
	public Image getComponentImage(boolean connectType) {
		if(connectType==false) 
			return new ImageIcon(Resistor.class.getResource("/imgs/parallel/inductor_Parallel.png")).getImage();
		else
			return new ImageIcon(Resistor.class.getResource("/imgs/series/inductor_Serie.png")).getImage();
	}

}
