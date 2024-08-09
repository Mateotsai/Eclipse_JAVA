package tw.mateo0802;

import java.util.Random;

import tw.API.IDCard.TWid;

public class lesson00_IDCard_caltrue {

	public static void main(String[] args) {
//			System.out.println(TWid.isRight("N125348174"));
		
//			Random rand = new Random();
//			System.out.println(rand.nextInt(1, 7));
		
		TWid id1 = new TWid();
		TWid id2 = new TWid(false);
		TWid id3 = new TWid('B');
		TWid id4 = new TWid(true,'Y');
		
		TWid id5 = TWid.newTWid("A123456789");
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		System.out.println(id5.getId());
	}

}
