package tw.Object0731;

//定義"物件"的"類別class"
public class Bike {
//	private double speed;  //設定物件的"屬性"，設定private，引用的人不能亂改屬性
	protected double speed; //改成protected，繼承子類別的人可以使用
	
	/*
	存取修飾字{	
	public    |全部都開放使用
	protected |繼承相同的子類別、相同package
	"沒寫"	  |相同package
	private   |自己
	
	*/
	
	//建構式
	public Bike() {
		System.out.println("Bike()");
	}
	
	//下面加上物件提供的"方法"，用public引用的人才可以用來"改變屬性"
	public void upSpeed() {
		speed = speed < 1? 1 : speed * 1.4;
	}
	
	public void downSpeed() {
		speed = speed < 1? 0 : speed * 0.7;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public String toString() {
		return "I'm a bike" + speed;
	}
}
