package PatronCompuesto;

public class SumOperation extends Operation{
	
	public SumOperation(Expression Expression1, Expression Expression2) {
		super(Expression1,Expression2);
	}
	
	public int operation() {
		return this.getExpression1().operation() + this.getExpression2().operation();
	}
}
