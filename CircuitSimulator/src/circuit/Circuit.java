package circuit;

import java.awt.Graphics2D;
import java.util.ArrayList;

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
