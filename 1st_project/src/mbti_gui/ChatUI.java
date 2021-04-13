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
	JFrame chat_frame;//��ü
	
	JPanel left_panel;
	JPanel right_panel;
	JPanel center_panel;
	
	JTextArea chat_content;
	JTextField chat_tf;//text���� ��
	JButton btn_send;
	JList user_list;//ä�� ������ ���
	
	JPanel list_panel;
	JPanel botton_panel;
	JPanel user_panel;
	
	JLabel la_user;
	JLabel la_count;
	JLabel title_label;
	
	//Constructor
	public ChatUI(){	
		chat_frame = new JFrame("MBTI WORLD");//������
		left_panel = new JPanel(new GridLayout());//���� ä��ȭ��
		right_panel = new JPanel(new GridLayout());//������ ä�� ������ ���
		center_panel = new JPanel();//���� �������� ����ȭ��
		botton_panel = new JPanel(new FlowLayout());//�ϴ� ä�� �г�
		ImageIcon chattitle = new ImageIcon("images/chattitle.png");
		JLabel title_Label = new JLabel(chattitle);
		
		chat_content = new JTextArea(30,30);//text�������� ��
		chat_tf = new JTextField(52);//�۾��� ��
		btn_send = new JButton("������");//���� ��ư
		user_list = new JList();//��������Ʈ
		
		//ä��ȭ��(�߽�, ����) --��ũ�� �����, �̸��� Ŭ���ϸ� ��â���� �ƹ�Ÿ�� ���̱�
		JScrollPane jp = new JScrollPane(chat_content);
		jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chat_content.setFont(Commons.getFont());
		left_panel.add(jp);
		
		//����� ��� ȭ��(������) --���� ä���ϰ� �ִ� ��� ����� �����ֱ�(��ũ��), ���̵�� mbti
		user_panel = new JPanel(new GridLayout());
		la_user = new JLabel("����� ���");
		la_user.setHorizontalAlignment(JLabel.CENTER);
		la_count = new JLabel("0�� ������");
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
		
		//ä�� ������ ��(�ϴ�) --�ϴ� �ؽ�Ʈ �ʵ�, ��ư �̺�Ʈ ó��
		chat_tf.setFont(Commons.getFont());
		btn_send.setFont(Commons.getFont());
//		JPanel setbotton_panel = new JPanel(new FlowLayout());
		botton_panel.add(chat_tf); 
		botton_panel.add(btn_send);
		
//		botton_panel.add(setbotton_panel);
		
		//center_panel�� �ֱ�
		center_panel.setLayout(new BorderLayout());
		center_panel.add("Center", left_panel);
		center_panel.add("East", right_panel);
		center_panel.setBackground(Color.blue);
		
		chat_frame.add(BorderLayout.CENTER, center_panel);
		chat_frame.add(BorderLayout.SOUTH, botton_panel);
		chat_frame.add(BorderLayout.NORTH, title_Label);
		
		chat_frame.setSize(700,600);
		chat_frame.setResizable(false);//ä��â ũ�� ����
		chat_frame.setVisible(true);
		
		chat_tf.addActionListener(this);
		btn_send.addActionListener(this);
		
		/** window event ó�� **/
		chat_frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				chat_frame.setVisible(false);
//				chat_frame.dispose();
			}
		});
		
	}
	
	//Method
	/** Button event ó�� **/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == chat_tf || obj == btn_send) {
			if(!chat_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�����忬��");
				chat_tf.setText("");
				
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("�޽����� �Է����ּ���."));
				chat_tf.requestFocus();
			}
		}
	}
	
}
