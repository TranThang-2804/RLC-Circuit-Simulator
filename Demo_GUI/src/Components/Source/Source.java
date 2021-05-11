package Components.Source;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import Components.Component;
import guiWindows.drawcircuit.SpecSetting;

public abstract class Source extends Component{
	private double frequency;
	Source(double spec, double frequency, String name) {
		super(spec, name);
		this.frequency = frequency;
	}
	
	public void drawComponent(Graphics2D g2D, double startX, boolean connectType) {
		if(connectType == false) {
			double privatescale = 0.3;
			Image image =  getComponentImage(connectType);
			AffineTransform at = AffineTransform.getTranslateInstance(startX-image.getWidth(null)*privatescale*SpecSetting.parallelImageScale/2,
																		SpecSetting.parallelupperYlocation+SpecSetting.parallelComponentHeight/2-image.getHeight(null)*privatescale*SpecSetting.parallelImageScale/2);
			at.scale(SpecSetting.serieImageScale*privatescale, SpecSetting.serieImageScale*privatescale);
			g2D.drawImage(image, at, null);
			g2D.setColor(Color.black);
			g2D.fillRect((int)startX, 
						 (int)SpecSetting.parallelupperYlocation-SpecSetting.connectorwidth/2, 
						 (int)SpecSetting.connectorwidth, 
						 (int)(SpecSetting.parallelComponentHeight/2-image.getHeight(null)*privatescale*SpecSetting.parallelImageScale/2));
			g2D.fillRect((int)startX,
						 (int)(SpecSetting.parallelupperYlocation+SpecSetting.parallelComponentHeight/2+image.getHeight(null)*privatescale*SpecSetting.parallelImageScale/2),
						 (int)SpecSetting.connectorwidth, 
						 (int)(SpecSetting.parallelComponentHeight/2-image.getHeight(null)*privatescale*SpecSetting.parallelImageScale/2));
			g2D.fillRect((int)startX,
						 (int)SpecSetting.parallelupperYlocation-SpecSetting.connectorwidth/2, 
						 (int)(SpecSetting.Width-2*startX),
						 (int)SpecSetting.connectorwidth);
			g2D.fillRect((int)startX,
					 	 (int)(SpecSetting.parallelupperYlocation+SpecSetting.parallelComponentHeight-SpecSetting.connectorwidth/2), 
					 	 (int)(SpecSetting.Width-2*startX),
					 	 (int)SpecSetting.connectorwidth);
		}
		else if(connectType == true){
			double privatescale = 0.5;
			
			Image image =  getComponentImage(connectType);
			AffineTransform at = AffineTransform.getTranslateInstance(SpecSetting.Width/2-image.getWidth(null)*privatescale*SpecSetting.serieImageScale/2, 
																	  SpecSetting.serielowerYlocation-image.getHeight(null)*(double)SpecSetting.serieImageScale*privatescale/2);
			at.scale(SpecSetting.serieImageScale*privatescale, SpecSetting.serieImageScale*privatescale);
			
			g2D.drawImage(image, at, null);
			g2D.setColor(Color.black);
			g2D.fillRect((int)startX,
						 (int)(SpecSetting.serielowerYlocation-SpecSetting.connectorwidth/2), 
						 (int)(SpecSetting.Width/2-image.getWidth(null)*privatescale*SpecSetting.serieImageScale/2 - startX),  
						 SpecSetting.connectorwidth);
			g2D.fillRect((int)(SpecSetting.Width/2+image.getWidth(null)*privatescale*SpecSetting.serieImageScale/2), 
					 	 (int)(SpecSetting.serielowerYlocation), 
						 (int)(SpecSetting.Width/2-image.getWidth(null)*privatescale*SpecSetting.serieImageScale/2 - startX),  
						 SpecSetting.connectorwidth);
			g2D.fillRect((int)startX-SpecSetting.connectorwidth, 
						 (int)SpecSetting.serieupperYlocation, 
						 SpecSetting.connectorwidth, 
						 (int)(SpecSetting.serielowerYlocation+SpecSetting.connectorwidth/2-SpecSetting.serieupperYlocation));
			g2D.fillRect((int)(SpecSetting.Width/2+image.getWidth(null)*privatescale*SpecSetting.serieImageScale/2) + (int)(SpecSetting.Width/2-image.getWidth(null)*privatescale*SpecSetting.serieImageScale/2 - startX), 
					 	 (int)SpecSetting.serieupperYlocation, 
					 	 SpecSetting.connectorwidth, 
					 	 (int)(SpecSetting.serielowerYlocation+SpecSetting.connectorwidth/2-SpecSetting.serieupperYlocation));
		}
	}
}
