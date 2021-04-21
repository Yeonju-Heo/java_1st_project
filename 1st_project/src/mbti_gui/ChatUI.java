package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
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

import mbti_vo.MbtiVO;
import mbti_vo.MessageVO;
import mbti_vo.UserVO;

public class ChatUI implements ActionListener{
	//Field
	JFrame chat_frame;//프레임
	MbtiMainUI main;
	
	JPanel left_panel;
	JPanel right_panel;
	JPanel center_panel;
	
	JTextArea chat_content;
	JTextField chat_tf;//텍스트 치는 곳
	JButton btn_send;
	JList user_list;//접속자 보여주는 곳
	
	JPanel list_panel;
	JPanel botton_panel;
	JPanel user_panel;
	
	JLabel la_user;
	JLabel la_count;
	JLabel title_label;
	
	ChatClient client;
	ClientThread ct;
	
	//Constructor
	public ChatUI(MbtiMainUI main){
		this.main = main;
		client = new ChatClient(main);
		init();
//		client = new ChatClient();
		ct = new ClientThread(client.ois, chat_content, user_list, la_count);
		ct.start();
			
		
	}
	
	public void init(){	
		chat_frame = new JFrame("MBTI WORLD");//프레임 생성
		left_panel = new JPanel(new GridLayout());//채팅 왼편 패널
		right_panel = new JPanel(new GridLayout());//리스트 보여주는 패널 
		center_panel = new JPanel();//내용패널
		botton_panel = new JPanel(new FlowLayout());//버튼
		ImageIcon chattitle = new ImageIcon("images/chattitle.png");
		JLabel title_Label = new JLabel(chattitle);
		
		chat_content = new JTextArea(30,30);//text채팅 내용 창
		chat_tf = new JTextField(52);//텍스트 입력창
		btn_send = new JButton("보내기");//보내기 버튼
		user_list = new JList();//참여 유저들을 보여줄 채팅 리스트 
		
		//채팅 내용 패널
		JScrollPane jp = new JScrollPane(chat_content);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chat_content.setFont(Commons.getFont());
		left_panel.add(jp);
		
		//채팅 오른쪽 패널
		user_panel = new JPanel(new GridLayout());
		la_user = new JLabel("채팅 접속자 목록");
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
		
		//채팅 보내는 장소
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
		chat_frame.setResizable(false);//채팅 사이즈 고정
		chat_frame.setVisible(true);
		
		chat_tf.addActionListener(this);
		btn_send.addActionListener(this);
		
		/**유저리스트를 클릭해서 유저 프로필 보기**/
		user_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if(evt.getClickCount() == 2) {
					//클릭 이벤트
					int index = list.locationToIndex(evt.getPoint());
					Frame image = new Frame("유저 캐릭터");
					//DB에서 사진 불러오기
					UserVO char_image = main.system.getUserChar(main.id_tf.getText());
					ImageIcon img_char = new ImageIcon(char_image.getU_char());
					JLabel image_Label = new JLabel(img_char);
					JPanel image_Panel = new JPanel();
					image_Panel.add(image_Label);
					
//					Dimension frame_size = image.getSize();
//					Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
//					int width = (int)(screen_size.getWidth()-main.firstFrame.getWidth());
//					int height = (int)(screen_size.getHeight()-main.firstFrame.getHeight())/2;
//					image.setLocation(width, height);
					
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
					System.out.println("나가기");
					MessageVO vo = new MessageVO();
					UserVO uvo = main.system.getChatUserDataSelect(main.id_tf.getText());
					MbtiVO mvo = main.system.getMbti(uvo);
					vo.setName(uvo.getU_id()); //퇴장 아이디
					vo.setMbti(mvo.getMbti_type());
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
					UserVO uvo = main.system.getChatUserDataSelect(main.id_tf.getText());
					MbtiVO mvo = main.system.getMbti(uvo);
					vo.setName(uvo.getU_id()); //말할때 아이디
					vo.setMbti(mvo.getMbti_type());
					vo.setMsg(chat_tf.getText());
					vo.setStatus(MessageVO.TALK);
					
					//보내기
					client.oos.writeObject(vo);
					chat_tf.setText("");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("메시지를 입력해주세요."));
				chat_tf.requestFocus();
			}
	}
}
}