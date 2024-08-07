package tw.mateo0807;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class lesson06_FileInputStream2 {

	public static void main(String[] args) {
		try {
		File source = new File("./dir1/file2.txt");	
		FileInputStream fin = new FileInputStream(source);

		int len;
		byte[] buff = new byte[(int)source.length()];  //一個中文字佔據3個byte
		fin.read(buff);
		System.out.println(new String(buff));
		
		//while((len = fin.read(buff)) != -1) {
		//System.out.print(new String(buff,0,len));
		//}
		

		
		
		fin.close();
		System.out.println("\nOK! find file2");
		
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
		}
	}

}
