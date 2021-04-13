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
		}else if(obj == main.buttonlist.get(1)) {
			new CreateUI(main);
		}else if(obj == main.buttonlist.get(2)) {
			new ChatUI();
		}else if(obj == main.buttonlist.get(3)) {
			new BoardUI(main);
		}else if(obj == main.buttonlist.get(4)) {
			System.out.println("����������");
		}else if(obj == main.buttonlist.get(5)) {
			int confirm = JOptionPane.showConfirmDialog(null, Commons.getMsg("�����Ͻðڽ��ϱ�?"));
			if(confirm == 0) System.exit(0);
		}
		
	}
	
	/** �α��� �̺�Ʈ **/
	public void loginUI_proc() {
		if(main.id_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("���̵� �Է����ּ���"));
			main.id_tf.requestFocus();
		}else if(main.pw_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("��й�ȣ�� �Է����ּ���"));
			main.pw_tf.requestFocus();
		}
//		else {
//			//�α��� üũ : system.loginCheck(���̵�,��й�ȣ)
//			boolean result = main.system.loginCheck(id_tf.getText(),pw_tf.getText());
//			if(result == true) {
//				JOptionPane.showMessageDialog(null, Commons.getMsg("�α��� �Ǿ����ϴ�."));
//				new FirstMainPageUI(main);
//				main.btn_login.setText("LOGOUT");
//				MbtiMgmSystem.LOGIN_RESULT = true;
//			}else {
//				JOptionPane.showMessageDialog(null, Commons.getMsg("���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�."));
//			}
		}
	
	

}
