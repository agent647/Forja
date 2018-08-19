package PatronCompuesto;

public abstract class Operation extends Expression{
	private Expression Expression1;
	private Expression Expression2;
	
	public Operation(Expression Expression1, Expression Expression2) {
		this.Expression1 = Expression1;
		this.Expression2 = Expression2;
	}
	
	public Expression getExpression1() {
		return Expression1;
	}
	public Expression getExpression2() {
		return Expression2;
	}
}
