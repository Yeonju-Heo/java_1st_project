package mbti_gui;

import java.io.ObjectInputStream;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

import mbti_vo.MessageVO;

public class ClientThread extends Thread{
		ObjectInputStream ois;
		JTextArea content;
		JList user_list;
		JLabel user_count;
		
		public ClientThread(ObjectInputStream ois, 
				JTextArea content, JList userlist, JLabel usercount) {
			
			try {
				this.ois = ois;
				this.content = content;
				this.user_list = userlist;
				this.user_count = usercount;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		@Override
		public void run() {
			try {
				
				//데이터 수신작업
				while(true) {
					MessageVO vo = (MessageVO)ois.readObject();
					content.append(vo.getMsg() + "\n");//messagevo로부터 받아온 내용을 ui의 content에 입력
					user_list.setListData(vo.getUser_list());//접속자 리스트
					user_count.setText(String.valueOf(vo.getUser_list().size()) + "명 접속중");//몇명 접속했는지
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
