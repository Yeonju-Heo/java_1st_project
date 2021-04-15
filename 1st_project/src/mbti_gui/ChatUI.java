package mbti_gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.sun.tools.javac.Main;

import mbti_vo.MessageVO;

public class ChatUI implements ActionListener{
	//Field
	JFrame chat_frame;//프레임
	
	JPanel left_panel;
	JPanel right_panel;
	JPanel center_panel;
	
	JTextArea chat_content;
	JTextField chat_tf;//text 보내는 곳
	JButton btn_send;
	JList user_list;//유저 리스트
	
	JPanel list_panel;
	JPanel botton_panel;
	JPanel user_panel;
	
	JLabel la_user;
	JLabel la_count;
	JLabel title_label;
	
	ChatClient client = new ChatClient();
	ClientThread ct;
	
	//Constructor
	public ChatUI(){
		init();
//		client = new ChatClient();
		ct = new ClientThread(client.ois, chat_content, user_list, la_count);
		ct.start();
			
		
	}
	
	public void init(){	
		chat_frame = new JFrame("MBTI WORLD");//챗 프레임
		left_panel = new JPanel(new GridLayout());//채팅 올라오는 곳
		right_panel = new JPanel(new GridLayout());//유저리스트 보여주는 곳 
		center_panel = new JPanel();//전체 패널
		botton_panel = new JPanel(new FlowLayout());//아래 패널
		ImageIcon chattitle = new ImageIcon("images/chattitle.png");
		JLabel title_Label = new JLabel(chattitle);
		
		chat_content = new JTextArea(30,30);//text채팅 전체 창
		chat_tf = new JTextField(52);//텍스트 입력창
		btn_send = new JButton("보내기");//보내기
		user_list = new JList();//유저 리스트를 넣을 곳
		
		//채팅 컨텐츠 화면
		JScrollPane jp = new JScrollPane(chat_content);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chat_content.setFont(Commons.getFont());
		left_panel.add(jp);
		
		//채팅 오른쪽 화면
		user_panel = new JPanel(new GridLayout());
		la_user = new JLabel("채팅 접속자");
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
		
		//아래 채팅 보내는 곳
		chat_tf.setFont(Commons.getFont());
		btn_send.setFont(Commons.getFont());
	//			JPanel setbotton_panel = new JPanel(new FlowLayout());
		botton_panel.add(chat_tf); 
		botton_panel.add(btn_send);
		
	//			botton_panel.add(setbotton_panel);
		
		//center_panel
		center_panel.setLayout(new BorderLayout());
		center_panel.add("Center", left_panel);
		center_panel.add("East", right_panel);
		center_panel.setBackground(Color.blue);
		
		chat_frame.add(BorderLayout.CENTER, center_panel);
		chat_frame.add(BorderLayout.SOUTH, botton_panel);
		chat_frame.add(BorderLayout.NORTH, title_Label);
		
		chat_frame.setSize(700,600);
		chat_frame.setResizable(false);//사이즈 고정
		chat_frame.setVisible(true);
		
		chat_tf.addActionListener(this);
		btn_send.addActionListener(this);
		
		//유저 리스트를 클릭해서 프로필 보기
		user_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2) {
					//더블 클릭시 이벤트 실행
					int index = list.locationToIndex(evt.getPoint());
					Frame image = new Frame("유저 캐릭터");
					//DB에서 전송받은 이미지를 넣는 Label, panel
					ImageIcon img_char = new ImageIcon("images/character.png");
					JLabel image_Label = new JLabel(img_char);
					JPanel image_Panel = new JPanel();
					image_Panel.add(image_Label);
					
					image.add(image_Panel);
					image.setSize(300,500);
					image.setVisible(true);
					
					/** window event **/
					image.addWindowListener(new WindowAdapter(){
						public void windowClosing(WindowEvent e) {
							image.setVisible(false);
							image.dispose();
						}
					});
					
				}
			}
		});
		
		
		/** window event **/
		chat_frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				try {
					//Exit
					System.out.println("끝내기");
					MessageVO vo = new MessageVO();
					vo.setName("user_name"); //나갈때 이름
					vo.setStatus(MessageVO.EXIT);			
					client.oos.writeObject(vo);
					
//					chat_frame.setVisible(false);
//					chat_frame.dispose();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
	}	
	
	//Method
	/** Button event **/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == chat_tf || obj == btn_send) {
			if(!chat_tf.getText().equals("")) {
				try {
					//talk
					MessageVO vo = new MessageVO();
					vo.setName("user_name"); //채팅중 이름 
					vo.setMbti("mbti");
					vo.setMsg(chat_tf.getText());
					vo.setStatus(MessageVO.TALK);
					
					//보내기
					client.oos.writeObject(vo);
					chat_tf.setText("");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("데이터를 입력해주세요."));
				chat_tf.requestFocus();
			}
	}
}
}