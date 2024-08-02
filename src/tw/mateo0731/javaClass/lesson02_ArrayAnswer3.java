package tw.mateo0731.javaClass;

public class lesson02_ArrayAnswer3 {
	//一維陣列
	public static void main(String[] args) {
	//值骰子100次，之後計算六個數字的出現次數(使用陣列解法)
		int[] p = new int[7];
	
		for (int i=0; i <100; i++) {
			int point = (int)(Math.random()*6)+1;
			if (point >= 1 && point <= 6) {
				p[point]++;
			}else {
				p[0]++;
			}
		}
	
		if (p[0] > 0) {
			System.out.println("Error!");
		}else {
			for(int i=1; i<p.length; i++) {
			System.out.printf("%d點出現%d次\n", i, p[i]);
			}
		}
	}

}
