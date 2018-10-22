package co.teruh.calc.math;

public class MixedNumber extends Fraction {
	
	private int integer;
	
	public MixedNumber() {
		this(-1, -1, -1);
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
	
	public String toString() {
		return (getInteger() + " " + getNumerator() + "/" + getDenominator());
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
