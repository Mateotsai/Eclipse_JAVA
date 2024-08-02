package tw.mateo0731.javaClass;

public class lesson02_ArrayTest {
	//一維陣列
	public static void main(String[] args) {
	//值骰子100次，之後計算六個數字的出現次數(不使用陣列解法)
	int p0,p1,p2,p3,p4,p5,p6;
	p0 = p1 = p2 = p3 = p4 = p5 = p6 =0;
	for (int i=0; i< 100; i++) {
		int point = (int)(Math.random()*6)+1;
		//System.out.println(point);
		switch (point) {
			case 1: p1++ ; break;
			case 2: p2++ ; break;
			case 3: p3++ ; break;
			case 4: p4++ ; break;
			case 5: p5++ ; break;
			case 6: p6++ ; break;
			default: p0++ ; //當出現p0，代表骰子的邏輯有錯誤
		}
	}
	if (p0 > 0) {
		System.out.println("Error!");
	}else {}
		System.out.printf("%d點出現%d次\n", 1, p1);
		System.out.printf("%d點出現%d次\n", 2, p2);
		System.out.printf("%d點出現%d次\n", 3, p3);
		System.out.printf("%d點出現%d次\n", 4, p4);
		System.out.printf("%d點出現%d次\n", 5, p5);
		System.out.printf("%d點出現%d次\n", 6, p6);
		
	
	}

}
