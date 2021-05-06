package guiWindows;

import java.awt.Image;

import javax.swing.ImageIcon;

import Components.RLCcomponents.Resistor;

public class SpecSetting {
	// Can be change:
	public static double Width = 1000;				//(can be change)	//The Panel width
	public static double Height = 700;				//(can be change)	//The Panel Height 
	
	public static Image image = new ImageIcon(Resistor.class.getResource("/imgs/parallel/resistor_Parallel.png")).getImage();
	public static double parallelOGComponentWidth = image.getWidth(null);
	public static double parallelOGComponentHeight = image.getHeight(null);
	public static double parallelImageScale = 0.2;
	public static double parallelOffSet = 230;
	
	
	public static Image serieImage = new ImageIcon(Resistor.class.getResource("/imgs/series/inductor_Serie.png")).getImage();
	public static double serieOGComponentWidth = serieImage.getWidth(null);
	public static double serieOGComponentHeight = serieImage.getHeight(null);
	public static double serieImageScale = 0.15;
	public static double serieOffSet = 75;
	public static double serielowerYlocation = 450;
	public static double serieupperYlocation = 150;
	public static int connectorwidth = 4; 
	
	
	//Can't be change
	public static double parallelComponentWidth = parallelOGComponentWidth*parallelImageScale;
	public static double parallelComponentHeight = parallelOGComponentHeight*parallelImageScale;
	public static double parallelComponentOffSetWithScale = parallelOffSet * parallelImageScale;
	
	public static double serieComponentWidth = serieOGComponentWidth*serieImageScale;
	public static double serieComponentHeight = serieOGComponentHeight*serieImageScale;
	public static double serieComponentOffSetWithScale = serieOffSet*serieImageScale;
}
