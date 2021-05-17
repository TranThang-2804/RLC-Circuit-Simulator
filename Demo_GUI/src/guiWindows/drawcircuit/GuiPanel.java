package guiWindows.drawcircuit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import circuit.Circuit;

public class GuiPanel extends JPanel {
	Circuit circuit = new Circuit();
	public GuiPanel(Circuit circuit) {
		this.circuit = circuit;
	    setLayout(null);
	    setPreferredSize(new Dimension((int)SpecSetting.Width, (int)SpecSetting.Height));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setBackground(Color.red);
		circuit.DrawCircuit(g2D);
	}
}
