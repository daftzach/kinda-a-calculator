package co.teruh.calc;

import co.teruh.calc.graphics.Window;
import co.teruh.calc.math.Fraction;
import co.teruh.calc.math.MixedNumber;

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
		
		Fraction f1 = new Fraction(3, 6);
		System.out.println(f1.toString());
		
		MixedNumber m1 = new MixedNumber(5, 7, 8);
		System.out.println(m1.toString());
		System.out.println(m1.convertToFraction());
		
		MixedNumber m2 = new MixedNumber(2, 1, 3);
		System.out.println(m2.toString());
		System.out.println(m2.convertToFraction());
		
		//Window ui = new Window();
		//ui.initWindow();
	}

}
