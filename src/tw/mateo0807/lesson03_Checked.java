package tw.mateo0807;

public class lesson03_Checked {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(2);
		} catch (Exception e) {
			System.out.println("Ooooops!");
		}
	}
}

	class Bird {
		private int leg;
		
		void setLeg(int leg) throws Exception{//先宣告有可能傳出exception
			if(leg >= 0 && leg <= 2) { //檢查鳥的腳只有0~2隻
			this.leg = leg;
			}else {
				throw new Exception();
			}
		}
	}