package TW.javaSE;

import java.util.Scanner;

public class SE01_guess {

	public static void main(String[] args) {
		var console = new Scanner(System.in);
		var number = (int)(Math.random()*10);
		var guess =  -1;  //使用-1增加閱讀性，也因為不是0~9之間的數值，避免無法預測的衝突
		System.out.println(number);
		do {
			System.out.println("猜數字(0~9):");
			guess = console.nextInt();
		}while(guess != number);

		//do while迴圈至少會做一次，和for  while迴圈不同，第一次判斷為假就退出
		
		System.out.println("猜中了!");
	}

}
