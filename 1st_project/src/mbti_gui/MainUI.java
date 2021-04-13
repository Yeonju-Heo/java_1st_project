package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mbti_system.MbtiMgmSystem;

public class MainUI {
	//Field
	MbtiMgmSystem system;
	JFrame firstFrame, secondFrame;
	JPanel menu_panel, content_panel, bottom_panel;
	JButton btn_login, btn_join;
	JTextField id_tf;
	JPasswordField pw_tf;
	String[] menulist = {"메인","캐릭터생성","채팅","게시판","마이페이지","종료"};
	ArrayList<JButton> buttonlist = new ArrayList<JButton>();
	MainUIEvent eventObj = new MainUIEvent(this);
	
	Panel login_panel = new Panel();
	Panel main_panel = new Panel();
	Panel create_panel = new Panel();
	Panel chat_panel = new Panel();
	Panel board_panel = new Panel();
	Panel mypage_panel = new Panel();
	
	public static final int LOGIN = 0;
	public static final int MAIN = 1;
	public static final int CREATE = 2;
	public static final int CHAT = 3;
	public static final int BOARD = 4;
	public static final int MYPAGE = 5;
	public static final int EXIT = 6;
	
	//Constructor
	public MainUI() {
//		firstView();
		secondView();
	}
	//Method
	public void firstView() {
		firstFrame = new JFrame("Login");
		JPanel main_panel = new JPanel(new BorderLayout());
		
		ImageIcon icon = new ImageIcon("images/mainlogo.png");
		JLabel title_label = new JLabel(icon);
		
		JPanel main_label_panel = new JPanel();
		JPanel label_panel = new JPanel(new GridLayout(2,1,10,10));
		JPanel tf_panel = new JPanel(new GridLayout(2,1,10,10));
		JPanel btn_panel = new JPanel();
		
		main_label_panel.add(title_label);
		
		JLabel id = new JLabel("ID");
		JLabel pw = new JLabel("PW");
		id_tf = new JTextField(10);
		pw_tf = new JPasswordField(10);
		
		id.setFont(Commons.getFont());
		pw.setFont(Commons.getFont());
		id_tf.setFont(Commons.getFont());
		pw_tf.setFont(Commons.getFont());
		
		label_panel.add(id);	label_panel.add(pw);	
		tf_panel.add(id_tf);	tf_panel.add(pw_tf);
		
		btn_login = new JButton("Login");
		btn_join = new JButton("Join");
		btn_login.setFont(Commons.getFont());
		btn_join.setFont(Commons.getFont());
		btn_panel.add(btn_login);		btn_panel.add(btn_join);
		
		JPanel login_panel = new JPanel();
		login_panel.add(label_panel);
		login_panel.add(tf_panel);
		
		main_panel.add(BorderLayout.NORTH,main_label_panel);
		main_panel.add(BorderLayout.CENTER,login_panel);
		main_panel.add(BorderLayout.SOUTH,btn_panel);
		
		main_label_panel.setBackground(Color.white);
		login_panel.setBackground(Color.white);
		btn_panel.setBackground(Color.white);
		label_panel.setBackground(Color.white);
		tf_panel.setBackground(Color.white);
		
		firstFrame.add(main_panel);
		
		firstFrame.setSize(600,500);

		Dimension fsize = firstFrame.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		firstFrame.setLocation(width, height);
		
		firstFrame.setVisible(true);
		
		firstFrame.addWindowListener(new WindowAdapter() {
			public void	windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn_login.addActionListener(eventObj);
		id_tf.addActionListener(eventObj);
		pw_tf.addActionListener(eventObj);
		btn_join.addActionListener(eventObj);
	}

	public void secondView() {
		secondFrame = new JFrame("MBTI WORLD");
		
		menu_panel = new JPanel(new GridLayout(1,6,5,5));
		content_panel = new JPanel();
		bottom_panel = new JPanel();
		
		for(String name : menulist) {
			JButton btn_menu = new JButton(name);
			btn_menu.setFont(Commons.getFont());
			menu_panel.add(btn_menu);
			buttonlist.add(btn_menu);
			btn_menu.addActionListener(eventObj);
		}
		
		ImageIcon icon = new ImageIcon("images/main2.png");
		JLabel main_label = new JLabel(icon);
		content_panel.add(main_label);
		
		secondFrame.add(BorderLayout.NORTH,menu_panel);
		secondFrame.add(BorderLayout.CENTER,content_panel);
		secondFrame.add(BorderLayout.SOUTH,bottom_panel);
		
		menu_panel.setBackground(Color.white);
		content_panel.setBackground(Color.white);
		bottom_panel.setBackground(Color.white);
		
		secondFrame.setSize(900,700);

		Dimension fsize = secondFrame.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		secondFrame.setLocation(width, height);
		
		secondFrame.setVisible(true);
		
		secondFrame.addWindowListener(new WindowAdapter() {
			public void	windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	
	public void switch_panel(int menu) {
		content_panel.removeAll();
		login_panel.setVisible(false);
		main_panel.setVisible(false);
		create_panel.setVisible(false);
		chat_panel.setVisible(false);
		board_panel.setVisible(false);
		mypage_panel.setVisible(false);
	
		switch(menu) {
			case LOGIN :
				login_panel.removeAll();
				login_panel.setVisible(true);
				break;
			case MAIN :
				main_panel.removeAll();
				main_panel.setVisible(true);
				break;
			case CREATE :
				create_panel.removeAll();
				create_panel.setVisible(true);
				break;
			case CHAT :
				chat_panel.removeAll();
				chat_panel.setVisible(true);
				break;
			case BOARD :
				board_panel.removeAll();
				board_panel.setVisible(true);
				break;
			case MYPAGE :
				mypage_panel.removeAll();
				mypage_panel.setVisible(true);
				break;
		}
	}
	
	
	
}
