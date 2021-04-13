package mbti_gui;

import java.net.ServerSocket;

public class ChatServer {
	//Field
	ServerSocket server;
	
	
	//Constructor
	public ChatServer() {
		try {
			server = new ServerSocket(9000);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	class ServerThread extends Thread{
		
	}
}
