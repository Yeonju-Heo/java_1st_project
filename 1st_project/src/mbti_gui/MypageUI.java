package mbti_gui;

import java.awt.BorderLayout;
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
	MainUI main;
//	MbtiMgmSystem system;
//	JFrame mypageFrame;
	JPanel closet_panel, my_info_panel, my_info_btn_panel,content_panel;
	String[] infolist = {"mbti","mbti설명","아이디","비밀번호","포인트","가입일"};
	ArrayList<JButton> buttonlist = new ArrayList<JButton>();
	ArrayList<Object> list = new ArrayList<Object>();
	JButton btn_update_info, btn_cancel_account, btn_closet;
//	
//	Panel gomain_panel = new Panel();
//	Panel create_panel = new Panel();
//	Panel chat_panel = new Panel();
//	Panel board_panel = new Panel();
//	Panel mypage_panel = new Panel();
		
	//Constructor
	public MypageUI() {
		init();
	}
	public MypageUI(MainUI main) {
		this.main = main;
		init();
	}
	
	public void init() {
		main.switch_panel(MainUI.MYPAGE);
//		mypageFrame = new JFrame("마이페이지");
//		
//		main.menu_panel = new JPanel(new GridLayout(1,6));
		content_panel = new JPanel(new GridLayout(1,2));
		closet_panel = new JPanel();//내옷장
		my_info_panel = new JPanel(new GridLayout(3,1));
		my_info_btn_panel = new JPanel();
		main.mypage_panel.setLayout(new BorderLayout());
		
//		for(String name : menulist) {//메뉴
//			JButton btn_menu = new JButton(name);
//			btn_menu.setFont(Commons.getFont());
//			main.menu_panel.add(btn_menu);
//			btn_menu.addActionListener(main.eventObj);
//			buttonlist.add(btn_menu);
//		}
		
		JPanel mbti_panel = new JPanel(new GridLayout(3,1));//mbti,mbti설명
		JPanel info_panel = new JPanel(new GridLayout(4,1));//나머지
//		mbti_panel.add(new JLabel(""));
		for(String name : infolist) {
			if(name.equals("mbti")||name.equals("mbti설명")) {
				JLabel info_label = new JLabel(name,JLabel.CENTER);
				mbti_panel.add(info_label);
			}else {
				JLabel info_label = new JLabel(name,JLabel.CENTER);
				JPanel t_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				if(name.equals("아이디")) {
					JLabel t_label = new JLabel("apeach");
					t_panel.add(t_label);
					info_panel.add(info_label);
					info_panel.add(t_panel);
				}else if(name.equals("비밀번호")) {
					JPasswordField pwd = new JPasswordField(10);
					t_panel.add(pwd);
					info_panel.add(info_label);
					info_panel.add(t_panel);
				}else if(name.equals("포인트")) {
					JLabel t_label = new JLabel("270");
					t_panel.add(t_label);
					t_panel.add(new Label(" point"));
					info_panel.add(info_label);
					info_panel.add(t_panel);
				}else if(name.equals("가입일")) {
					JLabel t_label = new JLabel("2021.04.11");
					t_panel.add(t_label);
					info_panel.add(info_label);
					info_panel.add(t_panel);
				}
			}
		}
		my_info_panel.add(mbti_panel);
		my_info_panel.add(info_panel);
		btn_update_info = new JButton("정보수정");
		btn_cancel_account = new JButton("회원탈퇴");
		my_info_btn_panel.add(btn_update_info);
		my_info_btn_panel.add(btn_cancel_account);
		my_info_panel.add(my_info_btn_panel);
		
		btn_closet = new JButton("내 옷장");
		ImageIcon icon = new ImageIcon("images/character.png");
		JLabel main_label = new JLabel(icon);
		closet_panel.add(btn_closet);
		content_panel.add(closet_panel);
		content_panel.add(main_label);
		main.mypage_panel.add(content_panel);
		main.mypage_panel.add(my_info_panel);
		
		main.secondFrame.add(BorderLayout.NORTH,main.menu_panel);
		main.secondFrame.add(BorderLayout.CENTER,main.mypage_panel);
//		main.secondFrame.add(BorderLayout.WEST,content_panel);
		main.secondFrame.setSize(750,700);
	
		Dimension fsize = main.secondFrame.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		main.secondFrame.setLocation(width, height);
		
		main.secondFrame.setVisible(true);
		
		main.secondFrame.addWindowListener(new WindowAdapter() {
			public void	windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		btn_closet.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn_closet) {
			new ClosetUI(main);
			System.out.println("내옷장");
			main.content_panel.removeAll();
//			main.content_panel.setVisible(false);
			main.login_panel.setVisible(false);
			main.gomain_panel.setVisible(false);
			main.create_panel.setVisible(false);
			main.chat_panel.setVisible(false);
			main.board_panel.setVisible(false);
			main.mypage_panel.setVisible(false);
			main.my_info_panel.setVisible(false);
			
//			closet_panel.setVisible(false);
//			my_info_panel.setVisible(false);
//			my_info_btn_panel.setVisible(false);
			
		}
	}
}
