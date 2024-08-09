package tw.mateo0730;

public class brad04 {

	public static void main(String[] args) {
		double temp = Math.random(); //0.0 ~ 1.0之間亂數
		int score = (int)(temp * 101) -1; 
		
		if (score >= 90) {
			System.out.println("Score:" + score + "\nClass: A");
		}else if (score >= 80) {
			System.out.println("Score:" + score + "\nClass: B");	
		}else if (score >= 70) {
			System.out.println("Score:" + score + "\nClass: C");	
		}else if (score >= 60) {
			System.out.println("Score:" + score + "\nClass: D");	
		}else {
			System.out.println("Score:" + score + "\nClass: E");				
		}
			
	}


		
//		if (score >= 90) {
//			System.out.println("Score:" + score + "\nClass: A");
//		}else {
//			if (score >= 80) {
//				System.out.println("Score:" + score + "\nClass: B");	
//			}else {
//				if (score >= 70) {
//					System.out.println("Score:" + score + "\nClass: C");	
//				}else {
//					if (score >= 60) {
//						System.out.println("Score:" + score + "\nClass: D");	
//					}else {
//						System.out.println("Score:" + score + "\nClass: E");
//					}
//				}
//				
//			}
//			
//		}

		
		
}


