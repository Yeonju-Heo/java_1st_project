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
				for(Object tf : ui.obj_list) {
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
				boolean result2 = main.system.idCheck(ui.tf.getText());
				if(result == true) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입이 완료되었습니다."));
					for(Object obj2 : ui.obj_list) {
						JTextField tf = (JTextField)obj2;
						tf.setText("");
					}	
					ui.f.setVisible(false);
				}
				else if(result2 == true){
					JOptionPane.showMessageDialog(null, Commons.getMsg("아이디 중복 확인을 해주세요."));
				}
				else {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입을 다시 진행해주세요."));
				}
			} 
		}else if(obj == ui.cancel_btn){
			System.out.println("cancel");
			for(Object obj2 : ui.obj_list) {
				JTextField tf = (JTextField)obj2;
				tf.setText("");
			}	
		}
//		else {
//			ui.mbtitf.setText((String)ui.mbtilist.getSelectedItem());
//			JComboBox jcb = (JComboBox)e.getSource();
//			if(jcb == ui.mbtilist) {
//				String mbti_str = (String)ui.mbtilist.getSelectedItem();
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
//		for(int i=0;i<ui.obj_list.size();i++) {
//			JTextField tf = (JTextField)ui.tf_list.get(i);
//			String str = (String)ui.str_list.get(i);
//			if(tf.getText().equals("") || str.equals("== CHOICE ==")) {
//				JOptionPane.showMessageDialog(null, Commons.getMsg(ui.namelistCheck[i]+" 을(를) 입력해주세요."));
//				tf.requestFocus();
//				i = ui.tf_list.size();
////			}else if(str.equals("== CHOICE ==")) {
////				JOptionPane.showMessageDialog(null, Commons.getMsg("MBTI를 선택해주세요."));
////				ui.mbtilist.requestFocus();
////				
//			}else if(i == ui.obj_list.size()-1) {
//				result = true;
//			}
//		
//		}
		/*
		arraylist에 콤보박스를 getSelectedItem으로 넣은 뒤, 
		폼체크를 이렇게 하고 실행해보면  
		Exception in thread "AWT-EventQueue-0" java.lang.ClassCastException: 
		class java.lang.String cannot be cast to class javax.swing.JTextField
		오류가 뜬다. String str로 형변환한 부분을 없애도 저런 오류가 뜬다. 
		arraylist<object> 형식으로 해도 텍스트필드와 스트링값이 같이 들어가고 같이 불러올 순 없나?!
		 */
		JTextField tf = (JTextField)ui.obj_list.get(0);
		JTextField pf = (JTextField)ui.obj_list.get(1);
		JTextField cpf = (JTextField)ui.obj_list.get(2);
		JComboBox cb = (JComboBox)ui.obj_list.get(3);
		
		if(tf.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("아이디를 입력해주세요."));
			ui.tf.requestFocus();
		}else if(pf.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("비밀번호를 입력해주세요."));
			ui.pf.requestFocus();
		}else if(cpf.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("비밀번호확인을 입력해주세요."));
			ui.cpf.requestFocus();
		}else if(cb.getSelectedItem().equals("== CHOICE ==")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("MBTI를 선택해주세요."));
			if(cb.getSelectedItem().equals("== CHOICE ==") == false) {
				result = true;
			}
		}
//		else if(str.matches("== CHOICE ==") == false) {
//			result = true;
//		}
		
		return result;
	}

	
}
