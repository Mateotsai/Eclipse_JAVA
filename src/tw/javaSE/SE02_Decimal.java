package tw.javaSE;

import java.math.BigDecimal;

public class SE02_Decimal {

	public static void main(String[] args) {
		var operand1 = new BigDecimal("1.0");
		var operand2 = new BigDecimal("0.8");
		var result = operand1.subtract(operand2);
		System.out.println(result);
		
		if(operand1.subtract(operand2).equals(result)) {
			System.out.println("等於0.2");
		}else {
			System.out.println("不等於0.2 ");
		}
	}

}
