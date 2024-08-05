package tw.mateo0805;

public class lesson06_Interface {

	public static void main(String[] args) {
		Brad221 obj1 = new Brad222();
		Brad223 obj2 = new Brad222();
		Brad222 obj3 = new Brad222();
		obj1.m1();obj1.m2();
		obj2.m3();obj2.m4();
		obj3.m1();obj3.m2();obj3.m3();obj3.m4();
	}

}
//定義介面，介面內沒有實作
interface Brad221 {
	void m1();
	void m2();
}
interface Brad223 {
	void m3();
	void m4();
}
class Brad222 implements Brad221,Brad223 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}