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
		
		Fraction f1 = new Fraction(3, 10);
		f1.simplify();
		System.out.println(f1.toString());
		System.out.println(f1.toDecimal());
		System.out.println(f1.toPercent());
		
		MixedNumber m1 = new MixedNumber(4, 6, 8);
		m1.simplify();
		System.out.println(m1.toString());
		System.out.println(m1.toDecimal());
		System.out.println(m1.toPercent());
		
		//Window ui = new Window();
		//ui.initWindow();
	}

}
