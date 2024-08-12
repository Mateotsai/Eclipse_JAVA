package tw.mateo0812;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class lesson01_HTTP_downloadImage {

	public static void main(String[] args) {
		
			
			try { 					
				FileOutputStream fout = new FileOutputStream("dir2/yahoo.jpg");
				
				URL url = new URL("https://s.yimg.com/ny/api/res/1.2/EdZ5KfzLgoDPxr4zQtcUxg--/YXBwaWQ9aGlnaGxhbmRlcjt3PTk2MDtoPTY0MDtjZj13ZWJw/https://s.yimg.com/os/creatr-uploaded-images/2024-08/60c73330-5673-11ef-bfdf-5b5eb3476ca8");//頁面原始碼
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			byte[] buf = new byte[4*1024]; int len;
			while( (len = bin.read(buf)) != -1) {
				fout.write(buf, 0 , len);
			}
			
			bin.close();
			
			fout.flush();
			fout.close();
			System.out.println("download finished!");
			
			} catch (Exception e) {
				System.out.println(e);
			}



	}

}
