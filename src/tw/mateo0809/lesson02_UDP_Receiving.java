package tw.mateo0809;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class lesson02_UDP_Receiving {
	
	public static void main(String[] args) {
		byte[] buff = new byte[4*1024];
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			DatagramPacket packet = new DatagramPacket(buff, buff.length);
			System.out.println("before");
			socket.receive(packet);
			System.out.println("after");
			socket.close();
			
			String urIP = packet.getAddress().getHostAddress();
			byte[] data = packet.getData();
			int len = packet.getLength();
			
			System.out.println("receive OK");
			System.out.printf("%s => %s\n", urIP, new String(data,0,len));
			System.out.println(data.length);
			System.out.println(len);
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
