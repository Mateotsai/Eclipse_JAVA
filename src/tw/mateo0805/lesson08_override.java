package tw.mateo0805;

public class lesson08_override {

	public static void main(String[] args) {
	
	}
}
//Overload重載，讓同一個方法可以用不同數量型別的參數呼叫，參數名一樣，個數型別不一樣
class Brad251 {
	void m1() {}
	void m1(int a) {}
	public int m1(double a) {return 1;}
	Object m2() {return new Object();}
}
//Override覆寫，發生在父子類別繼承，參數、個數、基本型別一樣，只有方法內容能不一樣
class Brad252 extends Brad251{
	@Override
	String m2() {
		return "2";
	}
}