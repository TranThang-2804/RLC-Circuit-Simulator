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
			Image image =  getComponentImage(connectType);
			AffineTransform at = AffineTransform.getTranslateInstance(startX-image.getWidth(null)*SpecSetting.sourcescale*SpecSetting.parallelImageScale/2,
																		SpecSetting.parallelupperYlocation+SpecSetting.parallelComponentHeight/2-image.getHeight(null)*SpecSetting.sourcescale*SpecSetting.parallelImageScale/2);
			at.scale(SpecSetting.parallelImageScale*SpecSetting.sourcescale, SpecSetting.parallelImageScale*SpecSetting.sourcescale);
			g2D.drawImage(image, at, null);
			g2D.setColor(Color.black);
			g2D.fillRect((int)startX, 
						 (int)(SpecSetting.parallelupperYlocation-SpecSetting.parallelconnectorwidth/2), 
						 (int)SpecSetting.parallelconnectorwidth, 
						 (int)(SpecSetting.parallelComponentHeight/2-image.getHeight(null)*SpecSetting.sourcescale*SpecSetting.parallelImageScale/2+SpecSetting.parallelconnectorwidth));
			g2D.fillRect((int)startX,
						 (int)(SpecSetting.parallelupperYlocation+SpecSetting.parallelComponentHeight/2+image.getHeight(null)*SpecSetting.sourcescale*SpecSetting.parallelImageScale/2),
						 (int)SpecSetting.parallelconnectorwidth, 
						 (int)(SpecSetting.parallelComponentHeight/2-image.getHeight(null)*SpecSetting.sourcescale*SpecSetting.parallelImageScale/2));
			g2D.fillRect((int)startX,
						 (int)(SpecSetting.parallelupperYlocation-SpecSetting.parallelconnectorwidth/2), 
						 (int)(SpecSetting.Width-2*startX+SpecSetting.parallelconnectorwidth/2),
						 (int)SpecSetting.parallelconnectorwidth);
			g2D.fillRect((int)startX,
					 	 (int)(SpecSetting.parallelupperYlocation+SpecSetting.parallelComponentHeight-SpecSetting.parallelconnectorwidth/2), 
					 	 (int)(SpecSetting.Width-2*startX+SpecSetting.parallelconnectorwidth/2),
					 	 (int)SpecSetting.parallelconnectorwidth);
		}
		else if(connectType == true){
			Image image =  getComponentImage(connectType);
			AffineTransform at = AffineTransform.getTranslateInstance(SpecSetting.Width/2-image.getWidth(null)*SpecSetting.sourcescale*SpecSetting.serieImageScale/2, 
																	  SpecSetting.serielowerYlocation-image.getHeight(null)*(double)SpecSetting.serieImageScale*SpecSetting.sourcescale/2);
			at.scale(SpecSetting.serieImageScale*SpecSetting.sourcescale, SpecSetting.serieImageScale*SpecSetting.sourcescale);
			
			g2D.drawImage(image, at, null);
			g2D.setColor(Color.black);
			g2D.fillRect((int)(startX-SpecSetting.serieconnectorwidth/2),
						 (int)(SpecSetting.serielowerYlocation), 
						 (int)(SpecSetting.Width/2-image.getWidth(null)*SpecSetting.sourcescale*SpecSetting.serieImageScale/2 + SpecSetting.serieconnectorwidth - startX),  
						 (int)(SpecSetting.serieconnectorwidth));
			g2D.fillRect((int)(SpecSetting.Width/2+image.getWidth(null)*SpecSetting.sourcescale*SpecSetting.serieImageScale/2), 
					 	 (int)(SpecSetting.serielowerYlocation), 
						 (int)(SpecSetting.Width/2-image.getWidth(null)*SpecSetting.sourcescale*SpecSetting.serieImageScale/2 + SpecSetting.serieconnectorwidth - startX),  
						 (int)(SpecSetting.serieconnectorwidth));
			g2D.fillRect((int)(startX-SpecSetting.serieconnectorwidth/2), 
						 (int)(SpecSetting.serieupperYlocation), 
						 (int)(SpecSetting.serieconnectorwidth), 
						 (int)(SpecSetting.serielowerYlocation+SpecSetting.serieconnectorwidth/2-SpecSetting.serieupperYlocation));
			g2D.fillRect((int)(SpecSetting.Width/2+image.getWidth(null)*SpecSetting.sourcescale*SpecSetting.serieImageScale/2) + (int)(SpecSetting.Width/2-image.getWidth(null)*SpecSetting.sourcescale*SpecSetting.serieImageScale/2 - startX), 
					 	 (int)(SpecSetting.serieupperYlocation), 
					 	 (int)(SpecSetting.serieconnectorwidth), 
					 	 (int)(SpecSetting.serielowerYlocation+SpecSetting.serieconnectorwidth/2-SpecSetting.serieupperYlocation));
		}
	}
}
