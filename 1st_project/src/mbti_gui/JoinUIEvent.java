package mbti_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JoinUIEvent extends WindowAdapter implements ActionListener {
	//Field
	JoinUI ui;
	MainUI main;
	
	//Constructor
	public JoinUIEvent() {}
	public JoinUIEvent(JoinUI ui) {
		this.ui = ui;
	}
	public JoinUIEvent(JoinUI ui, MainUI main) {
		this.ui = ui;
		this.main = main;
	}
	
	//액션 이벤트 처리
	public void actionPerformed(ActionEvent e) {
		Object obj1 = e.getSource();
		
		if(obj1 == ui.join) {
			if(form_check()) {
				//JTextField 형변환
				ArrayList<JTextField> jlist = new ArrayList<JTextField>();
				for(Object tf : ui.list) {
					JTextField jtf = (JTextField)tf;
					jlist.add(jtf);
				}
				MemberVO member = new MemberVO();
				member.setId(jlist.get(0).getText());
				member.setPw(jlist.get(1).getText());
				member.setCpw(jlist.get(2).getText());
				member.setName(jlist.get(3).getText());
				member.setEmail(jlist.get(4).getText());
				
//				boolean result = main.system.getMemberlist().add(member);
				boolean result = main.system.join(member);
				if(result == true) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입이 완료되었습니다."));
					for(Object obj2 : ui.list) {
						JTextField tf = (JTextField)obj2;
						tf.setText("");
					}	
					ui.f.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입을 다시 진행해주세요."));
				}
			}
		}else {
			for(Object obj2 : ui.list) {
				JTextField tf = (JTextField)obj2;
				tf.setText("");
			}	
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
