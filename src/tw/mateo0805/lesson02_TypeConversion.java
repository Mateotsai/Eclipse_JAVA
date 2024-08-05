package tw.mateo0805;

public class lesson02_TypeConversion {

	public static void main(String[] args) {
		Brad191 obj1 = new Brad191();
		obj1.m1();obj1.m2();
		
		System.out.println("-------");
		Brad192 obj2 = new Brad192();
		obj2.m1();obj2.m2();obj2.m3();
		
		System.out.println("-------");
		
		//用192初始化191
		Brad191 obj3 = new Brad192();
		obj3.m1();obj3.m2(); //沒有obj3.m3();
//		Brad191:m1()
//		Brad192:m2()????
		
		//強制轉型Brad192
		Brad192 obj4 = (Brad192)obj3;
		obj4.m1();obj4.m2();obj4.m3();
		
		//Brad192 obj5 = (Brad193)obj3;  
		//Brad193 obj5 = (Brad192)obj3; 
		//無法轉，因為192和193是兄弟不是父子
	
		Brad191 obj7 = new Brad192();
		//Brad193 obj8 = (Brad193)obj7;
		
		if(obj7 instanceof Object) {
			System.out.println("YES1");
		}else {
			System.out.println("NO1");
		}
		
		if(obj7 instanceof Brad191) {
			System.out.println("YES2");
		}else {
			System.out.println("NO2");
		}
		
		if(obj7 instanceof Brad192) {
			System.out.println("YES3");
		}else {
			System.out.println("NO3");
		}
		
		if(obj7 instanceof Brad193) {
			System.out.println("YES4");
		}else {
			System.out.println("NO4");
		}
		
	}

}

class Brad191 {
	void m1() {
		System.out.println("Brad191:m1()");
	}
	
	void m2() {
		System.out.println("Brad191:m2()");
	}
}

class Brad192 extends Brad191 {
	//改寫父代的類別方法
	
	void m2() {
		System.out.println("Brad192:m2()");
	}
	
	void m3() {
		System.out.println("Brad192:m3()");
	}
}

class Brad193 extends Brad191 {
	
	void m2() {
		System.out.println("Brad193:m2()");
	}
	
	void m3() {
		System.out.println("Brad193:m3()");
	}
}