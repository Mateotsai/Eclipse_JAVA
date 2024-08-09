package tw.mateo0809;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class lesson01_UDP_Sending {

	public static void main(String[] args) {
		//TCP連接導向(會確認是否有收到，傳回ACK訊息)
		//UDP非連接導向(只傳遞不確認，網路遊戲通常用這個，效能較好，調偵 == 資料遺失)
		//網路阜號，網頁通常80號
		
		//UDP發送方法
		String mesg = "OK";
		byte[] mesgBuf = mesg.getBytes();
		
		try {
			DatagramSocket socket = new DatagramSocket(); 
			DatagramPacket packet = new DatagramPacket(mesgBuf, mesgBuf.length,
				InetAddress.getByName("10.0.100.157"),8888);
	
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
