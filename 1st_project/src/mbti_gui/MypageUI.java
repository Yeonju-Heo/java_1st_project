package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mbti_system.MbtiMgmSystem;

public class MypageUI implements ActionListener{
	//Field
	MbtiMainUI main;
	JPanel closet_panel,char_closet_panel, char_panel, inform_panel,info_mbti_panel, info_text_panel,info_panel, mbti_panel, mbti_label_panel, id_panel, pass_panel,
			point_panel, date_panel,btn_panel,update_panel, cancel_account_panel,content_panel;
	String[] infolist = {"mbti","mbti설명","아이디","비밀번호","포인트","가입일"};
	JLabel char_img;
	JButton btn_update_info, btn_cancel_account, btn_closet;
	JPasswordField pwd;
	ImageIcon character;
	JLabel mbti, mbti_label, id_label, id_detail_label, pwd_label, point_label, point_detail_label,
			date_label, date_detail_label;
	
	
	//Constructor
	public MypageUI(MbtiMainUI main) {
		this.main = main;
		init();
	}
	
	//Method
	public void init() {
		main.switch_panel(MbtiMainUI.MYPAGE);
		
		char_closet_panel = new JPanel(new GridLayout(1,2,0,50));
		closet_panel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
		btn_closet = new JButton("내 옷장");
		btn_closet.setFont(Commons.getFont());
		closet_panel.add(btn_closet);
		char_panel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
		character = new ImageIcon("images/character.png");
		char_img = new JLabel(character);
		char_panel.add(char_img);
		char_closet_panel.add(closet_panel);
		char_closet_panel.add(char_panel);
		
		
		info_mbti_panel = new JPanel(new GridLayout(2,1));
		mbti_panel = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		mbti_label_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mbti = new JLabel("mbti");
		mbti_panel.add(mbti);
		mbti_label = new JLabel("mbti설명");
		mbti_label_panel.add(mbti_label);
		info_mbti_panel.add(mbti_panel);
		info_mbti_panel.add(mbti_label_panel);
		
		info_text_panel = new JPanel(new GridLayout(4,1));
		id_panel = new JPanel(new GridLayout(1,2));
		id_label = new JLabel("아이디");
		id_detail_label = new JLabel("apeach");
		id_panel.add(id_label);
		id_panel.add(id_detail_label);
		pass_panel = new JPanel(new GridLayout(1,2));
		pwd_label = new JLabel("비밀번호");
		pwd = new JPasswordField(10);
		pass_panel.add(pwd_label);
		pass_panel.add(pwd);
		point_panel = new JPanel(new GridLayout(1,2));
		point_label = new JLabel("포인트");
		point_detail_label = new JLabel("270 point");
		point_panel.add(point_label);
		point_panel.add(point_detail_label);
		date_panel = new JPanel(new GridLayout(1,2));
		date_label = new JLabel("가입일");
		date_detail_label = new JLabel("2021.04.11");
		date_panel.add(date_label);
		date_panel.add(date_detail_label);
		info_text_panel.add(id_panel);
		info_text_panel.add(pass_panel);
		info_text_panel.add(point_panel);
		info_text_panel.add(date_panel);
		
		btn_panel = new JPanel(new GridLayout(1,2));
		update_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cancel_account_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btn_update_info = new JButton("정보수정");
		btn_update_info.setFont(Commons.getFont());
		btn_cancel_account = new JButton("회원탈퇴");
		btn_cancel_account.setFont(Commons.getFont());
		update_panel.add(btn_update_info);
		cancel_account_panel.add(btn_cancel_account);
		btn_panel.add(update_panel);
		btn_panel.add(cancel_account_panel);
		
		inform_panel = new JPanel(new FlowLayout(FlowLayout.CENTER,100,150));
		info_panel = new JPanel(new GridLayout(3,1));
		info_panel.add(info_mbti_panel);
		info_panel.add(info_text_panel);
		info_panel.add(btn_panel);
		inform_panel.add(info_panel);

		main.mypage_panel.setLayout(new BorderLayout());
		main.mypage_panel.setSize(900, 700);
		main.mypage_panel.add(BorderLayout.WEST,char_closet_panel);
		main.mypage_panel.add(BorderLayout.EAST,inform_panel);
		
		main.content_panel.add(main.mypage_panel);
		main.secondFrame.setVisible(true);
		
		btn_closet.addActionListener(this);
		btn_update_info.addActionListener(this);
		btn_cancel_account.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn_closet) {
			main.content_panel.removeAll();
			main.login_panel.setVisible(false);
			main.main_panel.setVisible(false);
			main.create_panel.setVisible(false);
			main.chat_panel.setVisible(false);
			main.board_panel.setVisible(false);
//			main.mypage_panel.setVisible(false);
			main.mypage_panel.removeAll();
//			main.mypage_panel.setVisible(true);
			new ClosetUI(main);
		}else if(obj == btn_update_info) {
			System.out.println("정보수정");
		}else if(obj == btn_cancel_account) {
			System.out.println("회원탈퇴");
		}
	}
	
	
}