package guiWindows.ouput;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Components.RLCcomponents.RLCcomponent;
import backend.Calculate;
import circuit.Circuit;
import guiWindows.drawcircuit.SpecSetting;

public class TablePanel extends JPanel{
	
	public TablePanel(Circuit circuit) {
		Object[] data = new Object[3];
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Color backgroundcolor = new Color(238, 238, 238);
		JLabel labelLeft[] = new JLabel[3];
		JLabel labelRight[] = new JLabel[3];
		
		new Calculate(circuit);
		
		for(RLCcomponent rlccomponent:circuit.getComponents()) {
			data[0] = rlccomponent.getU().toString();
			data[1] = rlccomponent.getI().toString();
			data[2] = rlccomponent.getR().toString();
			
			model.addColumn(rlccomponent.getName(), data);
		}
		
		
		setBounds(465, (int)SpecSetting.Height, (int)SpecSetting.Width - 2, 234);
		setLayout(null);
		setBorder(new LineBorder(Color.BLACK, 2, true));
		
		table.setModel(model);
		table.setBackground(backgroundcolor);
		table.setRowHeight(20);
		table.setFillsViewportHeight(false);
		table.setEnabled(false);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setViewportView(table);
		sp.setBounds((int)((SpecSetting.Width - 2)/2-90*circuit.getComponents().size()/2), 
							95, 
							90*circuit.getComponents().size(), 
							table.getRowHeight()*4+table.getRowMargin()*3);
		sp.setVisible(true);
		
		labelLeft[0] = new JLabel("U");
		labelLeft[1] = new JLabel("I");
		labelLeft[2] = new JLabel("Z");
		
		labelRight[0] = new JLabel("V");
		labelRight[1] = new JLabel("A");
		labelRight[2] = new JLabel("Ohm");
	
		
		labelLeft[0].setBounds(sp.getX()- 15, sp.getY() + 20, 10, 20);
		labelLeft[1].setBounds(sp.getX()- 15, sp.getY() + 40, 10, 20);
		labelLeft[2].setBounds(sp.getX()- 15, sp.getY() + 60, 10, 20);
		
		for(int i = 0; i<3; i++) {
			labelLeft[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelRight[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			labelLeft[i].setBounds(sp.getX()- 15, 
								   sp.getY() + 20*(i+1), 
								   10, 
								   20);
			
			labelRight[i].setBounds(sp.getX()+sp.getWidth(),
									sp.getY()+20*(i+1),
									30,
									20);
			add(labelRight[i]);
			add(labelLeft[i]);
		}
		add(sp);
		setVisible(true);
	}
}
