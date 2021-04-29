package mbti_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mbti_system.MbtiMgmSystem;

public class MbtiMainUIEvent implements ActionListener {
	// Field
	MbtiMainUI main;
	AdminMainUI adminmain;

	public static final int ADMIN = 0;
	public static final int USER = 1;

	// Constructor
	public MbtiMainUIEvent(MbtiMainUI main) {
		this.main = main;
	}

	// Method
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == main.btn_login || obj == main.id_tf || obj == main.pw_tf) {
			loginUI_proc();
		} else if (obj == main.btn_join) {
			new JoinUI(main);
		} else if (obj == main.buttonlist.get(0)) {
			new MainUI(main);
			main.secondFrame.setTitle("MBTI WORLD");
		} else if (obj == main.buttonlist.get(1)) {
			new CreateUI(main);
			main.secondFrame.setTitle("캐릭터 생성");
		} else if (obj == main.buttonlist.get(2)) {
			new ChatUI(main);
		} else if (obj == main.buttonlist.get(3)) {
			new BoardUI(main);
			main.secondFrame.setTitle("게시판");
		} else if (obj == main.buttonlist.get(4)) {
			new MypageUI(main);
			main.secondFrame.setTitle("마이페이지");
		} else if (obj == main.buttonlist.get(5)) {
			int confirm = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
			if (confirm == 0) {
				JOptionPane.showMessageDialog(null, "다음에 또 만나요 :)");
				System.exit(0);
			}
		}

	}

	/** 로그인 이벤트 **/
	public void loginUI_proc() {
		if (main.id_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
			main.id_tf.requestFocus();
		} else if (main.pw_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
			main.pw_tf.requestFocus();
		} else {  //#############################
			// 로그인 체크 : system.loginCheck(아이디,비밀번호)
			int result = main.system.loginCheck(main.id_tf.getText(), main.pw_tf.getText());
			if (result == USER) {
				JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
				main.firstFrame.dispose();
				main.secondView();
				main.btn_login.setText("LOGOUT");
				MbtiMgmSystem.LOGIN_RESULT = true;
			} else if (result == ADMIN) {
				main.firstFrame.dispose();
				new AdminMainUI();
			} else {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다.");
				main.id_tf.setText("");		main.pw_tf.setText("");
			}
		}

	}
}
