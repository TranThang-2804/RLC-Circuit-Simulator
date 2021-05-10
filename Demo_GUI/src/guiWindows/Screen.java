package guiWindows;
import java.awt.*;
import javax.swing.*;

public class Screen extends JFrame{
//    private JTextField[] tfield;
//    private int count = 1;
//    private int constantHeightSaveBtn = 36;
//    private int constantHeightSaveLabel = 19;
//    private int constantHeightBtn = constantHeightSaveBtn;
//    private int constantHeightLabel = constantHeightSaveLabel;
//    private int btn = 41;
//    private JButton btnR;
//    private JButton btnL;
//    private JButton btnC;
//    private JButton btnSubmit;
//    private int space = 45;
    private Panel panel01;
    private Panel panel02;
    
	public Screen() {
		
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 560, 400);
		cp.add(tabbedPane);
		
		panel01 = new Panel();
		tabbedPane.addTab("Parallel", null, panel01, null);
		panel01.setLayout(null);
		
		panel02 = new Panel();
		tabbedPane.addTab("Serial", null, panel02, null);
		panel02.setLayout(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(560, 420);
	}
	
	public static void main(String[] args) {
		new Screen();
	}

}
