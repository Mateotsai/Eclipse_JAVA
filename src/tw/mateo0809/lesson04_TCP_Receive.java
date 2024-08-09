package tw.mateo0809;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class lesson04_TCP_Receive {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
			
			
			String urIP = socket.getInetAddress().getHostAddress();
			System.out.println(urIP + " => ");
			
			String line;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			String mesg = sb.toString();
			System.out.println(mesg);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
