package tw.mateo.webSocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {
	private static HashSet<Session> sessions; //利用set的特性檢查重複
	private static HashMap<String, Session> users;
	public MyServer() {
		System.out.println("MyServer");		
		sessions = new HashSet<Session>();
		users = new HashMap<String, Session>();

	}	
		
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("OnOpen");
		if (sessions.add(session)) {
			users.put(session.getId(), session);
			System.out.println("Count:" + sessions.size());
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println("OnMessage" + mesg);
		
		for (Session user:sessions) {
			try {
				user.getBasicRemote().sendText(mesg);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		users.remove(session.getId());
		sessions.remove(session);
		System.out.println("OnClose" + sessions.size());
	}
	
	@OnError
	public void onError(Session session, Throwable t){
		System.out.println("OnError");
	}
	
}
