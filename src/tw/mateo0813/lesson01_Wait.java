package tw.mateo0813;

import java.util.Random;

import javax.management.RuntimeErrorException;

public class lesson01_Wait {

	public static void main(String[] args) {
		Store store = new Store();
		Producer p = new Producer(store);
		Consumer c1 = new Consumer(store, "Brad");
		Consumer c2 = new Consumer(store, "Amy");
		Consumer c3 = new Consumer(store, "Ken");
		p.start();
		c1.start();
		c2.start();
		c3.start();

	}

}
	class Store{
		private int qty;
		private int max;
		Store(){
			max = 10;
		}
		
		synchronized void add(int add) throws InterruptedException {
			System.out.printf("準備進貨:%d\n", add);	
			while(qty + add > max) {  //貨架上位置不夠不能進貨
				wait();
			}
			qty += add;
			System.out.printf("完成進貨:%d,目前庫存:%d\n", add,qty);
			notify();
		}
		
		synchronized void buy(int buy, String name) throws InterruptedException {
			System.out.printf("%s想買: %d\n", name, buy);	
			while(qty < buy) {  
				wait();
			}
			qty -= buy;
			System.out.printf("銷售給%s共%d件,目前庫存:%d\n", name, buy, qty);
			notify();
		}
		
	}
	
	
	
	class Producer extends Thread {
		private Store store;
		public Producer(Store store) {
			this.store = store;
		}
		@Override
		public void run() {
			for (int i=0; i<10; i++) {
				try {
					store.add(5);
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}
	
	class Consumer extends Thread {
		private Store store;
		private String name;
		public Consumer(Store store, String name) {
			this.store = store;
			this.name = name;
		}
		@Override
		public void run() {
			for (int i=0; i<10; i++) {
				try {
					store.buy((int)(Math.random()*3)+1, name);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}
		