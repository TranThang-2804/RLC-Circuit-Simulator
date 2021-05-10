package guiWindows.input;

import javax.swing.*;

import Circuit.Circuit;
import Components.RLCcomponents.Capacitor;
import Components.RLCcomponents.Inductor;
import Components.RLCcomponents.RLCcomponent;
import Components.RLCcomponents.Resistor;
import Components.Source.ACsource;
import guiWindows.drawcircuit.GuiFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel extends JPanel{
	private JTextField[] tfield;
    private int count = 1;
    private int constantHeightSaveBtn = 36;
    private int constantHeightSaveLabel = 19;
    private int constantHeightBtn = constantHeightSaveBtn;
    private int constantHeightLabel = constantHeightSaveLabel;
    private int btn = 41;
    private JButton btnR;
    private JButton btnL;
    private JButton btnC;
    private JButton btnSubmit;
    private int space = 45;
    private ArrayList<RLCcomponent> components;
	private Circuit circuit;

	public Panel() {
		tfield = new JTextField[5];
		components = new ArrayList<RLCcomponent>();
		circuit = new Circuit();
		btnR = new JButton("Add Resistor");
	    btnR.setBounds(62, btn, 117, 29);
		add(btnR);
		btnR.addActionListener(new BtnAddListener());
		
		btnC = new JButton("Add Capacitor");
		btnC.setBounds(211, btn, 117, 29);
		add(btnC);
		btnC.addActionListener(new BtnAddListener());
		
		btnL = new JButton("Add Inductor");
		btnL.setBounds(359, btn, 117, 29);
		add(btnL);
		btnL.addActionListener(new BtnAddListener());
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(195, 305, 147, 41);
		btnSubmit.setForeground(Color.BLUE);
		add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < components.size(); i++){
					components.get(i).setSpec(Double.parseDouble(tfield[i].getText()));
					circuit.addComponent(components.get(i));
				}
				circuit.addSource(new ACsource(20, "AC"));
				new GuiFrame(circuit);
			}
		});
	}
	
	private class BtnAddListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent evt) { 
			if(constantHeightBtn < (constantHeightSaveBtn + space * 5)) {
				if(evt.getActionCommand().equals("Add Resistor")) {
					JLabel Resistor = new JLabel("R" + count);
					Resistor.setHorizontalAlignment(SwingConstants.LEFT);
					Resistor.setBounds(38, constantHeightLabel, 22, 16);
					add(Resistor);
					constantHeightLabel+=space;
					components.add(new Resistor(0, "R" + count));

				}
				else if(evt.getActionCommand().equals("Add Capacitor")) {
					JLabel Resistor = new JLabel("C" + count);
					Resistor.setHorizontalAlignment(SwingConstants.LEFT);
					Resistor.setBounds(38, constantHeightLabel, 22, 16);
					add(Resistor);
					constantHeightLabel+=space;
					components.add(new Capacitor(0, "C" + count));
				}
				else if(evt.getActionCommand().equals("Add Inductor")) {
					JLabel Resistor = new JLabel("L" + count);
					Resistor.setHorizontalAlignment(SwingConstants.LEFT);
					Resistor.setBounds(38, constantHeightLabel, 22, 16);
					add(Resistor);
					constantHeightLabel+=space;
					components.add(new Inductor(0, "L" + count));
				}
				tfield[count-1] = new JTextField();
                tfield[count-1].setBounds(38, constantHeightBtn, 200, 26);
                constantHeightBtn+=space;
                add(tfield[count-1]);
                btn += space;
                btnR.setBounds(62, btn, 117, 29);
        		add(btnR);
        		btnC.setBounds(211, btn, 117, 29);
        		add(btnC);
        		btnL.setBounds(359, btn, 117, 29);
        		add(btnL);
        		revalidate();
                repaint();
                count++;
			}
		} 
	}

}
