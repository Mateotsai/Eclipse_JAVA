package tw.mateo0807;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class lesson09_IO_copyImage2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			byte[] buf = new byte[4*1024];
			
			File s = new File("dir1/test1.jpg");
			FileInputStream fin = new FileInputStream(s);			
			FileOutputStream fout = new FileOutputStream("dir2/test2.jpg");
			
			int len;
			while((len = fin.read(buf)) != -1 ) {
				fout.write(buf, 0 ,len);
			}
			fin.close();
			fout.flush();
			fout.close();
			
			long seconds = start / 1000;
			long minutes = seconds / 60;
			seconds = seconds % 60;
			
			System.out.println("複製完畢");
			System.out.printf("花費時間: %d分%d秒", minutes, seconds);
		} catch (IOException e) {
			System.out.println("複製失敗" + e);
		}
		

	}


}


