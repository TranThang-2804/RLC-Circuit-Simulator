package components.rlccomponents;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.geom.AffineTransform;

import complex.Complex;
import components.Component;
import guiWindows.drawcircuit.SpecSetting;


public abstract class RLCcomponent extends Component {
	private Complex R;
	private Complex U;
	private Complex I;
	
	RLCcomponent(double spec, String name) {
		super(spec, name);
		// TODO Auto-generated constructor stub
	}

	
	public Complex getR() {
		return R;
	}



	public void setR(Complex r) {
		R = r;
	}



	public Complex getU() {
		return U;
	}



	public void setU(Complex u) {
		U = u;
	}



	public Complex getI() {
		return I;
	}



	public void setI(Complex i) {
		I = i;
	}



	public void drawComponent(Graphics2D g2D, double startX, boolean connectType) {
		if(connectType == false) {
			Image image = getComponentImage();
			AffineTransform at = AffineTransform.getTranslateInstance(startX+SpecSetting.parallelComponentWidth/2,
										SpecSetting.parallelupperYlocation);
			at.scale(SpecSetting.parallelImageScale, SpecSetting.parallelImageScale);
			at.rotate(Math.toRadians(90));
			g2D.drawString(this.name+' '+this.spec, 0, 0);
			g2D.drawImage(image, at, null);
			g2D.drawString(this.name+' '+this.spec, (int)(startX+SpecSetting.serieComponentWidth/2-SpecSetting.parallellabelX), (int)(SpecSetting.serieupperYlocation + SpecSetting.parallelComponentHeight/2 - SpecSetting.parallellabelY));
		}
		else if(connectType == true){
			Image image = getComponentImage();
			AffineTransform at = AffineTransform.getTranslateInstance((double)startX, (double)SpecSetting.serieupperYlocation-SpecSetting.serieComponentHeight/2+SpecSetting.serieconnectorwidth/2);
			at.scale(SpecSetting.serieImageScale, SpecSetting.serieImageScale);
			g2D.drawImage(image, at, null);
			g2D.drawString(this.name+' '+this.spec, (int)(startX+SpecSetting.serieComponentWidth/2-SpecSetting.serielabelX), (int)(SpecSetting.serieupperYlocation-SpecSetting.serielabelY));
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            