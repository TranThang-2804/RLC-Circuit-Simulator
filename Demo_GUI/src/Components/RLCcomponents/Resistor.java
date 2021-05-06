package Components.RLCcomponents;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Resistor extends RLCcomponent{
	private static int id = 1;
	public Resistor(double spec, String name){
		super(spec, "R"+Resistor.id);
		Resistor.id++;
	}

	@Override
	public Image getComponentImage(boolean connectType) {
		if(connectType == false)
			return new ImageIcon(Resistor.class.getResource("/imgs/parallel/registor_Parallel.png")).getImage();
		else
			return new ImageIcon(Resistor.class.getResource("/imgs/series/Registor_Serie.png")).getImage();
	}
}
