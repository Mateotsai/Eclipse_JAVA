package tw.mateo0731;

public class lesson03_Arraytwodimen3 {
//二維陣列
	public static void main(String[] args) {
		int[][] classScore = new int[3][]; 
		classScore[0] = new int[] {85, 90, 78, 88};
		classScore[1] = new int[] {92, 86, 95};
		classScore[2] = new int[] {76, 83, 89, 91, 87};

		int classNumber =1;
		for (int[] score : classScore) {
			System.out.println("第" + classNumber + "班的學生分數: ");
			int studentNumber =1;
			for (int sc : score ) {
				System.out.println("學生" + studentNumber + ":" + sc+"分");
				studentNumber++;
			}
			classNumber++;
			System.out.println();
		}
	}

}
