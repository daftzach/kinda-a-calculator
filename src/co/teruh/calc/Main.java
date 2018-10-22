package co.teruh.calc;

import co.teruh.calc.graphics.Window;

/**
 * This program is a tool that solves a variety of different math problems.
 * @author Zach Clark
 *
 */
public class Main {
	
	/**
	 * Calls window class at program start
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		Window ui = new Window();
		ui.initWindow();
	}

}
