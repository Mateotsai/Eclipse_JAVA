package tw.mateo0731.javaClass;

import tw.Object0731.Bike;

public class lesson04_Object_Bike {

	public static void main(String[] args) {
		Bike myBike = new Bike();
		System.out.println(myBike.getSpeed());
		myBike.upSpeed();myBike.upSpeed();myBike.upSpeed();myBike.upSpeed();myBike.upSpeed();
		myBike.downSpeed();
		System.out.println(myBike.getSpeed());
		
		System.out.println("---另一台車---");
		Bike urBike = new Bike();
		System.out.println(urBike.getSpeed());
		urBike.upSpeed();urBike.upSpeed();
		urBike.downSpeed();
		
		System.out.println(urBike.getSpeed());
		
		System.out.println("---myBike加到10以上---");
	
		
		
	}

}
