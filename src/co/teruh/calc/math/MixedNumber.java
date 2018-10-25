package co.teruh.calc.math;

public class MixedNumber extends Fraction {

	private int wholeNumber;

	public MixedNumber() {
		this(0, -1, -1);
	}

	public MixedNumber(int i, int n, int d) {
		super(n, d);
		this.wholeNumber = i;
	}

	public int getWholeNumber() {
		return wholeNumber;
	}

	public void setWholeNumber(int integer) {
		this.wholeNumber = integer;
	}

	public boolean isMixed() {
		if (wholeNumber == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		if (!(getDenominator() == 0) && isMixed()) {
			return (getWholeNumber() + " " + getNumerator() + "/" + getDenominator());
		} else if (getWholeNumber() == 0) {
			convertToFraction();
			return super.toString();
		} else {
			throw new ArithmeticException("Invalid denominator");
		}
	}

	public float toDecimal() {
		return (float) getWholeNumber() + ((float) getNumerator() / (float) getDenominator());
	}

	public double toPercent() {
		return toDecimal() * 100;
	}

	public Fraction convertToFraction() {
		int newNumerator = ((getDenominator() * getWholeNumber()) + getNumerator());
		Fraction newFraction = new Fraction(newNumerator, getDenominator());
		return newFraction;
	}
}
