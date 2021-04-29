package mbti_gui;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import mbti_vo.MessageVO;

public class ServerThread extends Thread{
	ChatServer cs = new ChatServer();
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public ServerThread(Socket s) {
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			
		} catch (Exception e) {
			
		}
		
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				MessageVO vo = (MessageVO)ois.readObject();
				ChatServer.broadcasting(vo);
			}
		} catch (Exception e) {
			
		}
	}
	
}
