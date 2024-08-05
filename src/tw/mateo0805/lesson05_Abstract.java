package tw.mateo0805;

public class lesson05_Abstract {

	public static void main(String[] args) {
		Brad211 obj1 = new Brad211() { //有抽象方法的類別，無法直接建立出實體
			@Override
			void m2() {
				System.out.println("Brad211:m2()");
			}
		};
		obj1.m1();

		Brad211 obj2 = new Brad212();
		obj2.m1();obj2.m2();
	}
}
		//有定義無實作，具有抽象方法的Abstract類別
		abstract class Brad211 {
		void m1() {System.out.println("Brad211:m1()");}
		abstract void m2();  //抽象的方法Abstract
		}

		class Brad212 extends Brad211{
			void m2() {System.out.println("Brad212:m2()");}
		}
		
		class Brad213 extends Brad211{
			void m2() {System.out.println("Brad213:m2()");}
		}