package Components;

import java.awt.Graphics2D;
import java.awt.Image;


public abstract class Component {
	protected double spec;
	protected String name;
	
	protected Component(double spec, String name){
		this.spec = spec;
		this.name = name;
	}
	
	public double getSpec() {
		return this.spec;
	}
	
	public abstract Image getComponentImage(boolean connectType);
	
	public abstract void drawComponent(Graphics2D g2D, double startX, boolean connectType);
}
