package tw.mateo0730;

public class table99practice {

	public static void main(String[] args) {
		final int ROWS = 2; //使用常數，定義幾行幾列可隨時更改
		final int COLS = 4;
		final int START = 2;
		
		for(int k=0; k<ROWS; k++) {
			for (int j=1; j<=9; j++) {
				for (int i=START; i<START+COLS; i++) {
					int newi = i + k*COLS;
					int r = newi * j;
				System.out.printf("%d X %d = %3d\t",newi,j,r);
				}
				System.out.println();
			}
			System.out.println("---------------------------------");
	
		}
		
	}

}