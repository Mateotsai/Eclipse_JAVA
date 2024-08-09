package tw.mateo0808;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class lesson01_Network {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("www.google.com");
			//inetaddress沒有建立物件實體，僅提供STATIC方法
			System.out.println(ip);
		} catch (UnknownHostException e) {	
			System.out.println(e);
		}   
			
				

	}

}
