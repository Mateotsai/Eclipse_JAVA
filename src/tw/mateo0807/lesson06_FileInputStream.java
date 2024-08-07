package tw.mateo0807;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class lesson06_FileInputStream {

	public static void main(String[] args) {
		try {
		FileInputStream fin = new FileInputStream("./dir1/file1.txt");
//		int c =fin.read();
//		System.out.println((char) c); //72，字元代表"H"，檔案內的第一個字元，讀取到最後回傳-1
		
		int c;
		while ( (c = fin.read()) != -1) {
			System.out.print((char)c);
		}
		

		
		
		fin.close();
		System.out.println("OK! find file1");
		
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
		}
	}

}
