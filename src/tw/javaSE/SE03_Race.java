package tw.javaSE;

public class SE03_Race {

	public static void main(String[] args) {
		boolean[] flags = { true, true, true, false};  //兔子有75%睡覺
		int totalStep = 10;
		int turtleStep = 0;
		int rabbitStep = 0;

		
		System.out.println("龜兔賽跑，開始!");
		while(turtleStep < totalStep && rabbitStep < totalStep) {
			turtleStep++;
			System.out.printf("烏龜走了 %d 步...%n",turtleStep);
			boolean isRabbitSleep = flags[(int)(Math.random() *10) % 4]; //隨機睡覺，數列中有三個true一個false
			if(isRabbitSleep) {											 //數列中有三個true一個false，使用4的餘數
				System.out.println("兔子睡著了...");						 //隨機取數列中的其中一個值當布林
			}else {
				rabbitStep +=2;
				System.out.printf("兔子跑了 %d 步...%n", rabbitStep);
			}

		}

		System.out.println("比賽結束，" + (turtleStep >= totalStep? "烏龜":"兔子") +"贏了!");

	}

}
