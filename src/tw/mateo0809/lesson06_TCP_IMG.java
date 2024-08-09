package tw.mateo0809;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.BufferOverflowException;

public class lesson06_TCP_IMG {

	public static void main(String[] args) {
		try (
			ServerSocket server = new ServerSocket(7777);
			Socket socket = server.accept();
			){
			
			
			String urIP = socket.getInetAddress().getHostAddress();
			
			
			String fname = String.format("dir2/%s.jpg, urIP");
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fname));
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
			byte[] buf = new byte[4*1024];
			int len;
			while((len = bin.read(buf)) != -1) {
				bout.write(buf,0,len);
			}
			
			
			bout.flush();
			bout.close();
			System.out.println(urIP + " => OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
