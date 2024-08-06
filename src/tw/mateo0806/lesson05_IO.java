package tw.mateo0806;

import java.io.File;

public class lesson05_IO {

	public static void main(String[] args) {
		File f1 = new File("D:\\dir2");
		File f2 = new File("D:\\test1");
		if(f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	

		
		File nowDir = new File(".");  //.代表現在所在的資料夾位置
		System.out.println(nowDir.getAbsolutePath());
   }
}