package guiWindows.input;
import java.awt.*;
import javax.swing.*;


public class Screen extends JFrame{
    private Panel panelParallel;
    private Panel panelSerial;
    
	public Screen() {
		
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 763, 526);
		cp.add(tabbedPane);
		
		panelParallel = new Panel(false);
		tabbedPane.addTab("Parallel", null, panelParallel, null);
		panelParallel.setLayout(null);
		
		panelSerial = new Panel(true);
		tabbedPane.addTab("Serial", null, panelSerial, null);
		panelSerial.setLayout(null);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(763, 550);
	}

}
