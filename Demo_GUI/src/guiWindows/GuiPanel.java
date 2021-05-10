package guiWindows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Circuit.Circuit;
import Components.RLCcomponents.RLCcomponent;
import Components.Source.ACsource;

public class GuiPanel extends JPanel {
	Circuit circuit = new Circuit();
	public GuiPanel(ArrayList<RLCcomponent> components, JTextField[] tfield) {
		for(int i = 0; i < components.size(); i++){
			components.get(i).setSpec(Double.parseDouble(tfield[i].getText()));
			circuit.addComponent(components.get(i));
		}
		circuit.addSource(new ACsource(20, "AC"));
	    setLayout(null);
	    setPreferredSize(new Dimension((int)SpecSetting.Width, (int)SpecSetting.Height));
	    setBackground(Color.black);
		setFocusable(true);	
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.red);;
		circuit.DrawCircuit(g2D);
	}
}
