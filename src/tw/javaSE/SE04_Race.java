package tw.javaSE;

public class SE04_Race {
	//龜兔賽跑，多執行緒版

	public static void main(String[] args) {
		Turtle turtle = new Turtle(10);
		Rabbit rabbit = new Rabbit(10);

		Thread turtleThread = new Thread(turtle);
		Thread rabbitThread = new Thread(rabbit);

		System.out.println("賽跑開始!");
		turtleThread.start();
		rabbitThread.start();
		try {
			turtleThread.join();
			rabbitThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("比賽結束!");
	}

}


class Turtle implements Runnable{
	private int totalStep;
	private int step;

	public Turtle(int totalStep) {
		this.totalStep = totalStep;
	}

	@Override
	public void run() {
		while(step < totalStep) {
			step++;
			System.out.printf("烏龜跑了%d步...%n",step);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		System.out.println("烏龜抵達終點!");
	}
}

class Rabbit implements Runnable{
	private boolean[] flags = {true, false};
	private int step; 
	private int totalStep;

	public Rabbit(int totalStep) {
		this.totalStep = totalStep;
	}

	@Override
	public void run() {
		while(step < totalStep) {
			boolean isRabbitSleep = flags[((int)(Math.random()*10)) % 2];
			if(isRabbitSleep) {
				System.out.println("兔子睡著了zzzzz");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}else {
				int move = (int)(Math.random()*3)+1;
				step += move;
				if (step > totalStep) step = totalStep;
				System.out.printf("兔子跑了%d步...%n",step);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("兔子抵達終點!");
	}

}