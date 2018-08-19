package PatronCompuesto;

public class PruebasOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number num1 = new Number(5);
		Number num2 = new Number(3);
		
		SumOperation operationSum = new SumOperation(num1, num2);
		
		System.out.println(operationSum.getExpression1().operation());
		
		System.out.print(operationSum.operation());
	}

}
