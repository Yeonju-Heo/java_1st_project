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
	String join_mbti;
	
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
					if(tf == ui.mbtilist) {
					  JTextField jtf = new JTextField(join_mbti);
	                  jlist.add(jtf);   
					}else {
						JTextField jtf = (JTextField)tf;
		                jlist.add(jtf);   
					}
				}
				UserVO uservo = new UserVO();
				MbtiVO mbtivo = new MbtiVO();
				uservo.setU_id(jlist.get(0).getText());
				uservo.setU_pass(jlist.get(1).getText());
				uservo.setU_cpass(jlist.get(2).getText());
				uservo.setU_mbti(jlist.get(3).getText());
				mbtivo.setMbti_type(jlist.get(3).getText());
				
				boolean result = main.system.join(uservo);
				boolean id_check = main.system.idCheck(ui.tf.getText());
				if(result == true) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입이 완료되었습니다."));
					for(Object obj2 : ui.obj_list) {
						if(obj2 == ui.mbtilist) {
							ui.mbtilist.setSelectedIndex(0);
						}else {
							JTextField tf = (JTextField)obj2;
							tf.setText("");
						}
					}	
					ui.f.setVisible(false);
					
				}else if(id_check == true){
					JOptionPane.showMessageDialog(null, Commons.getMsg("아이디 중복 확인을 해주세요."));
					
				}else {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입을 다시 진행해주세요."));
				}
			} 
		}else if(obj == ui.cancel_btn){
			System.out.println("cancel");
			for(Object obj2 : ui.obj_list) {
				if(obj2 == ui.mbtilist) {
					ui.mbtilist.setSelectedIndex(0);
				}else {
					JTextField tf = (JTextField)obj2;
					tf.setText("");
				}
			}	
		}
	}
	
	
	/** 폼 체크 **/
	public boolean form_check() {
		boolean result = false;
		
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
			cb.requestFocus();
		}else if(!pf.getText().trim().equals(cpf.getText())) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("비밀번호가 일치하지 않습니다."));
		}else {
			join_mbti = (String) cb.getSelectedItem();
			result = true;
		}
		return result;
	}
}
