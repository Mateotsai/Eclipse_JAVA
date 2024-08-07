package tw.mateo0805;

import java.util.HashSet;

import tw.API.vehicle.Bike;


public class lesson10_Collection_set {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add("Brad");
		set.add(12);  //12 => new Interger(12) 自動封裝成物件實體
		set.add(12.3); 
		set.add("Brad");
		set.add(new Bike());
		set.add(12);
		
		System.out.println(set.size()); //不重覆、不按照放入順序
		System.out.println(set);
	}

}


