package tw.API.vehicle;

public class Scooter extends Bike{ //延伸Bike封裝的功能，實現物件導向繼承觀念
	
	//增加顏色
	private String color;
	//增加檔位系統
	private int gear;
	//Java世界裡面所有類別都一定有建構式，若沒有定義，編譯器
	//建構式，進行物件的初始化，名稱與類別一模一樣()，寫法和方法一樣			
	//無參數的建構式建立起來才會有辦法繼承給子代
	public Scooter() {			
		System.out.println("Scooter()");
		color = "Yellow";
	}
	//建構式，進行物件的初始化				
	public Scooter(String color) {	
		//super("");  //呼叫父物件
		this.color = color;
		System.out.println("Scooter(String)");
	}
	
	
	//定義檔位系統的方法
	public void changeGear(int gear) {
		if(gear >=0 && gear <=4) {
			this.gear = gear;
		}
	}
	//繼承並修正腳踏車的upSpeed()
	public void upSpeed() {
		super.upSpeed(); //呼叫父類別的物件實體
		if (gear > 0 ) {
		speed = speed < 1? 1 : speed * 1.8* gear;
		}
	}		
	
	public String getColor(){
		return color;
	}

}
