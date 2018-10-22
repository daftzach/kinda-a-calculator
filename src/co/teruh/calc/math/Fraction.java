package co.teruh.calc.math;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction() {
		this(-1, -1);
	}
	
	public Fraction(int n, int d) {
		this.numerator = n;
		this.denominator = d;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public String toString() {
		return (getNumerator() + " / " + getDenominator());
	}

}
