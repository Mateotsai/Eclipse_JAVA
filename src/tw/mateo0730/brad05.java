package tw.mateo0730;

import java.util.Scanner;

public class brad05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入年份 = ");
		int Myyear = scanner.nextInt();
		
		if (Myyear % 4 == 0) {
			if (Myyear % 100 !=0) {
			   System.out.println(Myyear + "能被4整除且不能被100整除，是閏年");
			}else if (Myyear % 400 ==0){
			   System.out.println(Myyear + "能被4整除且能被400整除，是閏年");
			}else {
	           System.out.println(Myyear + "能被4整除且能被100整除但不能被400整除，不是閏年");	
			}
			
		}else {
		System.out.println(Myyear + "不能被4整除，不是閏年");
		
		}
	}

}
