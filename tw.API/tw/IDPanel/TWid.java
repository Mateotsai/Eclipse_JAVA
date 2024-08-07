package tw.IDPanel;

import java.util.Random;

public class TWid {
	private String id; //當這個方法執行完，這個String就會擁有ID這個屬性
	
	static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	
	//四個建構子建立
	public TWid() {
		this(new Random().nextInt(2) == 0);
	}
	
	public TWid(boolean isMale) {
		this(isMale, letters.charAt(new Random().nextInt(26)));
	}
	
	public TWid(char area) {
		this(new Random().nextInt(2) == 0, area);
	}
	
	public TWid(boolean isMale, char area) {
		String c1 = new String(new char[] {area});
		StringBuffer sb = new StringBuffer(c1);
		sb.append(isMale? "1":"2");
		for (int i=0 ; i < 7; i++) sb.append(new Random().nextInt(10));
		
		for (int i=0; i<10; i++) {
			if (isRight(sb.toString()+i)) {
				id = sb.toString()+i;
				break;
			}
		}
	}
	
	public String getId() {
		return id;
	}	
	
	private TWid(String id) {
		this.id = id;
	}
	
	public static TWid newTWid(String id) {
		if (isRight(id)) {
			return new TWid(id);
		}else {
			return null;
		}
	}
	
	//判斷身分證數值是否正確
	//設計static方法isRight，將id這個String當參數代數，會返回布林值判斷真假
	public static boolean isRight(String id) {
		boolean isRight = true;  //設計時先將參數設定為false
		

		
		if (id.matches("[A-Z][12][0-9]{8}")){//正規表示法，第一碼A-Z 第二碼1.2 第三碼0~9連續八次
			char c1 = id.charAt(0);
			int a12 = letters.indexOf(c1) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			
			String s1 = id.substring(1,2);
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(id.substring(2,3));
			int n3 = Integer.parseInt(id.substring(3,4));
			int n4 = Integer.parseInt(id.substring(4,5));
			int n5 = Integer.parseInt(id.substring(5,6));
			int n6 = Integer.parseInt(id.substring(6,7));
			int n7 = Integer.parseInt(id.substring(7,8));
			int n8 = Integer.parseInt(id.substring(8,9));
			int n9 = Integer.parseInt(id.substring(9,10));
			
			int sum = a1*1 + a2*9 + n1*8 + n2*7 + n3*6 + 
					n4*5 + n5*4 + n6*3 + n7*2 + n8*1 + n9*1;
			
			isRight = sum % 10 == 0;
			
		}
		
		return isRight;
		
	}
	

}
