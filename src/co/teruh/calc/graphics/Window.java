package co.teruh.calc.graphics;

import javax.swing.JFrame;

/**
 * This class creates/places Java swing elements that are used on the graphical
 * end of the program.
 * 
 * @author Zach Clark
 *
 */
public class Window {

	private final JFrame frame; // JFrame object which will serve as the program's window

	/**
	 * Default constructor for the window
	 */
	public Window() {
		// Initialize JFrame reference, create new window
		frame = new JFrame("Math Utils");
	}

	/**
	 * Initialize and place window/panel elements
	 */
	public void initWindow() {
		// Set JFrame attributes
		frame.setVisible(true);
		frame.setSize(600, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
