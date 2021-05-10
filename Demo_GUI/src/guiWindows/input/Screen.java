package guiWindows.input;
import java.awt.*;
import javax.swing.*;


public class Screen extends JFrame{
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

}
