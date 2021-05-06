package guiWindows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Circuit.Circuit;
import Components.RLCcomponents.Capacitor;
import Components.RLCcomponents.Inductor;
import Components.RLCcomponents.Resistor;
import Components.Source.ACsource;

public class GuiPanel extends JPanel {
	Circuit circuit = new Circuit();
	Resistor registor1 = new Resistor(20, "R1");
	Capacitor compacitor1 = new Capacitor(20, "C1");
	Inductor inductor1 = new Inductor(30, "L1");
	ACsource acsource = new ACsource(20, "AC");
	
	public GuiPanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension((int)SpecSetting.Width, (int)SpecSetting.Height));
		this.setBackground(Color.black);
		this.setFocusable(true);	
		this.circuit.addComponent(registor1);
		this.circuit.addSource(acsource);

	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.red);;
		circuit.DrawCircuit(g2D);
	}
}
