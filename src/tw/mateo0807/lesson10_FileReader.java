package tw.mateo0807;

import java.io.*;
import java.io.FileReader;

public class lesson10_FileReader {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("./dir1/file2.txt");
			int c;
			while((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			
			fr.close();
			System.out.println("OK");
		} catch (IOException e) {
			System.out.println("傳送失敗" + e);
	
		}

	}

}
