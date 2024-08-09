package tw.mateo0731;

public class lesson02_ArrayAnswer2 {
	//一維陣列
	public static void main(String[] args) {
	//值骰子100次，之後計算六個數字的出現次數(使用陣列解法，作弊機台4.5.6點機率增加)
		int[] p = new int[7];
	
		for (int i=0; i <100; i++) {
			int point = (int)(Math.random()*9)+1;
			if (point >= 1 && point <= 9) {
				p[point>6? point-3:point]++;
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
