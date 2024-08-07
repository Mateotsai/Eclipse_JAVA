package tw.mateo0807;

public class lesson02_Exception {

	public static void main(String[] args) {
		int a = 10, b = 0;
		int[] d = {0,1,2,3};
		
		
		try {
		int c = a / b;
		System.out.println(c);
		System.out.println(d[12]);
		}catch (ArithmeticException e) {
			System.out.println("error1!"); 
			//第一個抓到例外，第二個就不會跑
			//如果都要抓的話就另外包一個try catch
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("error2!");
		}catch (RuntimeException e) {
			System.out.println("error3!");
		}
		System.out.println("OK");

	}

}

//其他常見的異常類型：
//RunTimeException: Exception父集合，放最後做除錯
//NullPointerException: 嘗試使用為 null 的對象
//ArrayIndexOutOfBoundsException: 數組索引越界
//IllegalArgumentException: 方法接收到不合法的參數
//IOException: 輸入輸出操作失敗或中斷
