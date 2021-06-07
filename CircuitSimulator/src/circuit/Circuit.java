package circuit;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import backend.CalculateException;
import complex.Complex;
import components.Component;
import components.rlccomponents.RLCcomponent;
import components.source.ACsource;
import components.source.Source;
import guiWindows.drawcircuit.SpecSetting;

public class Circuit {
	private boolean connectType = true;												//false: parallel, true: in line		
	private ArrayList<RLCcomponent> components = new ArrayList<>();

	private Source source;
	
	public Circuit(boolean connectType,Source source) {
		this.connectType = connectType;
		this.source = source;
	}
	public Circuit() {
		super();
	}
	
	public void addComponent(RLCcomponent rlccomponent) {
		if(rlccomponent != null){
			this.components.add(rlccomponent);
		}
	}
	
	public void addSource(Source source) {
		this.source = source;
	}
	// true mean AC
	public boolean getSourceType() {
		if(this.source instanceof ACsource)
			return true;															//false: DC, true: AC		
		else
			return false;
	}
	
	public boolean getConnectType() {
		return connectType;
	}

	public ArrayList<RLCcomponent> getComponents() {
		return components;
	}

	public Source getSource() {
		return source;
	}
	public void setConnectType(boolean connectType){
		this.connectType = connectType;
	}
	
	public Complex calculateReq() {
		Complex com = new Complex(0.0,0.0),Req = new Complex(0.0,0.0);
		ArrayList<RLCcomponent> components = this.getComponents();
		
		if (this.getConnectType()) {
			for (RLCcomponent temp: components) {		
				Req = Req.plus(temp.getR());

			}
			return Req;
		}
		else {
			for (RLCcomponent temp: components) {
				com.plus(new Complex(1,0.0).divides(temp.getR()));
			}
			Req = new Complex(1,0.0).divides(com);
			return Req;
		}
	}
	
	public void calculate(){
		
		try {
			for (RLCcomponent temp: components) {
					temp.calculateRcomponent(this);
				}
				if (connectType)
					for (RLCcomponent temp: components) {
						temp.calculateIcomponent(this);
						temp.calculateUcomponent(this);
					}
				else
					for (RLCcomponent temp: components) {
						temp.calculateUcomponent(this);
						temp.calculateIcomponent(this);
					}
		}
		catch (CalculateException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage()); 
		}	
	}

	public void DrawCircuit(Graphics2D g2D) {
		if(this.components.size()!=0) {
			if(this.connectType == false) {
				double startX = (SpecSetting.Width - SpecSetting.parallelWidthBetweenCom*(double)this.components.size())/2;
				this.source.drawComponent(g2D, startX, this.connectType);
				startX += (SpecSetting.parallelWidthBetweenCom);
				for(Component component:components) {
					component.drawComponent(g2D, startX, this.connectType);
					startX += (SpecSetting.parallelWidthBetweenCom);
				}
			}
		
			else if(this.connectType == true) {
				double startX = (SpecSetting.Width - SpecSetting.serieComponentWidth*(double)this.components.size())/2;
				this.source.drawComponent(g2D, startX, this.connectType);
				for(Component component:components) {
					component.drawComponent(g2D, startX, this.connectType);
					startX+= SpecSetting.serieComponentWidth;
				}
			}
		}
	}
}
