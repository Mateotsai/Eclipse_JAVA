package tw.mateo0731;

public class lesson03_ArrayTest_v1 {
	//二維陣列，練習，將撲克牌52張牌發到4位玩家手中
	public static void main(String[] args) {
		
//		long start = System.currentTimeMillis();
		//洗牌
		int[] poker = new int[52];
		for (int i=0; i<poker.length; i++) {
			int temp = (int)(Math.random()*52);
			
			//檢查機制，避免重複
			boolean isRepeat = false;
			for(int j =0; j < i; j++) { //比到前一個數字，剛好是i運行中
				if (temp == poker[j]) {
					isRepeat = true; //重複了
					break;
				}
			}
			//檢查後執行
			if(!isRepeat) { //不重複就丟進去
			poker[i] = temp;
			System.out.println(poker[i]);
			}else {
				i--; //如果有重複，這趟當沒做過，扣掉1再跑一次
			}
		}
		
//		System.out.println("------");
//		System.out.println(System.currentTimeMillis()-start);
		//發牌
		
		//攤牌 + 理牌
		

	}

}
