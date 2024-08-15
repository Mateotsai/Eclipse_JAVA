package tw.mateo0812;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class lesson02_HTTP_PDF {

	public static void main(String[] args) {
		try { 					
			FileOutputStream fout = new FileOutputStream("dir2/gamer.pdf");
			//線上網頁轉PDF的網站PDFMYURL，透過他轉網頁PDF
			URL url = new URL("https://pdfmyurl.com/?url=https://www.gamer.com.tw");//?代表操作
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());

			byte[] buf = new byte[4*1024]; int len;
			while( (len = bin.read(buf)) != -1) {
				fout.write(buf, 0 , len);
			}

			bin.close();

			fout.flush();
			fout.close();
			System.out.println("PDf download finished!");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
