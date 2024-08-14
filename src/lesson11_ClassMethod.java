class lesson11_ClassMethod{
	public static void main(String[] args) {
		
		lesson11_ClassMethod.talk("你好");
		lesson11_ClassMethod.talk("hELLO");
		BasicMath.add(3,4);
		BasicMath.multiply(3, 4);
	}
	
	static void talk(String msg) {
		System.out.println(msg);
		
	}
	
	
	class BasicMath{
	static void add(int n1, int n2) {
		int result = n1 + n2;
		System.out.println(result);
	}
	
	static void multiply(int n1, int n2) {
		int result = n1 * n2;
		System.out.println(result);
	}
	}
}

