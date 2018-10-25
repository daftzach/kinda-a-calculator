package co.teruh.calc.math;

public class MixedNumber extends Fraction {

	private int integer;

	public MixedNumber() {
		this(0, -1, -1);
	}

	public MixedNumber(int i, int n, int d) {
		super(n, d);
		this.integer = i;
	}

	public int getInteger() {
		return integer;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

	public boolean isMixed() {
		if (integer == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		if (!(getDenominator() == 0) && isMixed()) {
			return (getInteger() + " " + getNumerator() + "/" + getDenominator());
		} else if (getInteger() == 0) {
			convertToFraction();
			return super.toString();
		} else {
			throw new ArithmeticException("Invalid denominator");
		}
	}

	public float toDecimal() {
		return (float) getInteger() + ((float) getNumerator() / (float) getDenominator());
	}

	public double toPercent() {
		return toDecimal() * 100;
	}

	public Fraction convertToFraction() {
		int newNumerator = ((getDenominator() * getInteger()) + getNumerator());
		Fraction newFraction = new Fraction(newNumerator, getDenominator());
		return newFraction;
	}
}
