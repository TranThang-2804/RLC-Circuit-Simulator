package guiWindows;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Components.RLCcomponents.RLCcomponent;

public class GuiFrame extends JFrame{
	
	public GuiFrame(ArrayList<RLCcomponent> components, JTextField[] tfield) {
		GuiPanel gamePanel = new GuiPanel(components,tfield);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);			
		this.setResizable(true);
		this.setVisible(true);
		this.add(gamePanel);		//Add the panel that is implemented the Wheel 
		this.pack();				//This method is too make the size of frame fits to all of its components
		this.setFocusable(true);

	}
}