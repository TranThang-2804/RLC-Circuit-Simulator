package guiWindows;

import javax.swing.JFrame;

public class GuiFrame extends JFrame{
	
	public GuiFrame() {
		GuiPanel gamePanel = new GuiPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);			
		this.setResizable(true);
		this.setVisible(true);
		this.add(gamePanel);		//Add the panel that is implemented the Wheel 
		this.pack();				//This method is too make the size of frame fits to all of its components
		this.setFocusable(true);

	}
}