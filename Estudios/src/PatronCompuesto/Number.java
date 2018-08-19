package PatronCompuesto;

public class Number extends Expression {
	private int value;
	
	public Number(int value) {
		this.value = value;
	}
	
	public int operation() {
		return this.value;
	}
}
