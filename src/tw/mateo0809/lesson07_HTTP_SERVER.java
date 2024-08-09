package tw.mateo0809;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class lesson07_HTTP_SERVER {

	public static void main(String[] args) {
		try (
				ServerSocket server = new ServerSocket(80);
				Socket socket = server.accept();)
		{
			System.out.println("OK80");
				
			} catch (Exception e) {
			}

		}

	}

