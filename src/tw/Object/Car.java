package tw.Object;

public class Car extends Scooter {
	//1.任何類別都一定要有建構式
	//2.第一句話要呼叫父物件，所有祖宗元素完成初始化、自己完成初始化
	public Car(int a) {
		super("");
		System.out.println("Car(int)");
	}
}
