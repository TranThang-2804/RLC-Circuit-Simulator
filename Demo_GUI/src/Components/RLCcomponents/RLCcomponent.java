package Components.RLCcomponents;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import Components.Component;
import guiWindows.drawcircuit.SpecSetting;

public abstract class RLCcomponent extends Component {

	RLCcomponent(double spec, String name) {
		super(spec, name);
		// TODO Auto-generated constructor stub
	}
	
	public void drawComponent(Graphics2D g2D, double startX, boolean connectType) {
		if(connectType == false) {
			Image image = getComponentImage(connectType);
			AffineTransform at = AffineTransform.getTranslateInstance(startX+SpecSetting.parallelComponentWidth/2,
										SpecSetting.parallelupperYlocation);
			at.scale(SpecSetting.parallelImageScale, SpecSetting.parallelImageScale);
			at.rotate(Math.toRadians(90));
			g2D.drawImage(image, at, null);
		}
		else if(connectType == true){
			Image image = getComponentImage(connectType);
			AffineTransform at = AffineTransform.getTranslateInstance((double)startX, (double)SpecSetting.serieupperYlocation-SpecSetting.serieComponentHeight/2+SpecSetting.serieconnectorwidth/2);
			at.scale(SpecSetting.serieImageScale, SpecSetting.serieImageScale);
			g2D.drawImage(image, at, null);
			g2D.drawString(this.name, (int)startX+(int)SpecSetting.serieComponentWidth/2, (int)((double)SpecSetting.serieupperYlocation-SpecSetting.serieComponentHeight/2));
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            