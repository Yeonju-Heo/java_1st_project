package mbti_gui;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import mbti_vo.MessageVO;

public class ChatClient {
	//Field
	ObjectOutputStream oos;
	ObjectInputStream ois;
	ArrayList<ObjectOutputStream> user_list = new ArrayList<ObjectOutputStream>();
	ChatUI cc;
	String name = "mbti";
	
	//Constructor
	public ChatClient() {
		try {
			Socket s = new Socket("localhost", 9000);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			//connect 
			MessageVO vo = new MessageVO();
			vo.setName(name); //이름을 vo에 저장
			vo.setStatus(MessageVO.CONNECT); //상태 저장
			oos.writeObject(vo); //vo를 전송
			
			System.out.println("연결!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Method
}
