package tw.mateo0807;

import java.io.IOException;
import java.io.FileOutputStream;

public class lesson08_FileOutputStream {

	public static void main(String[] args) {
		String mesg = "Hello,資展\n";
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file3.txt", true);
				fout.write(mesg.getBytes());
				fout.flush();
				fout.close();
			System.out.println("成功寫入文件");
		} catch (IOException e) {
			System.out.println(e);
		} 
		
	}

}
