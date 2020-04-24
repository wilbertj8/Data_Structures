public class Term {
	private int coefficient, power;
	
	public Term(int coefficient, int power) {
		this.coefficient = coefficient;
		this.power = power;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public int getPower() {
		return power;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
