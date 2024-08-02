package tw.mateo0731.javaClass;

import java.util.Arrays;

public class lesson03_ArrayTest_v3 {
	//二維陣列，洗牌演算法，將撲克牌52張牌發到4位玩家手中
	public static void main(String[] args) {
		final int nums = 52;
		int[] poker = new int[nums];
		for(int i=0; i<poker.length;i++) poker[i] = i;
		//洗牌
		for(int i=nums-1; i > 0; i--) {
			int rand = (int)(Math.random()*(i+1));
			// poker[rand] <=> poker[i]
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
//			for (int card : poker) {
//				System.out.println(card);
//			}
		
		//發牌
		System.out.println("----發牌----");
		int[][] players = new int[4][13];
		for(int i =0; i< poker.length; i++) {
			players[i%4][i/4] = poker[i];
		}
		//for (int card : players[0]) {
		//	System.out.println(card);
		//}
		
		
		//定義每個數字是哪一張牌
		String[] suits = {"黑桃","紅心","方塊","梅花"};
		String[] values = {"A","2","3","4","5","6","7"
						,"8","9","10","J","Q","K"};
		
		//攤牌
		
		for(int[] player : players) {
			//理牌
			Arrays.sort(player);
			
			for(int card : player) {
			  System.out.printf("%s%s ",suits[card/13],values[card%13]);
			  }
			System.out.println();
		}
			
		
		
		
	
	}

}
