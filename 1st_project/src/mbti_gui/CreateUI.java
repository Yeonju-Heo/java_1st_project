package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mbti_vo.ItemVO;
import mbti_vo.UserItemVO;
import mbti_vo.UserVO;

public class CreateUI implements ActionListener{
	//Field
	MbtiMainUI main;
	JPanel point_panel, center_panel, hair_panel, top_panel, bottom_panel, 
		   text_panel, h_text_panel, t_text_panel, b_text_panel;
	JButton btn_hair, btn_top, btn_bottom;
	JLabel point_label, hair_label, top_label, bottom_label, text_label;
	ImageIcon hair_normal, hair_rollover, hair_pressed, 
			  top_normal, top_rollover, top_pressed,
			  bottom_normal, bottom_rollover, bottom_pressed;
	Random random;
	UserVO user;
	ArrayList<ItemVO> item;
	
	//Constructor
	public CreateUI(MbtiMainUI main) {
		this.main = main;
		init();
	}
	
	//Method
	public void init() {
		main.switch_panel(MbtiMainUI.CREATE);
		user = main.system.searchUser(main.id_tf.getText());
		item = main.system.getItem();
		
		/** 포인트 패널 **/
		point_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,50));
		point_label = new JLabel("내 포인트 : "+user.getU_point()+" point");
		point_label.setFont(Commons.getFont2());
		point_panel.add(point_label);
		
		/** 센터 패널 **/
		center_panel = new JPanel(new GridLayout(1,3));
		hair_panel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,50));
		top_panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,50));
		bottom_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,50));
		
		hair_normal = new ImageIcon("images/btn_hair_normal.png");
		hair_rollover = new ImageIcon("images/btn_hair_rollover.png");
		hair_pressed = new ImageIcon("images/btn_hair_pressed.png");
		
		top_normal = new ImageIcon("images/btn_top_normal.png");
		top_rollover = new ImageIcon("images/btn_top_rollover.png");
		top_pressed = new ImageIcon("images/btn_top_pressed.png");
		
		bottom_normal = new ImageIcon("images/btn_bottom_normal.png");
		bottom_rollover = new ImageIcon("images/btn_bottom_rollover.png");
		bottom_pressed = new ImageIcon("images/btn_bottom_pressed.png");
		
		btn_hair = new JButton(hair_normal);
		btn_hair.setRolloverIcon(hair_rollover);
		btn_hair.setPressedIcon(hair_pressed);
		
		btn_top = new JButton(top_normal);
		btn_top.setRolloverIcon(top_rollover);
		btn_top.setPressedIcon(top_pressed);
		
		btn_bottom = new JButton(bottom_normal);
		btn_bottom.setRolloverIcon(bottom_rollover);
		btn_bottom.setPressedIcon(bottom_pressed);
		
		hair_panel.add(btn_hair);
		top_panel.add(btn_top);	
		bottom_panel.add(btn_bottom);
		
		center_panel.add(hair_panel);
		center_panel.add(top_panel);
		center_panel.add(bottom_panel);
		
		/** 텍스트 패널 **/
		text_panel = new JPanel (new GridLayout(1,3));
		h_text_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		t_text_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		b_text_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		hair_label = new JLabel("<html><body style='text-align:center;'>HAIR<br>30 point</body></html>");
		top_label = new JLabel("<html><body style='text-align:center;'>TOP<br>20 point</body></html>");
		bottom_label = new JLabel("<html><body style='text-align:center;'>BOTTOM<br>20 point</body></html>");
		
		h_text_panel.add(hair_label);
		t_text_panel.add(top_label);
		b_text_panel.add(bottom_label);
		
		text_panel.add(h_text_panel);
		text_panel.add(t_text_panel);
		text_panel.add(b_text_panel);
		
		/** 화면 구성 **/
		main.create_panel.setLayout(new BorderLayout());
		main.create_panel.add(BorderLayout.NORTH,point_panel);
		main.create_panel.add(BorderLayout.CENTER,center_panel);
		main.create_panel.add(BorderLayout.SOUTH,text_panel);
		
		point_panel.setBackground(Color.white);
		hair_panel.setBackground(Color.white);
		top_panel.setBackground(Color.white);
		bottom_panel.setBackground(Color.white);
		text_panel.setBackground(Color.white);
		h_text_panel.setBackground(Color.white);
		t_text_panel.setBackground(Color.white);
		b_text_panel.setBackground(Color.white);
		
		main.content_panel.add(main.create_panel);
		main.secondFrame.setVisible(true);
		
		btn_hair.addActionListener(this);
		btn_top.addActionListener(this);
		btn_bottom.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_hair) {
			init();
			random_hair();
		}else if(obj == btn_top) {
			init();
			random_top();
		}else if(obj == btn_bottom) {
			init();
			random_bottom();
		}
		
	}
	
	/** 뽑기 창 **/
	public void random_hair() {
		if(main.system.subPoint(user)) {
			if(user.getU_point() >= 20) {
				JFrame f = new JFrame("짜잔! 멋진 헤어 당첨!");
				JPanel p = new JPanel(new BorderLayout());
				UserItemVO uitem = new UserItemVO();
				
				random = new Random();
				int bound = 5;
				ArrayList<ImageIcon> hairlist = new ArrayList<ImageIcon>();
				
				ImageIcon hair1 = new ImageIcon("images/hair1.png");
				hair1.setDescription("hair1");
				ImageIcon hair2 = new ImageIcon("images/hair2.png");
				hair2.setDescription("hair2");
				ImageIcon hair3 = new ImageIcon("images/hair3.png");
				hair3.setDescription("hair3");
				ImageIcon hair4 = new ImageIcon("images/hair4.png");
				hair4.setDescription("hair4");
				ImageIcon hair5 = new ImageIcon("images/hair5.png");
				hair5.setDescription("hair5");
				hairlist.add(hair1);
				hairlist.add(hair2);
				hairlist.add(hair3);
				hairlist.add(hair4);
				hairlist.add(hair5);
				
				int i=random.nextInt(bound);
				JLabel l = new JLabel(hairlist.get(i));
				System.out.println(hairlist.get(i));
				uitem.setI_name(hairlist.get(i).getDescription());
				System.out.println(hairlist.get(i));
				uitem.setU_id(user.getU_id());
				main.system.updateUserItem(main.id_tf.getText(), uitem.getI_name());
				p.add(l);
				f.add(BorderLayout.CENTER,p);
				f.setSize(350,350);
				
				Dimension fsize = f.getSize();
				Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
				int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
				int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
				f.setLocation(width, height);
				
				f.setVisible(true);
				f.addWindowListener(new WindowAdapter() {
					public void	windowClosing(WindowEvent e) {
						f.setVisible(false);
						f.dispose();
					}
				});
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("포인트가 부족합니다. 포인트를 충전해주세요."));
			}
		}else {
			JOptionPane.showMessageDialog(null, Commons.getMsg("포인트가 부족합니다. 포인트를 충전해주세요."));
		}
	}
	
	public void random_top() {
		if(main.system.subPoint(user)) {
			if(user.getU_point() >= 20) {
				JFrame f = new JFrame("짜잔! 멋진 상의 당첨!");
				JPanel p = new JPanel(new BorderLayout());
				UserItemVO uitem = new UserItemVO();
				
				random = new Random();
				int bound = 6;
				ArrayList<ImageIcon> toplist = new ArrayList<ImageIcon>();
				
				ImageIcon top1 = new ImageIcon("images/top1.png");
				top1.setDescription("top1");
				ImageIcon top2 = new ImageIcon("images/top2.png");
				top2.setDescription("top2");
				ImageIcon top3 = new ImageIcon("images/top3.png");
				top3.setDescription("top3");
				ImageIcon top4 = new ImageIcon("images/top4.png");
				top4.setDescription("top4");
				ImageIcon top5 = new ImageIcon("images/top5.png");
				top5.setDescription("top5");
				ImageIcon top6 = new ImageIcon("images/top6.png");
				top6.setDescription("top6");
				toplist.add(top1);
				toplist.add(top2);
				toplist.add(top3);
				toplist.add(top4);
				toplist.add(top5);
				toplist.add(top6);
				
				int i=random.nextInt(bound);
				JLabel l = new JLabel(toplist.get(i));
				System.out.println(toplist.get(i));
				uitem.setI_name(toplist.get(i).getDescription());
				System.out.println(toplist.get(i));
				uitem.setU_id(user.getU_id());
				main.system.updateUserItem(main.id_tf.getText(), uitem.getI_name());
				p.add(l);
				f.add(BorderLayout.CENTER,p);
				f.setSize(350,350);
				
				Dimension fsize = f.getSize();
				Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
				int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
				int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
				f.setLocation(width, height);
				
				f.setVisible(true);
				f.addWindowListener(new WindowAdapter() {
					public void	windowClosing(WindowEvent e) {
						f.setVisible(false);
						f.dispose();
					}
				});
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("포인트가 부족합니다. 포인트를 충전해주세요."));
			}
		}else {
			JOptionPane.showMessageDialog(null, Commons.getMsg("포인트가 부족합니다. 포인트를 충전해주세요."));
		}
	}
	
	public void random_bottom() {
		if(main.system.subPoint(user)) {
			if(user.getU_point() >= 20) {
				JFrame f = new JFrame("짜잔! 멋진 바지 당첨!");
				JPanel p = new JPanel(new BorderLayout());
				UserItemVO uitem = new UserItemVO();
				
				random = new Random();
				int bound = 5;
				ArrayList<ImageIcon> bottomlist = new ArrayList<ImageIcon>();
				
				ImageIcon bottom1 = new ImageIcon("images/bottom1.png");
				bottom1.setDescription("bottom1");
				ImageIcon bottom2 = new ImageIcon("images/bottom2.png");
				bottom2.setDescription("bottom2");
				ImageIcon bottom3 = new ImageIcon("images/bottom3.png");
				bottom3.setDescription("bottom3");
				ImageIcon bottom4 = new ImageIcon("images/bottom4.png");
				bottom4.setDescription("bottom4");
				ImageIcon bottom5 = new ImageIcon("images/bottom5.png");
				bottom5.setDescription("bottom5");
				bottomlist.add(bottom1);
				bottomlist.add(bottom2);
				bottomlist.add(bottom3);
				bottomlist.add(bottom4);
				bottomlist.add(bottom5);
				
				int i=random.nextInt(bound);
				JLabel l = new JLabel(bottomlist.get(i));
				System.out.println(bottomlist.get(i));
				uitem.setI_name(bottomlist.get(i).getDescription());
				System.out.println(bottomlist.get(i));
				uitem.setU_id(user.getU_id());
				main.system.updateUserItem(main.id_tf.getText(), uitem.getI_name());
				p.add(l);
				f.add(BorderLayout.CENTER,l);
				f.setSize(350,350);
				
				Dimension fsize = f.getSize();
				Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
				int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
				int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
				f.setLocation(width, height);
				
				f.setVisible(true);
				f.addWindowListener(new WindowAdapter() {
					public void	windowClosing(WindowEvent e) {
						f.setVisible(false);
						f.dispose();
					}
				});
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("포인트가 부족합니다. 포인트를 충전해주세요."));
			}
		}else {
			JOptionPane.showMessageDialog(null, Commons.getMsg("포인트가 부족합니다. 포인트를 충전해주세요."));
		}
	}
	

}
