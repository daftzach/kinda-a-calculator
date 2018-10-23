package co.teruh.calc;

import co.teruh.calc.graphics.Window;
import co.teruh.calc.math.Fraction;
import co.teruh.calc.math.MixedNumber;

/**
 * This program is a tool that solves a variety of different math problems.
 * 
 * @author Zach Clark
 *
 */
public class Main {

	/**
	 * Calls window class at program start
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {

		Fraction f1 = new Fraction(4, 2);
		System.out.println(f1.toString());
		f1.simplify();
		System.out.println(f1.toString());
		System.out.println(f1.toDecimal());
		System.out.println(f1.toPercent());
		System.out.println(f1.convertToMixedNumber());

		MixedNumber m1 = new MixedNumber(11, 3, 18);
		System.out.println(m1.toString());
		m1.simplify();
		System.out.println(m1.toString());
		System.out.println(m1.toDecimal());
		System.out.println(m1.toPercent());
		System.out.println(m1.convertToFraction());

		Window ui = new Window();
		ui.initWindow();
	}

}
