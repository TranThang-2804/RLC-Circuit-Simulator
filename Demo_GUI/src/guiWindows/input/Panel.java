package guiWindows.input;

import javax.swing.*;

import Circuit.Circuit;
import Components.RLCcomponents.Capacitor;
import Components.RLCcomponents.Inductor;
import Components.RLCcomponents.RLCcomponent;
import Components.RLCcomponents.Resistor;
import Components.Source.ACsource;
import Components.Source.DCsource;
import guiWindows.drawcircuit.GuiFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel{
	private JTextField[] tfield;
	private JComboBox cbOfSource;
	private JLabel lbVoltage;
	private JTextField tfVoltage;
	private JLabel lbFrequency;
	private JTextField tfFrequency;
    private int count = 1;
    private int constantHeightSaveBtn = 120;
    private int constantHeightSaveLabel = 103;
    private int constantHeightBtn = constantHeightSaveBtn;
    private int constantHeightLabel = constantHeightSaveLabel;
    private int btn = 112;
    private JButton btnR;
    private JButton btnL;
    private JButton btnC;
    private JButton btnSubmit;
    private int space = 45;
    private ArrayList<RLCcomponent> components;
	private Circuit circuit;
	private boolean choseSource = false;
	private int AC = 0;
	private int DC = 0;

	public Panel(boolean connectType) {
		tfield = new JTextField[5];
		components = new ArrayList<RLCcomponent>();

		JLabel lbSource = new JLabel("SOURCE");
		lbSource.setForeground(Color.RED);
		lbSource.setBounds(168, 6, 50, 26);
		add(lbSource);
		cbOfSource = new JComboBox();
		cbOfSource.setModel(new DefaultComboBoxModel(new String[]{"AC", "DC"}));
		cbOfSource.setBounds(230, 7, 70, 27);
		add(cbOfSource);
		cbOfSource.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbOfSource.getSelectedItem().equals("AC")){
					if(choseSource){
						remove(lbVoltage);
						remove(tfVoltage);
					}
					if(AC == 0){
						lbVoltage  = new JLabel("Voltage");
						lbVoltage.setHorizontalAlignment(SwingConstants.LEFT);
						lbVoltage.setBounds(124, 22, 100, 16);
						add(lbVoltage);
						tfVoltage = new JTextField();
						tfVoltage.setBounds(124, 37, 200, 26);;
						add(tfVoltage);
						lbFrequency  = new JLabel("Frequency");
						lbFrequency.setHorizontalAlignment(SwingConstants.LEFT);
						lbFrequency.setBounds(124, 63, 100, 16);
						add(lbFrequency);
						tfFrequency = new JTextField();
						tfFrequency.setBounds(124, 78, 200, 26);;
						add(tfFrequency);
						choseSource = true;
						AC = 1;
						DC = 0;
						repaint();
					}
				}else{
					if(choseSource){
						remove(lbVoltage);
						remove(tfVoltage);
						remove(lbFrequency);
						remove(tfFrequency);
					}
					if(DC == 0){
						lbVoltage  = new JLabel("Voltage");
						lbVoltage.setHorizontalAlignment(SwingConstants.LEFT);
						lbVoltage.setBounds(124, 42, 100, 16);
						add(lbVoltage);
						tfVoltage = new JTextField();
						tfVoltage.setBounds(124, 57, 200, 26);;
						add(tfVoltage);
						choseSource = true;
						DC = 1;
						AC = 0;
						repaint();
					}
				}
			}
		});

		btnR = new JButton("Add Resistor");
	    btnR.setBounds(17, btn, 117, 29);
		add(btnR);
		btnR.addActionListener(new BtnAddListener());

		btnC = new JButton("Add Capacitor");
		btnC.setBounds(166, btn, 117, 29);
		add(btnC);
		btnC.addActionListener(new BtnAddListener());
		
		btnL = new JButton("Add Inductor");
		btnL.setBounds(315, btn, 117, 29);
		add(btnL);
		btnL.addActionListener(new BtnAddListener());
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(151, 433, 147, 41);
		btnSubmit.setForeground(Color.BLUE);
		add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				circuit = new Circuit();
				circuit.setConnectType(connectType);
				int check = 0;
				for(int i = 0; i < components.size(); i++){
					if(tfield[i].getText().equals("")){
						JOptionPane.showMessageDialog(null, "Value of component number " + (i+1) + "can not be null. Please add a value.");
						break;
					}
					else{
						components.get(i).setSpec(Double.parseDouble(tfield[i].getText()));
						circuit.addComponent(components.get(i));
						check++;
					}
				}
				String sourceType = (String) cbOfSource.getSelectedItem();
				if(sourceType.equals("AC")){
					circuit.addSource(new ACsource(Double.parseDouble(tfVoltage.getText()), Double.parseDouble(tfFrequency.getText()), sourceType));
				}
				else {
					circuit.addSource(new DCsource(Double.parseDouble(tfVoltage.getText()),Double.MAX_VALUE, sourceType));
				}
				if(check == components.size()){
					new GuiFrame(circuit);
				}
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
					Resistor.setBounds(124, constantHeightLabel, 22, 16);
					add(Resistor);
					constantHeightLabel+=space;
					components.add(new Resistor(0, "R" + count));

				}
				else if(evt.getActionCommand().equals("Add Capacitor")) {
					JLabel Resistor = new JLabel("C" + count);
					Resistor.setHorizontalAlignment(SwingConstants.LEFT);
					Resistor.setBounds(124, constantHeightLabel, 22, 16);
					add(Resistor);
					constantHeightLabel+=space;
					components.add(new Capacitor(0, "C" + count));
				}
				else if(evt.getActionCommand().equals("Add Inductor")) {
					JLabel Resistor = new JLabel("L" + count);
					Resistor.setHorizontalAlignment(SwingConstants.LEFT);
					Resistor.setBounds(124, constantHeightLabel, 22, 16);
					add(Resistor);
					constantHeightLabel+=space;
					components.add(new Inductor(0, "L" + count));
				}
				tfield[count-1] = new JTextField();
                tfield[count-1].setBounds(124, constantHeightBtn, 200, 26);
				tfield[count-1].setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                constantHeightBtn+=space;
                add(tfield[count-1]);
                btn += space;
                btnR.setBounds(17, btn, 117, 29);
        		add(btnR);
        		btnC.setBounds(166, btn, 117, 29);
        		add(btnC);
        		btnL.setBounds(315, btn, 117, 29);
        		add(btnL);
        		revalidate();
                repaint();
                count++;
			}
		} 
	}

}
