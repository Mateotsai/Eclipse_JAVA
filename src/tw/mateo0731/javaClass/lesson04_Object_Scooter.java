package tw.mateo0731.javaClass;

import tw.Object0731.Scooter;

public class lesson04_Object_Scooter {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		s1.changeGear(1);
		s1.upSpeed();s1.upSpeed();
		s1.downSpeed();
		System.out.println(s1.getSpeed());
		s1.changeGear(4);
		s1.upSpeed();s1.upSpeed();
		System.out.println(s1.getSpeed());
		System.out.println(s1.getColor());
	}

}
