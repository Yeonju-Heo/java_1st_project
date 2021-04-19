package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 

public class JoinUI {
	//Field
	MbtiMainUI main;
	JFrame f;
	Panel label_panel, tf_panel, check_panel,id_check_panel, btn_panel;
	JButton id_check_btn, mbti_check_btn, join_btn, cancel_btn;
	Label textlabel, fieldlabel;
	String namelist[] = {"아이디","비밀번호","비밀번호확인","MBTI"};
	String namelistCheck[] = {"아이디","비밀번호","비밀번호확인","MBTI"};
	JTextField tf;
	ArrayList<Object> list = new ArrayList<Object>();
	String[] mbtitype = {"== CHOICE ==","INFJ","INTJ","INFP","INTP","ISTJ","ISFJ","ISTP","ISFP","ENFP","ENTP","ENFJ","ENTJ","ESTP","ESFP","ESTJ","ESFJ"};
	JComboBox<String> mbtilist; 
	
	//Constructor
	public JoinUI() {
		init();
	}
	
	public JoinUI(MbtiMainUI main) {
		this.main = main;
		init();
	}
	//Method
	public void init() {
		f = new JFrame("회원가입");
		
		label_panel = new Panel(new GridLayout(4,1));
		tf_panel = new Panel(new GridLayout(4,1));
		check_panel = new Panel(new BorderLayout());
		id_check_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		btn_panel = new Panel();
		
		id_check_btn = new JButton("중복 확인");
		mbti_check_btn = new JButton("간단 검사");
		join_btn = new JButton("회원가입");
		cancel_btn = new JButton("입력취소");
		
		id_check_btn.setFont(Commons.getFont());
		mbti_check_btn.setFont(Commons.getFont());
		join_btn.setFont(Commons.getFont());
		cancel_btn.setFont(Commons.getFont());
		
		id_check_panel.add(id_check_btn);	
		check_panel.add(id_check_panel,BorderLayout.NORTH);	
		btn_panel.add(mbti_check_btn);	btn_panel.add(join_btn);	btn_panel.add(cancel_btn);
		
		for(String name : namelist) {
			Panel l_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Label textlabel = new Label(name); 
			l_panel.add(textlabel);
			label_panel.add(l_panel);
			
			Panel t_panel = new Panel(new FlowLayout(FlowLayout.LEFT));

			if(name.equals("비밀번호") || name.equals("비밀번호확인")) {
				JPasswordField pf = new JPasswordField(15);
				t_panel.add(pf);
				tf_panel.add(t_panel);
				list.add(pf);
				
			}else if(name.equals("MBTI")) {
				list.add(mbtitype);
				mbtilist = new JComboBox<>(mbtitype);
				mbtilist.setPreferredSize(new Dimension(170,20));
				t_panel.add(mbtilist);
				tf_panel.add(t_panel);
				list.add(mbtilist);
				
			}else {
				tf = new JTextField(15);
				t_panel.add(tf);
				tf_panel.add(t_panel);
				list.add(tf);
			}
		}
		
		f.add(BorderLayout.WEST,label_panel);
		f.add(BorderLayout.CENTER,tf_panel);
		f.add(BorderLayout.EAST,check_panel);
		f.add(BorderLayout.SOUTH,btn_panel);
		
		label_panel.setBackground(Color.white);
		tf_panel.setBackground(Color.white);
		check_panel.setBackground(Color.white);
		btn_panel.setBackground(Color.white);
		
		f.setSize(400, 300);
		
		Dimension fsize = f.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		f.setLocation(width, height);
		
		f.setVisible(true);
		
		f.addWindowListener(new JoinUIEvent());
		id_check_btn.addActionListener(new JoinUIEvent(this));
		mbti_check_btn.addActionListener(new MbtiCheckUI(this));
		join_btn.addActionListener(new JoinUIEvent(this,main));
		cancel_btn.addActionListener(new JoinUIEvent(this));
		mbtilist.addActionListener(new JoinUIEvent(this));
	}
	
}
