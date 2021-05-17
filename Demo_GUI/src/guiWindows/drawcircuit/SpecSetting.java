package guiWindows.drawcircuit;

import java.awt.Image;

import javax.swing.ImageIcon;

import Components.RLCcomponents.Resistor;

public class SpecSetting {
	public static Image serieImage = new ImageIcon(Resistor.class.getResource("/imgs/registor.png")).getImage();
	public static double serieOGComponentWidth = serieImage.getWidth(null);
	public static double serieOGComponentHeight = serieImage.getHeight(null);
	public static double parallelOGComponentWidth = serieOGComponentHeight;
	public static double parallelOGComponentHeight = serieOGComponentWidth;
	public static double connectorwidth = 40; 
	
	
	
	// Can be change:
	public static double Width = 444;				//(can be change)	//The Panel width
	public static double Height = 241;				//(can be change)	//The Panel Height 
	

	public static double serieImageScale = 0.06;
	public static double serielowerYlocation = 200;
	public static double serieupperYlocation = 120;
	public static double serielabelX = 20;
	public static double serielabelY = 5;
	
	public static double parallelImageScale = 0.06;
	public static double parallelComponentDistance = 800;

	public static double parallelupperYlocation = 120;
	public static double parallellabelX = 30;
	public static double parallellabelY; 
	
	public static double sourcescale = 0.25;

	
	
	//Can't be change
	public static double parallelComponentWidth = parallelOGComponentWidth*parallelImageScale;
	public static double parallelComponentHeight = parallelOGComponentHeight*parallelImageScale;
	public static double parallelconnectorwidth = connectorwidth*parallelImageScale; 
	public static double parallelWidthBetweenCom = parallelComponentDistance*parallelImageScale;

	public static double serieComponentWidth = serieOGComponentWidth*serieImageScale;
	public static double serieComponentHeight = serieOGComponentHeight*serieImageScale;
	public static double serieconnectorwidth = connectorwidth*serieImageScale;
}
