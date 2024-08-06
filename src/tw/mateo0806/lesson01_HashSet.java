package tw.mateo0806;

import java.util.LinkedHashSet;

public class lesson01_HashSet {

	public static void main(String[] args) {
		LinkedHashSet<String> names = new LinkedHashSet<>();
		//不可重覆，按輸入順序輸出
		System.out.println(names.add("Brad")); //true
		System.out.println(names.add("Eric")); //true
		System.out.println(names.add("Andy")); //true
		System.out.println(names.add("Mark")); //true
		System.out.println(names.add("Brad")); //false  重覆為false
		System.out.println(names.add("Tony")); //true
		System.out.println(names.add("Brad")); //false  重覆為false
		
		System.out.println("------");
		
		//只要擁有iterable可迭代特性，就可以用for each
		for( String name : names) {
			System.out.println(name);
		}
	}

}
