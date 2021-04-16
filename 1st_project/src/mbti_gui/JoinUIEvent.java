package mbti_gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JoinUIEvent extends WindowAdapter implements ActionListener {
	//Field
	JoinUI ui;
	MbtiMainUI main;
	
	//Constructor
	public JoinUIEvent() {}
	public JoinUIEvent(JoinUI ui) {
		this.ui = ui;
	}
	public JoinUIEvent(JoinUI ui, MbtiMainUI main) {
		this.ui = ui;
		this.main = main;
	}
	
	//액션 이벤트 처리
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == ui.join_btn) {
			System.out.println("회원가입");
//			if(form_check()) {
//				//JTextField 형변환
//				ArrayList<JTextField> jlist = new ArrayList<JTextField>();
//				for(Object tf : ui.list) {
//					JTextField jtf = (JTextField)tf;
//					jlist.add(jtf);
//				}
//				MemberVO member = new MemberVO();
//				member.setId(jlist.get(0).getText());
//				member.setPw(jlist.get(1).getText());
//				member.setCpw(jlist.get(2).getText());
//				member.setName(jlist.get(3).getText());
//				member.setEmail(jlist.get(4).getText());
//				
////				boolean result = main.system.getMemberlist().add(member);
//				boolean result = main.system.join(member);
//				if(result == true) {
//					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입이 완료되었습니다."));
//					for(Object obj2 : ui.list) {
//						JTextField tf = (JTextField)obj2;
//						tf.setText("");
//					}	
//					ui.f.setVisible(false);
//				}else {
//					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입을 다시 진행해주세요."));
//				}
//			}
		}else if(obj == ui.cancel_btn){
			System.out.println("입력취소");
//			for(Object obj2 : ui.list) {
//				JTextField tf = (JTextField)obj2;
//				tf.setText("");
//			}	
		}else if(obj == ui.id_check_btn) {
			System.out.println("로그인 중복 체크");
		}
	}
	/**폼 체크**/
	public boolean form_check() {
		boolean result = false;
		
		for(int i=0;i<ui.list.size();i++) {
			JTextField tf = (JTextField)ui.list.get(i);
			if(tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg(ui.namelistCheck[i]+"(을)를 입력해주세요."));
				tf.requestFocus();
				i = ui.list.size();
			}else if(i == ui.list.size()-1) {
				result = true;
			}
		
		}
		return result;
	}
	
}
