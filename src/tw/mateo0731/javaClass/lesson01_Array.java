package tw.mateo0731.javaClass;

public class lesson01_Array {
	//一維陣列
	public static void main(String[] args) {
		int[] arr1;
		arr1 = new int[3]; //變數第一次給值，便完成初始化!
		//宣告arr1[0] arr1[1] arr1[2]三個物件佔據在記憶體的位置
		System.out.println(arr1[0]); //0，記憶體已被佔據
		System.out.println(arr1[1]); //0，記憶體已被佔據
		System.out.println(arr1[2]); //0，記憶體已被佔據
		System.out.println(arr1.length); //3，長度為3個值(0,1,2)
		System.out.println("-------");
		arr1[1] = 100;
		arr1[2] = 123;
		arr1[0] = 44;
		for(int i = 0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("-------");
		
		for (int v : arr1) {
			System.out.println(v);
		}
		System.out.println("-------");
		
		
	}

}
