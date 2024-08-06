package tw.mateo0805;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class lesson12_Lottery {

	public static void main(String[] args) {
		//TreeSet有自然排序，按照大小、不重覆
		TreeSet<Integer> power = new TreeSet<Integer>();
			while (power.size()<6) {
				power.add( new Random().nextInt(1,39));			
			}
			
			System.out.println(power);
			System.out.println("---------------迭代取數舊方法-------------");
			Iterator<Integer> it = power.iterator();
			while (it.hasNext()) {
				Integer num = it.next();
				System.out.println(num);
			}
			System.out.println("---------------Foreach-----------------");
			for (Integer v : power) {
				System.out.println(v);
			}
			
			
	}

}
