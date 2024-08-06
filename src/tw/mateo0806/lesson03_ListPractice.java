package tw.mateo0806;

import java.util.LinkedList;
import java.util.List;

public class lesson03_ListPractice {

	public static void main(String[] args) {
		List<String> times = new LinkedList<String>();
		times.add(0,"10:20:30"); //每個都設0,
		times.add(0,"10:20:34"); //越後面進場的排越前面
		times.add(0,"10:20:37");
		times.add(0,"10:20:47");
		times.add(0,"10:20:51");
		times.add(0,"10:20:59");
		System.out.println("---分隔線---");
		
		for(String time : times) {
			System.out.println(time);
		}
	}

}
