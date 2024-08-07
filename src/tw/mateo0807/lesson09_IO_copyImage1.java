package tw.mateo0807;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class lesson09_IO_copyImage1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/test2.jpg");
			FileInputStream fin = new FileInputStream("dir1/test1.jpg");
		
			int b;
			while((b = fin.read()) != -1 ) {
				fout.write(b);
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("複製完畢");
			System.err.println("花費時間" + System.currentTimeMillis());
		} catch (IOException e) {
			System.out.println("複製失敗" + e);
		}
		

	}

}
