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
	
	//�׼� �̺�Ʈ ó��
	public void actionPerformed(ActionEvent e) {
		Object obj1 = e.getSource();
		
		if(obj1 == ui.join) {
			if(form_check()) {
				//JTextField ����ȯ
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
					JOptionPane.showMessageDialog(null, Commons.getMsg("ȸ�������� �Ϸ�Ǿ����ϴ�."));
					for(Object obj2 : ui.list) {
						JTextField tf = (JTextField)obj2;
						tf.setText("");
					}	
					ui.f.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, Commons.getMsg("ȸ�������� �ٽ� �������ּ���."));
				}
			}
		}else {
			for(Object obj2 : ui.list) {
				JTextField tf = (JTextField)obj2;
				tf.setText("");
			}	
		}
	}
	/**�� üũ**/
	public boolean form_check() {
		boolean result = false;
		
		for(int i=0;i<ui.list.size();i++) {
			JTextField tf = (JTextField)ui.list.get(i);
			if(tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg(ui.namelistCheck[i]+"(��)�� �Է����ּ���."));
				tf.requestFocus();
				i = ui.list.size();
			}else if(i == ui.list.size()-1) {
				result = true;
			}
		
		}
		return result;
	}
}
