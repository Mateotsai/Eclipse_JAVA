package tw.mateo0807;

public class lesson05_Finally {

	public static void main(String[] args) {
		m1();
		

	}
	static  void m1() {
		System.out.println("1");
		int[] a = {1,2,3,4};
		
		try {
			System.out.println(a[100]);
			System.out.println("剛剛的程序沒問題");
		}catch(Exception e) {
			System.out.println("印出例外\n" + e);
		}finally { //最後一定會到finally，即使中間放return
			System.out.println("finally");
		}
		System.out.println("Ok!");
	}
	

}
