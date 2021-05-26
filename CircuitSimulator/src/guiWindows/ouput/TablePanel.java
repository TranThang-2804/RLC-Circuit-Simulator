package guiWindows.ouput;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import backend.Calculate;
import circuit.Circuit;
import components.rlccomponents.RLCcomponent;
import guiWindows.drawcircuit.SpecSetting;

public class TablePanel extends JPanel{
	
	public TablePanel(Circuit circuit) {
		Object[] data = new Object[3];
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Color backgroundcolor = new Color(238, 238, 238);
		JLabel labelLeft[] = new JLabel[3];
		JLabel labelRight[] = new JLabel[3];
		final int tablePanelLocateX = 465;
		final int tablePanelLocateY = (int)SpecSetting.Height + 30;
		final int tablePanelWidth = (int)SpecSetting.Width - 2;
		final int tablePanelHeight = 208;
		final int tableLocateX = (int)((SpecSetting.Width - 2)/2-90*circuit.getComponents().size()/2);
		final int tableLocateY = 65;
		final int labelLeftLocateX = tableLocateX - 15;
		final int labelLocateY = tableLocateY + 17;
		final int labelLeftWidth = 10;
		final int labelRightWidth = 30;
		final int labelHeight = 20;
		new Calculate(circuit);
		
		for(RLCcomponent rlccomponent:circuit.getComponents()) {
			data[0] = rlccomponent.getU().toString();
			data[1] = rlccomponent.getI().toString();
			data[2] = rlccomponent.getR().toString();
			
			model.addColumn(rlccomponent.getName(), data);
		}
		
		
		setBounds(tablePanelLocateX, tablePanelLocateY, tablePanelWidth , tablePanelHeight);
		setLayout(null);
		setBorder(new LineBorder(Color.BLACK, 2, true));
		
		table.setModel(model);
		table.setBackground(backgroundcolor);
		table.setRowHeight(20);
		table.setFillsViewportHeight(false);
		table.setEnabled(false);

		final int tableWidth = 90 * circuit.getComponents().size();
		final int tableHeight = table.getRowHeight()*4+table.getRowMargin()*3;

		JScrollPane sp = new JScrollPane(table);
		sp.setViewportView(table);
		sp.setBounds(tableLocateX, tableLocateY, tableWidth, tableHeight);
		sp.setVisible(true);
		
		labelLeft[0] = new JLabel("U");
		labelLeft[1] = new JLabel("I");
		labelLeft[2] = new JLabel("Z");
		
		labelRight[0] = new JLabel("V");
		labelRight[1] = new JLabel("A");
		labelRight[2] = new JLabel("Ohm");
		
		for(int i = 0; i < 3; i ++) {
			labelLeft[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelRight[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			labelLeft[i].setBounds(labelLeftLocateX, labelLocateY + 20*i, labelLeftWidth, labelHeight);
			
			labelRight[i].setBounds(tableLocateX + tableWidth, labelLocateY +20*i, labelRightWidth, labelHeight);
			add(labelRight[i]);
			add(labelLeft[i]);
		}
		add(sp);
		setBackground(new Color(255, 250, 205));
		setVisible(true);
	}
}
