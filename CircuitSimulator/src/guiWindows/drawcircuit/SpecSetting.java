package guiWindows.drawcircuit;

import java.awt.Image;

import javax.swing.ImageIcon;

import components.rlccomponents.Resistor;

public class SpecSetting {
	public static Image serieImage = new ImageIcon(Resistor.class.getResource("/imgs/registor.png")).getImage();
	public static double serieOGComponentWidth = serieImage.getWidth(null);
	public static double serieOGComponentHeight = serieImage.getHeight(null);
	public static double parallelOGComponentWidth = serieOGComponentHeight;
	public static double parallelOGComponentHeight = serieOGComponentWidth;
	public static double connectorwidth = 40; 
	
	
	
	// Can be change:
	public static double Width = 540;				//(can be change)	//The Panel width
	public static double Height = 241;				//(can be change)	//The Panel Height 
	

	public static double serieImageScale = 0.09;
	public static double serielowerYlocation = 190;
	public static double serieupperYlocation = 70;
	public static double serielabelX = 20;
	public static double serielabelY = 15;
	
	public static double parallelImageScale = 0.09;
	public static double parallelComponentDistance = 900;

	public static double parallelupperYlocation = 70;
	public static double parallellabelX = 35;
	public static double parallellabelY = - 5; 
	
	public static double sourcescale = 0.3;

	
	
	//Can't be change
	public static double parallelComponentWidth = parallelOGComponentWidth*parallelImageScale;
	public static double parallelComponentHeight = parallelOGComponentHeight*parallelImageScale;
	public static double parallelconnectorwidth = connectorwidth*parallelImageScale; 
	public static double parallelWidthBetweenCom = parallelComponentDistance*parallelImageScale;

	public static double serieComponentWidth = serieOGComponentWidth*serieImageScale;
	public static double serieComponentHeight = serieOGComponentHeight*serieImageScale;
	public static double serieconnectorwidth = connectorwidth*serieImageScale;
}
