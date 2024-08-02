package tw.mateo0801.javaClass;

import tw.Object0731.Bike;

public class lesson02_String {

	public static void main(String[] args) {
		String s1 = new String();
		System.out.println(s1.length());
		
		//BYTE資料轉成字串 97=a 98=b ...
		byte[] b1 = {97, 98, 99, 100};
		String s2 = new String(b1); //定義變數s2 是b1轉成字串物件
		System.out.println(s2.length()); //4
		System.out.println(s2); //abcd
		
		Bike b2 = new Bike();
		System.out.println(b2); //tw.Object0731.Bike@512ddf17 @後面的是記憶體位置
								//Bike那邊定義後就變成im a bike
		int c = 12;
		System.out.println(c); //12
		
		Object obj1 = new Object();
		System.out.println(obj1); //java.lang.Object@6fdb1f78
		
		
		String s3 = "Brad";
		System.out.println(s3);
		
		String s4 = "Brad";
		System.out.println(s3 == s4);  //true 兩個同源的賦予後，s3 s4佔據相同記憶體變成相同物件
		
		String s5 = new String("Brad");
		System.out.println(s3 == s5); //false 用new方法創建就會占用新的記憶體
		
		String s6 = new String("Brad");
		System.out.println(s5 == s6); //false
		
		System.out.println(s3.equals(s5)); //true
		
		System.out.println("Brad".charAt(0)); //雙引號本身就是物件，後面可以直接.方法
	}

}
