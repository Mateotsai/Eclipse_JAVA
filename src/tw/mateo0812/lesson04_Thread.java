package tw.mateo0812;

public class lesson04_Thread {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread("mt1");
		MyThread mt2 = new MyThread("A2");
		MyRunnable mr1 = new MyRunnable("c");
		//用runnable比較彈性，還可以找其他當父類別
		//之後再用建構式轉成執行緒便可以執行
		Thread t1 = new Thread(mr1);
		
		mt1.start();
		mt2.start();
		t1.start();
		
		System.out.println("兩個物件同一個執行緒，啟動");
		
		
	}
}

 	//建立多執行緒的類別
class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	//override一個run方法
	@Override
	public void run() {
		for(int i = 0 ; i<20 ; i++) {
			System.out.printf("%s : %d\n",name,i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}


class MyRunnable implements Runnable {
	private String name;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	//override一個run方法
	@Override
	public void run() {
		for(int i = 0 ; i<20 ; i++) {
			System.out.printf("%s : %d\n",name,i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}