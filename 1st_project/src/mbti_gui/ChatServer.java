package mbti_gui;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	//Field//
	ServerSocket server;
	ArrayList<DataOutputStream> msg_list = new ArrayList<DataOutputStream>();
	
	
	//Constructor
	public ChatServer() {
		try {
			server = new ServerSocket(9000);
			System.out.println("서버실행");
			
			while(true) {
				Socket s = server.accept();
				ServerThread st = new ServerThread(s);
				st.start();
				
				msg_list.add(st.dos);
				new ChatClient();
				System.out.println("클라이언트 접속");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	public void broadcasting(String message) {
		try {
			for(DataOutputStream data : msg_list) {
				data.writeUTF(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	class ServerThread extends Thread{
		DataInputStream dis;
		DataOutputStream dos;
		
		public ServerThread(Socket s) {
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					broadcasting(dis.readUTF());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
