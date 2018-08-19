package PatronCompuesto;

public class SubstractionOperation extends Operation{
	
	public SubstractionOperation(Expression Expression1, Expression Expression2) {
		super(Expression1, Expression2);
	}
	
	@Override
	public int operation() {
		return this.getExpression1().operation() - this.getExpression2().operation();
	}
}
