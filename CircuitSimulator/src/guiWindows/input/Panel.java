package guiWindows.input;

import javax.swing.*;

import circuit.Circuit;
import components.rlccomponents.Capacitor;
import components.rlccomponents.Inductor;
import components.rlccomponents.RLCcomponent;
import components.rlccomponents.Resistor;
import components.source.ACsource;
import components.source.DCsource;
import guiWindows.drawcircuit.CircuitPanel;
import guiWindows.drawcircuit.SpecSetting;
import guiWindows.ouput.TablePanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel extends JPanel{
	private JTextField[] tfield;
	private JLabel[] label;
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
	private JButton btnRemovePrevious;
	private JButton btnRemoveAll;
    private int space = 45;
    private ArrayList<RLCcomponent> components;
	private Circuit circuit;
	private boolean choseSource = false;
	private boolean connectType;
	private int AC = 0;
	private int DC = 0;
	CircuitPanel panelToDraw;
	TablePanel tablePanel;
	public Panel(boolean connectType) {
		this.connectType = connectType;
		tfield = new JTextField[5];
		components = new ArrayList<RLCcomponent>();
		label = new JLabel[5];

		JLabel lbSource = new JLabel("SOURCE");
		lbSource.setForeground(Color.RED);
		lbSource.setBounds(168, 6, 60, 26);
		add(lbSource);
		cbOfSource = new JComboBox();
		cbOfSource.setModel(new DefaultComboBoxModel(new String[]{"AC", "DC"}));
		cbOfSource.setBounds(230, 7, 70, 27);
		add(cbOfSource);
		cbOfSource.addActionListener(new BtnPreSubmitListener());
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
						tfVoltage.setBounds(124, 37, 200, 26);
						tfVoltage.setText("0");
						add(tfVoltage);
						lbFrequency  = new JLabel("Frequency");
						lbFrequency.setHorizontalAlignment(SwingConstants.LEFT);
						lbFrequency.setBounds(124, 63, 100, 16);
						add(lbFrequency);
						tfFrequency = new JTextField();
						tfFrequency.setBounds(124, 78, 200, 26);;
						tfFrequency.setText("0");
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
						if(lbFrequency != null){
							remove(lbFrequency);
							remove(tfFrequency);
						}
					}
					if(DC == 0){
						lbVoltage  = new JLabel("Voltage");
						lbVoltage.setHorizontalAlignment(SwingConstants.LEFT);
						lbVoltage.setBounds(124, 42, 100, 16);
						add(lbVoltage);
						tfVoltage = new JTextField();
						tfVoltage.setBounds(124, 57, 200, 26);
						tfVoltage.setText("0");
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
		btnR.addActionListener(new BtnPreSubmitListener());
		btnR.addActionListener(new BtnAddListener());

		btnC = new JButton("Add Capacitor");
		btnC.setBounds(166, btn, 117, 29);
		add(btnC);
		btnC.addActionListener(new BtnPreSubmitListener());
		btnC.addActionListener(new BtnAddListener());
		
		btnL = new JButton("Add Inductor");
		btnL.setBounds(315, btn, 117, 29);
		add(btnL);
		btnL.addActionListener(new BtnPreSubmitListener());
		btnL.addActionListener(new BtnAddListener());

		btnRemovePrevious = new JButton("Remove Last Component");
		btnRemovePrevious.setBounds(17, 380, 201, 35);
		btnRemovePrevious.setForeground(Color.RED);
		add(btnRemovePrevious);
		btnRemovePrevious.addActionListener(new BtnPreSubmitListener());
		btnRemovePrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count >= 2){
					count--;
					components.remove(components.size()-1);
					remove(label[count-1]);
					constantHeightLabel-=space;
					constantHeightBtn-=space;
                	remove(tfield[count-1]);
             	  	btn -= space;
              	 	btnR.setBounds(17, btn, 117, 29);
        			add(btnR);
        			btnC.setBounds(166, btn, 117, 29);
        			add(btnC);
        			btnL.setBounds(315, btn, 117, 29);
        			add(btnL);
        			revalidate();
             	   	repaint();
				}
			}
		});

		btnRemoveAll = new JButton("Remove All Components");
		btnRemoveAll.setBounds(230, 380, 201, 35);
		btnRemoveAll.setForeground(Color.RED);
		add(btnRemoveAll);
		btnRemoveAll.addActionListener(new BtnPreSubmitListener());
		btnRemoveAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count >= 2){
					while(count != 1){
						count--;
						components.remove(components.size()-1);
						remove(label[count-1]);
						constantHeightLabel-=space;
						constantHeightBtn-=space;
                		remove(tfield[count-1]);
             	  		btn -= space;
					}
					btnR.setBounds(17, btn, 117, 29);
        			add(btnR);
        			btnC.setBounds(166, btn, 117, 29);
        			add(btnC);
        			btnL.setBounds(315, btn, 117, 29);
        			add(btnL);
        			revalidate();
             	   	repaint();
				}
			}
		});
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(151, 433, 147, 41);
		btnSubmit.setForeground(Color.BLUE);
		add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				for(int i = 0; i < circuit.getComponents().size(); i++) {
					if(Double.parseDouble(tfield[i].getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Value of component number " + (i+1) + " can not be negative. Please change to another value.");
					}
					circuit.getComponents().get(i).setSpec(Double.parseDouble(tfield[i].getText()));
				}
				if(Double.parseDouble(tfVoltage.getText()) < 0) {
					JOptionPane.showMessageDialog(null, "Value of voltage can not be negative. Please change to another value.");
				}
				circuit.getSource().setSpec(Double.parseDouble(tfVoltage.getText()));
				if(circuit.getSourceType()){
					if(Double.parseDouble(tfFrequency.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Value of frequency can not be negative. Please change to another value.");	
					}
					circuit.getSource().setFrequency(Double.parseDouble(tfFrequency.getText()));
				}
				} catch (Exception evt){
					JOptionPane.showMessageDialog(null, evt.getMessage());
				} 
				if(tablePanel != null){
						remove(tablePanel);
					}
					tablePanel = new TablePanel(circuit);
					add(tablePanel);
					revalidate();
					repaint();
					tablePanel.revalidate();
					tablePanel.repaint();
			}
		});
	}
	
	private class BtnAddListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent evt) { 
			if(constantHeightBtn < (constantHeightSaveBtn + space * 5)) {
				if(evt.getActionCommand().equals("Add Resistor")) {
					label[count-1] = new JLabel("R" + count);
					label[count-1].setHorizontalAlignment(SwingConstants.LEFT);
					label[count-1].setBounds(124, constantHeightLabel, 22, 16);
					add(label[count-1]);
					constantHeightLabel+=space;
					components.add(new Resistor(0, "R" + count));

				}
				else if(evt.getActionCommand().equals("Add Capacitor")) {
					label[count-1] = new JLabel("C" + count);
					label[count-1].setHorizontalAlignment(SwingConstants.LEFT);
					label[count-1].setBounds(124, constantHeightLabel, 22, 16);
					add(label[count-1]);
					constantHeightLabel+=space;
					components.add(new Capacitor(0, "C" + count));
				}
				else if(evt.getActionCommand().equals("Add Inductor")) {
					label[count-1] = new JLabel("L" + count);
					label[count-1].setHorizontalAlignment(SwingConstants.LEFT);
					label[count-1].setBounds(124, constantHeightLabel, 22, 16);
					add(label[count-1]);
					constantHeightLabel+=space;
					components.add(new Inductor(0, "L" + count));
				}
				tfield[count-1] = new JTextField();
                tfield[count-1].setBounds(124, constantHeightBtn, 200, 26);
				tfield[count-1].setText("0");
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

	private class BtnPreSubmitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
				circuit = new Circuit();
				circuit.setConnectType(connectType);
				int check = 0;
				for(int i = 0; i < components.size(); i++){
					if(tfield[i].getText().equals("")){
						JOptionPane.showMessageDialog(null, "Value of component number " + (i+1) + " can not be null. Please add a value.");
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
					if(tfVoltage != null){
						circuit.addSource(new ACsource(Double.parseDouble(tfVoltage.getText()), Double.parseDouble(tfFrequency.getText()), sourceType));
					}
				}
				else {
					if(tfVoltage != null){
						circuit.addSource(new DCsource(Double.parseDouble(tfVoltage.getText()), Double.POSITIVE_INFINITY, sourceType));
					}
				}
				if(check == components.size() && tfVoltage != null){
					if(panelToDraw != null){
						remove(panelToDraw);
					}
					panelToDraw = new CircuitPanel(circuit);
					panelToDraw.setBounds(465, 0, (int)SpecSetting.Width, (int)SpecSetting.Height);
					add(panelToDraw);
					panelToDraw.repaint();
					repaint();
				}
		}
	}
}
