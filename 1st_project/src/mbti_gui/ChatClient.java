package mbti_gui;



import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import mbti_system.MbtiMgmSystem;
import mbti_vo.MbtiVO;
import mbti_vo.MessageVO;
import mbti_vo.UserVO;

public class ChatClient {
	//Field
	MbtiMainUI main;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	ArrayList<ObjectOutputStream> user_list = new ArrayList<ObjectOutputStream>();
	ChatUI cc;
	
	//Constructor
	public ChatClient(MbtiMainUI main) {
		try {
			this.main = main;
			Socket s = new Socket("localhost", 9000);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			//connect 
			MessageVO vo = new MessageVO();
			UserVO uvo = main.system.getChatUserDataSelect(main.id_tf.getText());
			MbtiVO mvo = main.system.getMbti(uvo);
			vo.setName(uvo.getU_id()); //uvo에서 id불러오기 그걸 메시지 vo에 저장(입장)
			vo.setMbti(mvo.getMbti_type());;//mvo에서 mbti불러오기 그걸 메시지 vo에 저장
			vo.setStatus(MessageVO.CONNECT); //연결상태전송
			oos.writeObject(vo); //전송
			
			System.out.println("클라이언트 연결");
			
			
		} catch (Exception e) {
			
		}
		
	}
	
	//Method
}
