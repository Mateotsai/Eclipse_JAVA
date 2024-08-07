package tw.mateo0807;

public class lesson01_Exception {

	public static void main(String[] args) {
		
		try {
			int a = 10, b = 3;
			int c = a / b;
			System.out.println(c); //列出了B可能為0的例外

		}catch (ArithmeticException e) {
			System.out.println("error!");
		}
		System.out.println("OK");
		
		
	}

}
