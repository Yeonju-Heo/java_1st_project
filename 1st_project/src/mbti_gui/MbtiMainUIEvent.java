package mbti_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class MbtiMainUIEvent implements ActionListener{
	//Field
	MbtiMainUI main;
	
	//Constructor
	public MbtiMainUIEvent(MbtiMainUI main) {
		this.main = main;
	}
	
	//Method
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == main.btn_login || obj == main.id_tf || obj == main.pw_tf ) {
			loginUI_proc();
		}else if(obj == main.btn_join) {
			new JoinUI(main);
		}else if(obj == main.buttonlist.get(0)) {
			new MainUI(main);
			main.secondFrame.setTitle("MBTI WORLD");
		}else if(obj == main.buttonlist.get(1)) {
			new CreateUI(main);
			main.secondFrame.setTitle("캐릭터 생성");
		}else if(obj == main.buttonlist.get(2)) {
			new ChatUI();
		}else if(obj == main.buttonlist.get(3)) {
			new BoardUI(main);
			main.secondFrame.setTitle("게시판");
		}else if(obj == main.buttonlist.get(4)) {
			new MypageUI(main);
			main.secondFrame.setTitle("마이페이지");
		}else if(obj == main.buttonlist.get(5)) {
			int confirm = JOptionPane.showConfirmDialog(null, Commons.getMsg("종료하시겠습니까?"));
			if(confirm == 0) System.exit(0);
		}
		
	}
	
	/** 로그인 이벤트 **/
	public void loginUI_proc() {
		if(main.id_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("아이디를 입력해주세요"));
			main.id_tf.requestFocus();
		}else if(main.pw_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("비밀번호를 입력해주세요"));
			main.pw_tf.requestFocus();
		}
//		else {
//			//로그인 체크 : system.loginCheck(아이디,비밀번호)
//			boolean result = main.system.loginCheck(id_tf.getText(),pw_tf.getText());
//			if(result == true) {
//				JOptionPane.showMessageDialog(null, Commons.getMsg("로그인 되었습니다."));
//				new FirstMainPageUI(main);
//				main.btn_login.setText("LOGOUT");
//				MbtiMgmSystem.LOGIN_RESULT = true;
//			}else {
//				JOptionPane.showMessageDialog(null, Commons.getMsg("아이디와 비밀번호가 일치하지 않습니다."));
//			}
		}
	
	

}
