package tw.javaSE;

public class SE05_Join {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("主程式即將開始...");
		
		Thread threadB = new Thread(() -> {
			System.out.println("執行緒B即將開始...");
			for(int i= 0;i<5;i++ ) {
			System.out.println("執行緒B執行中...");
			}
			System.out.println("執行緒B即將結束...");
		}); 
		threadB.start();
		threadB.join();
		System.out.println("主程式結束...關閉");

	}

}
