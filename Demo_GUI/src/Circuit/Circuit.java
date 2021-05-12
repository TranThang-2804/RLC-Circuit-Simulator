package Circuit;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Components.Component;
import Components.RLCcomponents.RLCcomponent;
import Components.Source.ACsource;
import Components.Source.Source;
import guiWindows.drawcircuit.SpecSetting;

public class Circuit {
	private boolean connectType = true;												//false: parallel, true: in line		
	private ArrayList<RLCcomponent> components = new ArrayList<>();
	private Source source;
	
	public void addComponent(RLCcomponent rlccomponent) {
		if(rlccomponent != null){
			this.components.add(rlccomponent);
		}
	}
	
	public void addSource(Source source) {
		this.source = source;
	}
	
	public boolean getSourceType() {
		if(this.source instanceof ACsource)
			return true;															//false: DC, true: AC		
		else
			return false;
	}
	public void setConnectType(boolean connectType){
		this.connectType = connectType;
	}

	public void DrawCircuit(Graphics2D g2D) {
		if(this.connectType == false) {
			double startX = SpecSetting.Width/2 - (((double)this.components.size()*(SpecSetting.parallelComponentWidth - SpecSetting.parallelComponentOffSetWithScale)-SpecSetting.parallelComponentOffSetWithScale)/2)+SpecSetting.parallelComponentOffSetWithScale/2;
			this.source.drawComponent(g2D, startX, this.connectType);
			for(Component component:components) {
				component.drawComponent(g2D, startX, this.connectType);
				startX += (SpecSetting.parallelComponentWidth - SpecSetting.parallelComponentOffSetWithScale);
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
