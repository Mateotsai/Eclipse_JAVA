package tw.mateo0806;

import java.util.LinkedList;
import java.util.List;

public class lesson02_linkedList {

	public static void main(String[] args) {
		List list = new LinkedList();
		list.add("brad");
		list.add(123);
		list.add(1, 12.3); //1,是指定這個obj移到第0位置
		list.add(true);
		list.add(123); //無法移到5,，只能移到倒數第二
		list.add("brad");
		
		list.add(list.remove(3)); //移到最後的方法就是先remove再加上
		System.out.println(list.size());
		
		for (Object obj:list) {
			System.out.println(obj);
		}
	}

}
