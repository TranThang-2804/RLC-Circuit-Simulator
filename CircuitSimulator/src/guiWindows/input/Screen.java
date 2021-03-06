package guiWindows.input;
import java.awt.*;
import javax.swing.*;


public class Screen extends JFrame{
    private Panel panelParallel;
    private Panel panelSerial;
    
	public Screen() {
		
		Container cp = getContentPane();
		cp.setLayout(null);
		setLocation(200, 200);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1024, 526);
		cp.add(tabbedPane);
		
		panelParallel = new Panel(false);
		tabbedPane.addTab("Parallel", null, panelParallel, null);
		panelParallel.setLayout(null);
		panelParallel.setBackground(new Color(224, 255, 255));
		
		panelSerial = new Panel(true);
		tabbedPane.addTab("Serial", null, panelSerial, null);
		panelSerial.setLayout(null);
		panelSerial.setBackground(new Color(224, 255, 255));
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 550);
	}

}
