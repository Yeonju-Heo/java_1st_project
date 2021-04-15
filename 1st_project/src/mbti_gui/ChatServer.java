package mbti_gui;


import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import mbti_vo.MessageVO;

public class ChatServer {
	//Field
	ServerSocket server;
	static ArrayList<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
	static Vector<String> user_list = new Vector<String>();
	
	//Constructor
	public ChatServer() {
		try {
			server = new ServerSocket(9000);
			System.out.println("서버실행");
			
			while(true) {
				Socket s = server.accept();
				ServerThread st = new ServerThread(s);
				st.start();
				
				list.add(st.oos);
				System.out.println("클라이언트 접속");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	synchronized static public void broadcasting(MessageVO vo) {
		try {
			if(vo.getStatus() == MessageVO.CONNECT) {
				user_list.add(vo.getName() + "(" + vo.getMbti() + ")" );
				Vector<String> copy_list = (Vector<String>)user_list.clone();
				vo.setUser_list(copy_list);
				vo.setMsg("---------------->>" + 
						vo.getName() + "(" + vo.getMbti() + ")" + "님이 입장하셨습니다.");
				
			}else if(vo.getStatus() == MessageVO.TALK) {
				Vector<String> copy_list = (Vector<String>)user_list.clone();
				vo.setUser_list(copy_list);
				vo.setMsg(vo.getName() + "(" + vo.getMbti() + ")" + " ▶ " + vo.getMsg());
				
			}else if(vo.getStatus() == MessageVO.EXIT) {
				int index = user_list.indexOf(vo.getName());
				ObjectOutputStream remove = (ObjectOutputStream)list.get(index);
				Iterator<ObjectOutputStream> ie = list.iterator();
				while(ie.hasNext()) {
					if(ie.next() == remove) ie.remove();
				}
				
				user_list.remove(vo.getName());
				Vector<String> copy_list = (Vector<String>)user_list.clone();
				vo.setUser_list(copy_list);
				vo.setMsg("---------------->>" + 
						vo.getName() + "(" + vo.getMbti() + ")" + "님이 나가셨습니다.");
				
			}
			
			for(ObjectOutputStream oos : list) {
				oos.writeObject(vo);
			}
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
