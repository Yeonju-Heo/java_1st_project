package mbti_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mbti_vo.MbtiVO;
import mbti_vo.UserVO;

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
	
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == ui.id_check_btn) {
			boolean result = main.system.idCheck(ui.tf.getText());
			if(ui.tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("아이디를 입력해주세요."));
			}else if(result == true){
				JOptionPane.showMessageDialog(null, Commons.getMsg("이미 사용중인 아이디입니다."));
				ui.tf.setText("");
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("사용 가능한 아이디입니다."));
			}
		}else if(obj == ui.join_btn) {
			if(form_check()) {
				ArrayList<JTextField> jlist = new ArrayList<JTextField>();
				for(Object tf : ui.list) {
					JTextField jtf = (JTextField)tf;
					jlist.add(jtf);
				}
				UserVO user = new UserVO();
				MbtiVO mbti = new MbtiVO();
				user.setU_id(jlist.get(0).getText());
				user.setU_pass(jlist.get(1).getText());
				user.setU_cpass(jlist.get(2).getText());
				user.setU_mbti(jlist.get(3).getText());
				mbti.setMbti_type(jlist.get(3).getText());
				
				System.out.println("join formcheck");
				boolean result = main.system.join(user);
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
		}else if(obj == ui.cancel_btn){
			System.out.println("cancel");
			for(Object obj2 : ui.list) {
				JTextField tf = (JTextField)obj2;
				tf.setText("");
			}	
		}
//		else {
//			JComboBox jcb = (JComboBox)e.getSource();
//			if(jcb == ui.mbtilist) {
//				System.out.println(jcb.getSelectedItem());
//				jcb.getSelectedItem();
//				if(jcb.getSelectedItem().equals("== CHOICE ==")) {
//					System.out.println("please choice select");
//				}
//			}
//		}
	}
	
	
	/** 폼 체크 **/
	public boolean form_check() {
		boolean result = false;
		
		for(int i=0;i<ui.list.size();i++) {
			JTextField tf = (JTextField)ui.list.get(i);
//			String str = (String)ui.list.get(i);
//			String str = (String)ui.mbtilist.getSelectedItem().toString();
//			&& ui.mbtilist.getSelectedItem().equals("== CHOICE ==")
//			|| str.equals("== CHOICE ==")
			if(tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg(ui.namelistCheck[i]+" 을(를) 입력해주세요."));
				tf.requestFocus();
				i = ui.list.size();
//			}else if(ui.mbtilist.getSelectedItem().equals("== CHOICE ==")) {
//				JOptionPane.showMessageDialog(null, Commons.getMsg("MBTI를 선택해주세요."));
//				ui.mbtilist.requestFocus();
//				
			}else if(i == ui.list.size()-1) {
				result = true;
			}
		
		}
		
//		if()
		
		
		
		return result;
	}

	
}
