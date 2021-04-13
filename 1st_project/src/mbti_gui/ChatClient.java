package mbti_gui;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatClient {
	//Field//
	ChatUI cu = new ChatUI();
	Socket s;
	DataOutputStream dos;
	DataInputStream dis;
	
	//Constructor
	public ChatClient() {
		try {
			while(true) {
				s = new Socket("localhost", 5000);
				dos = new DataOutputStream(s.getOutputStream());
				dis = new DataInputStream(s.getInputStream());
				new ChatUI();//UI호출
				new ClientThread(s).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Method
	class ClientThread extends Thread{
		public ClientThread(Socket s) {
			//데이터 수신작업
			try {
				while(true) {
					cu.chat_content.append(dis.readUTF() + "\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			
		}
	}
	
}
