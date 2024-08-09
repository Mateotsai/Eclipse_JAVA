package tw.mateo0731;

public class lesson03_Arraytwodimen1 {
//二維陣列
	public static void main(String[] args) {
		int[][] a = new int[3][]; //宣告a陣列佔三個記憶體空間a[0] a[1] a[2]
		//[][]兩個陣列都佔據了一個int空間 ?
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];

		for (int[] a1 : a) {
			for (int v : a1 ) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}

}
