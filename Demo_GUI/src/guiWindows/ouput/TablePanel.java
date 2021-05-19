package guiWindows.ouput;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Components.RLCcomponents.RLCcomponent;
import backend.Calculate;
import circuit.Circuit;
import guiWindows.drawcircuit.GuiPanel;
import guiWindows.drawcircuit.SpecSetting;

public class TablePanel extends JPanel{
	
	public TablePanel(Circuit circuit) {
		Object[] data = new Object[4];
		JTable table = new JTable();
		JPanel tablecontainer = new JPanel();
		DefaultTableModel model = new DefaultTableModel();
		Color backgroundcolor = new Color(238, 238, 238);
		JPanel panelverticle = new JPanel();
		
		new Calculate(circuit);
		
		panelverticle.setPreferredSize(new Dimension(100,45));
		panelverticle.setBackground(backgroundcolor);
		panelverticle.setVisible(true);
		
		for(RLCcomponent rlccomponent:circuit.getComponents()) {
			data[0] = rlccomponent.getName();
			data[1] = rlccomponent.getU().toString();
			data[2] = rlccomponent.getI().toString();
			data[3] = rlccomponent.getR().toString();
			
			model.addColumn(rlccomponent.getName(), data);
		}
		
		
		setBounds(465, (int)SpecSetting.Height, (int)SpecSetting.Width - 2, 234);
		//setLayout(new BorderLayout());
		//setBorder(new LineBorder(Color.BLACK, 2, true));
		
		table.setModel(model);
		table.setBackground(backgroundcolor);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setShowGrid(true);
		table.setRowHeight(30);
		table.setGridColor(Color.black); 
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(450,63));
		
		table.setEnabled(false);
		
		table.setVisible(true);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setVisible(true);
		
		tablecontainer.add(table);
		tablecontainer.setVisible(true);
		
		//tablecontainer.setBorder(new LineBorder(Color.BLACK, 2, false));
		
		
		//add(panelverticle, BorderLayout.NORTH);
		//add(panelverticle, BorderLayout.SOUTH);
		add(sp);
		
	
		setVisible(true);
	}
}
