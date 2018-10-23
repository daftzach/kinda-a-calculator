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

	public int getGCF(int a, int b) {
		if (a == 0) {
			return b;
		}

		return getGCF(b % a, a);
	}

	public void simplify() {
		int gcf = getGCF(getNumerator(), getDenominator());
		setNumerator(getNumerator() / gcf);
		setDenominator(getDenominator() / gcf);
	}

	public float toDecimal() {
		return (float) getNumerator() / (float) getDenominator();
	}

	public double toPercent() {
		return toDecimal() * 100;
	}

	public String toString() {
		if (!(getDenominator() == 0) && !(getDenominator() == 1)) {
			return (getNumerator() + "/" + getDenominator());
		} else if (getDenominator() == 1) {
			return Integer.toString(getNumerator());
		} else {
			return null;
		}
	}

	public MixedNumber convertToMixedNumber() {
		if (getNumerator() > getDenominator()) {
			int newNumerator = getNumerator() % getDenominator();
			int integer = getNumerator() / getDenominator();
			MixedNumber newFraction = new MixedNumber(integer, newNumerator, getDenominator());
			return newFraction;
		} else {
			return null;
		}
	}

}
