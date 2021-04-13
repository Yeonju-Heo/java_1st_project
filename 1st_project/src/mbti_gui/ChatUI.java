package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class ChatUI implements ActionListener{
	//Field
	JFrame chat_frame;//전체
	
	JPanel left_panel;
	JPanel right_panel;
	JPanel center_panel;
	
	JTextArea chat_content;
	JTextField chat_tf;//text적는 곳
	JButton btn_send;
	JList user_list;//채팅 참여자 목록
	
	JPanel list_panel;
	JPanel botton_panel;
	JPanel user_panel;
	
	JLabel la_user;
	JLabel la_count;
	JLabel title_label;
	
	//Constructor
	public ChatUI(){	
		chat_frame = new JFrame("MBTI WORLD");//프레임
		left_panel = new JPanel(new GridLayout());//왼쪽 채팅화면
		right_panel = new JPanel(new GridLayout());//오른쪽 채팅 참여자 목록
		center_panel = new JPanel();//왼쪽 오른쪽을 합할화면
		botton_panel = new JPanel(new FlowLayout());//하단 채팅 패널
		ImageIcon chattitle = new ImageIcon("images/chattitle.png");
		JLabel title_Label = new JLabel(chattitle);
		
		chat_content = new JTextArea(30,30);//text보여지는 곳
		chat_tf = new JTextField(52);//글쓰는 곳
		btn_send = new JButton("보내기");//전송 버튼
		user_list = new JList();//유저리스트
		
		//채팅화면(중심, 왼쪽) --스크롤 만들기, 이름을 클릭하면 새창에서 아바타가 보이기
		JScrollPane jp = new JScrollPane(chat_content);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chat_content.setFont(Commons.getFont());
		left_panel.add(jp);
		
		//사용자 목록 화면(오른쪽) --현재 채팅하고 있는 사람 목록을 보여주기(스크롤), 아이디와 mbti
		user_panel = new JPanel(new GridLayout());
		la_user = new JLabel("사용자 목록");
		la_user.setHorizontalAlignment(JLabel.CENTER);
		la_count = new JLabel("0명 접속중");
		la_count.setHorizontalAlignment(JLabel.CENTER);
		la_user.setFont(Commons.getFont());
		user_list.setFont(Commons.getFont());
		la_count.setFont(Commons.getFont());
		user_list.setFixedCellWidth(100);
		JScrollPane jp2 = new JScrollPane(user_list);
		jp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		user_panel.add(jp2);
		right_panel.setLayout(new BorderLayout());
		right_panel.add("North", la_user);
		right_panel.add("Center",user_panel);
		right_panel.add("South", la_count);
		
		//채팅 보내는 곳(하단) --하단 텍스트 필드, 버튼 이벤트 처리
		chat_tf.setFont(Commons.getFont());
		btn_send.setFont(Commons.getFont());
//		JPanel setbotton_panel = new JPanel(new FlowLayout());
		botton_panel.add(chat_tf); 
		botton_panel.add(btn_send);
		
//		botton_panel.add(setbotton_panel);
		
		//center_panel에 넣기
		center_panel.setLayout(new BorderLayout());
		center_panel.add("Center", left_panel);
		center_panel.add("East", right_panel);
		center_panel.setBackground(Color.blue);
		
		chat_frame.add(BorderLayout.CENTER, center_panel);
		chat_frame.add(BorderLayout.SOUTH, botton_panel);
		chat_frame.add(BorderLayout.NORTH, title_Label);
		
		chat_frame.setSize(700,600);
		chat_frame.setResizable(false);//채팅창 크기 고정
		chat_frame.setVisible(true);
		
		chat_tf.addActionListener(this);
		btn_send.addActionListener(this);
		
		/** window event 처리 **/
		chat_frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	//Method
	/** Button event 처리 **/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == chat_tf || obj == btn_send) {
			if(!chat_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "쓰레드연결");
				chat_tf.setText("");
				
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("메시지를 입력해주세요."));
				chat_tf.requestFocus();
			}
		}
	}
	
}
