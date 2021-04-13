package mbti_gui;

import java.net.Socket;

public class ChatClient {
	//Field
	Socket s;
	
	//Constructor
	public ChatClient() {
		new ChatUI();
		try {
			while(true) {
				s = new Socket("localhost", 5000);
				new ClientThread(s).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Method
	class ClientThread extends Thread{
		public ClientThread(Socket s) {
			
		}
	}
	
}
