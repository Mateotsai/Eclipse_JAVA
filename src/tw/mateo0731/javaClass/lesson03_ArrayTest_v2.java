package tw.mateo0731.javaClass;

public class lesson03_ArrayTest_v2 {
	//優化版本，將撲克牌52張牌發到4位玩家手中
	public static void main(String[] args) {
		//洗牌
		int[] poker = new int[52];
		boolean isRepeat;
		int temp;
		for (int i=0; i<poker.length; i++) {
			
			do { 
				temp = (int)(Math.random()*52);
				
				isRepeat = false;
				for(int j =0; j < i; j++) { //比到前一個數字，剛好是i運行中
					if (temp == poker[j]) {
						isRepeat = true; //重複了
						break;
					}
				}
						
			}while(isRepeat);
			
			poker[i] = temp;
			System.out.println(poker[i]);
			//檢查機制，避免重複
			
		
		}
		//發牌
		
		//攤牌 + 理牌
		

	}

}
