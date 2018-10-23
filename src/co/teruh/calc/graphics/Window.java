package co.teruh.calc.graphics;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window {

	private JFrame frame; 
	private JPanel panel;

	public Window() {
		frame = new JFrame("Math Utils");
		panel = new JPanel(new FlowLayout());
	}

	public void initWindow() {
		frame.setVisible(true);
		frame.setSize(400, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.GRAY);
		panel.setOpaque(true);
		
		frame.add(panel);
	}
}
