package tw.mateo0813;

public class lesson02_Join {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		try {
			t1.join();  //t1完成後才會執行join在的main方法
		} catch (InterruptedException e) {
		}
		System.out.println("Main Finished!");
	}
}

class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread1 start working...");
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Thread1 DONE!");
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread2 start working...");
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Thread2 DONE!");
	}
}