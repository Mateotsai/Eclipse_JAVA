package tw.mateo0730.javaClass;

import java.util.Scanner;

public class variablePractice {

	public static void main(String[] args) {
		//input
		Scanner scanneraabb = new Scanner(System.in);
		
		System.out.print("請輸入 X = ");
		int aaa = scanneraabb.nextInt();
		
		System.out.print("請輸入 Y = ");
		int bbb = scanneraabb.nextInt();
		
		//operation
		int myPl = aaa + bbb;
		int myMi = aaa - bbb;
		int myMu = aaa * bbb;
		int myDi = aaa / bbb;
		int myLa = aaa % bbb;
		
		
		//output
		System.out.printf("%d + %d = %d%n", aaa,bbb,myPl);
		System.out.printf("%d - %d = %d%n", aaa,bbb,myMi);
		System.out.printf("%d * %d = %d%n", aaa,bbb,myMu);
		System.out.printf("%d / %d = %d.....%d%n", aaa,bbb,myDi,myLa);	
	}

}
