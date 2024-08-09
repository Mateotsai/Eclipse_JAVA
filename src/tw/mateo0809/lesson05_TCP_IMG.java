package tw.mateo0809;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class lesson05_TCP_IMG {

	public static void main(String[] args) {
		File source = new File("dir1/test1.jpg");
		try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
				Socket client = new Socket(InetAddress.getByName("10.0.100.157"),7777);
			BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream())){
			
			byte[] buf = new byte[(int)source.length()];
			bin.read(buf);
			bout.write(buf);
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
