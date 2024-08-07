package tw.mateo0807;

import java.io.*;
import java.io.FileReader;

public class lesson11_AutoClose {

	public static void main(String[] args) {
		//try的參數內放進讀取內容，達成自動關閉功能
		try (FileReader fr = new FileReader("./dir1/file2.txt");){
			int c;
			while((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			
			System.out.println("OK");
		} catch (IOException e) {
			System.out.println("傳送失敗" + e);
	
		}

	}

}
