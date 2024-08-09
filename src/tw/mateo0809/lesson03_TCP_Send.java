package tw.mateo0809;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class lesson03_TCP_Send {

	public static void main(String[] args) {
		
		try (Socket client = new Socket(InetAddress.getByName("10.0.100.157"),9999);
			BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());){
			
			String msg = "Hello\n老師麻煩請Git\nOrz....";
			bout.write(msg.getBytes());

			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}

}
