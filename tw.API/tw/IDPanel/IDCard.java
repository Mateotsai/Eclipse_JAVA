package tw.IDPanel;

public class IDCard {
	private String id; //當這個方法執行完，這個String就會擁有ID這個屬性
	
	//判斷身分證數值是否正確
	//設計static方法isRight，將id這個String當參數代數，會返回布林值判斷真假
	public static boolean isRight(String id) {
		boolean isRight = false;  //設計時先將參數設定為false
		
		//長度為10		
		if(id.length() == 10) {
			//第一碼是英文字，用字串方式抓取
			if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(id.charAt(0)) != -1) {
				//第二碼是1或2
				if (id.charAt(1) == '1' || id.charAt(1) == '2') {
					
				}
			}		
		}
		

		
		//最後一碼是驗證碼
		return isRight;
		
	}
	

}
