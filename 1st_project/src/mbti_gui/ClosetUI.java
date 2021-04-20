package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ClosetUI  extends JPanel implements ActionListener, MouseListener {
	JButton btn_hair1,btn_hair2,btn_hair3,btn_hair4,btn_top1,btn_top2,btn_top3,btn_top4,btn_top5,btn_top6, btn_bottom1,btn_bottom2,btn_bottom3,btn_bottom4,btn_bottom5;
	Container con;
//	JPanel con;
	ImageIcon character = new ImageIcon("images/merge_charactor.png");
	ImageIcon charactor_nohair = new ImageIcon("images/merge_charactor_nohair.png");
	ImageIcon charactor_notop = new ImageIcon("images/merge_charactor_notop.png");
	ImageIcon charactor_nobottom = new ImageIcon("images/merge_charactor_nobottom.png");
	ImageIcon hair1 = new ImageIcon("images/merge_hair1.png");
	ImageIcon hair2 = new ImageIcon("images/merge_hair2.png");
	ImageIcon hair3 = new ImageIcon("images/merge_hair3.png");
	ImageIcon hair4 = new ImageIcon("images/merge_hair4.png");
	ImageIcon hair5 = new ImageIcon("images/merge_hair5.png");
	ImageIcon top1 = new ImageIcon("images/merge_top1.png");
	ImageIcon top2 = new ImageIcon("images/merge_top2.png");
	ImageIcon top3 = new ImageIcon("images/merge_top3.png");
	ImageIcon top4 = new ImageIcon("images/merge_top4.png");
	ImageIcon top5 = new ImageIcon("images/merge_top5.png");
	ImageIcon top6 = new ImageIcon("images/merge_top6.png");
	ImageIcon bottom1 = new ImageIcon("images/merge_bottom1.png");
	ImageIcon bottom2 = new ImageIcon("images/merge_bottom2.png");
	ImageIcon bottom3 = new ImageIcon("images/merge_bottom3.png");
	ImageIcon bottom4 = new ImageIcon("images/merge_bottom4.png");
	ImageIcon bottom5 = new ImageIcon("images/merge_bottom5.png");
	
	JLabel character_l = new JLabel(character);
	JLabel charactor_nohair_l = new JLabel(charactor_nohair);
	JLabel charactor_notop_l = new JLabel(charactor_notop);
	JLabel charactor_nobottom_l = new JLabel(charactor_nobottom);
	JLabel hair1_l = new JLabel(hair1);
	JLabel hair2_l = new JLabel(hair2);
	JLabel hair3_l = new JLabel(hair3);
	JLabel hair4_l = new JLabel(hair4);
	JLabel hair5_l = new JLabel(hair5);
	JLabel top1_l = new JLabel(top1);
	JLabel top2_l = new JLabel(top2);
	JLabel top3_l = new JLabel(top3);
	JLabel top4_l = new JLabel(top4);
	JLabel top5_l = new JLabel(top5);
	JLabel top6_l = new JLabel(top6);
	JLabel bottom1_l = new JLabel(bottom1);
	JLabel bottom2_l = new JLabel(bottom2);
	JLabel bottom3_l = new JLabel(bottom3);
	JLabel bottom4_l = new JLabel(bottom4);
	JLabel bottom5_l = new JLabel(bottom5);
	private ImageIcon img_hair1 = new ImageIcon("images/closet_hair1.png");
	private ImageIcon img_hair2 = new ImageIcon("images/closet_hair2.png");
	private ImageIcon img_hair3 = new ImageIcon("images/closet_hair3.png");
	private ImageIcon img_hair4 = new ImageIcon("images/closet_hair4.png");
//	private ImageIcon hair5 = new ImageIcon("images/closet_hair5.png");
	
	private ImageIcon img_top1 = new ImageIcon("images/closet_top1.png");
	private ImageIcon img_top2 = new ImageIcon("images/closet_top2.png");
	private ImageIcon img_top3 = new ImageIcon("images/closet_top3.png");
	private ImageIcon img_top4 = new ImageIcon("images/closet_top4.png");
	private ImageIcon img_top5 = new ImageIcon("images/closet_top5.png");
	private ImageIcon img_top6 = new ImageIcon("images/closet_top6.png");
	
	private ImageIcon img_bottom1 = new ImageIcon("images/closet_bottom1.png");
	private ImageIcon img_bottom2 = new ImageIcon("images/closet_bottom2.png");
	private ImageIcon img_bottom3 = new ImageIcon("images/closet_bottom3.png");
	private ImageIcon img_bottom4 = new ImageIcon("images/closet_bottom4.png");
	private ImageIcon img_bottom5 = new ImageIcon("images/closet_bottom5.png");
	
	private JLabel hair_label1 = new JLabel(hair1);
	private JLabel hair_label2 = new JLabel(hair2);
	private JLabel hair_label3 = new JLabel(hair3);
	private JLabel hair_label4 = new JLabel(hair4);
//	private JLabel hair_label5 = new JLabel(hair5);
	
	private JLabel top_label1 = new JLabel(top1);
	private JLabel top_label2 = new JLabel(top2);
	private JLabel top_label3 = new JLabel(top3);
	private JLabel top_label4 = new JLabel(top4);
	private JLabel top_label5 = new JLabel(top5);
	private JLabel top_label6 = new JLabel(top6);
	
	private JLabel bottom_label1 = new JLabel(bottom1);
	private JLabel bottom_label2 = new JLabel(bottom2);
	private JLabel bottom_label3 = new JLabel(bottom3);
	private JLabel bottom_label4 = new JLabel(bottom4);
	private JLabel bottom_label5 = new JLabel(bottom5);
	ImageIcon hair_normal = new ImageIcon("images/btn_hair_normal.png");
	ImageIcon top_normal = new ImageIcon("images/btn_top_normal.png");
	ImageIcon bottom_normal = new ImageIcon("images/btn_bottom_normal.png");
	
	String[] typelist = {"머리","상의","하의"};
	JButton btn_menu_hair,btn_menu_top,btn_menu_bottom,btn_reset,btn_save;
	
	MbtiMainUI main;
	
	public ClosetUI(MbtiMainUI main) {
		this.main = main;
		
//		main.secondFrame.setSize(900,700);
		main.secondFrame.setTitle("내 옷장");
		
		setSize(900,700);
//		main.secondFrame.setResizable(false); --jiwon
		
		screenSizeLocation();
		init();
	}
	
	
	public void init() {
		setLayout(new BorderLayout());
		main.secondFrame.revalidate();
//		main.secondFrame.setLayout(new BorderLayout());
//		JPanel closet_panel = new JPanel(new GridLayout(1,1));
		con = new JPanel();
		con.setLayout(null);
		
		
		btn_menu_hair = new JButton("머리");
		btn_menu_hair.setFont(Commons.getFont());
//			btn_menu.setPreferredSize(new Dimension(90,27));
//			type_panel.add(btn_menu);
//			btn_type_list.add(btn_menu);
		btn_menu_hair.setBounds(450,70,120,30);
		con.add(btn_menu_hair);
		btn_menu_hair.addMouseListener(this);
		
		btn_menu_top = new JButton("상의");
		btn_menu_top.setFont(Commons.getFont());
//			btn_menu.setPreferredSize(new Dimension(90,27));
//			type_panel.add(btn_menu);
//			btn_type_list.add(btn_menu);
		btn_menu_top.setBounds(570,70,120,30);
		con.add(btn_menu_top);
		btn_menu_top.addMouseListener(this);
		
		btn_menu_bottom = new JButton("하의");
		btn_menu_bottom.setFont(Commons.getFont());
//			btn_menu.setPreferredSize(new Dimension(90,27));
//			type_panel.add(btn_menu);
//			btn_type_list.add(btn_menu);
		btn_menu_bottom.setBounds(690,70,120,30);
		con.add(btn_menu_bottom);
		btn_menu_bottom.addMouseListener(this);
		
		
		btn_reset = new JButton("모두 벗기");
		btn_save = new JButton("저장");
		btn_reset.setBounds(500, 370, 100, 30);
		btn_save.setBounds(660, 370, 100, 30);
		con.add(btn_reset);
		con.add(btn_save);
		btn_reset.addMouseListener(this);
		btn_save.addMouseListener(this);
		
		
//		btn_hair = new JButton(img_hair1);
//		btn_top = new JButton(img_top1);
//		btn_bottom = new JButton(img_bottom1);
		
		character_l.setBounds(10,20,300,500);
//		charactor_nohair_l.setBounds(10,20,300,500);
//		charactor_notop_l.setBounds(10,20,300,500);
//		charactor_nobottom_l.setBounds(10,20,300,500);
		con.add(character_l);
//		con.add(charactor_nohair_l);
//		con.add(charactor_notop_l);
//		con.add(charactor_nobottom_l);
		
//		btn_hair.setBounds(450,35,170,170);
//		btn_top.setBounds(450,200,170,170);
//		btn_bottom.setBounds(450,360,170,170);
//		con.add(btn_hair);
//		con.add(btn_top);
//		con.add(btn_bottom);
//		
//		closet_panel.add(con);
		
//		add(con);
//		setVisible(true);
//		main.mypage_panel.setLayout(new BorderLayout());
//		main.mypage_panel.setSize(900, 700);
//		main.mypage_panel.add(con,BorderLayout.CENTER);
//		main.content_panel.add(main.mypage_panel);
		
		main.secondFrame.add(con);
		main.secondFrame.setVisible(true);
		
//		main.mypage_panel.setLayout(new BorderLayout());
//		main.mypage_panel.setSize(900,500);
//		main.mypage_panel.add(con);
//		main.content_panel.add(main.mypage_panel);
//		main.secondFrame.setVisible(true);
		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(700,700);
//		this.setVisible(true);
		
//		btn_hair.addActionListener(this);
//		btn_top.addActionListener(this);
//		btn_bottom.addActionListener(this);
//		btn_hair.addMouseListener(this);
//		btn_top.addMouseListener(this);
//		btn_bottom.addMouseListener(this);
	}
	
	public void screenSizeLocation() {
		Dimension frameSize = getSize();
		Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn_hair1) {
				con.add(hair1_l);
				character_l.setVisible(false);
				hair1_l.setVisible(true);
				hair2_l.setVisible(false);
				hair3_l.setVisible(false);
				hair4_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				hair1_l.setBounds(10,20,300,500);
		}else if(obj == btn_hair2) {
				con.add(hair2_l);
				character_l.setVisible(false);
				hair2_l.setVisible(true);
				hair1_l.setVisible(false);
				hair3_l.setVisible(false);
				hair4_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				hair2_l.setBounds(10,20,300,500);
		}else if(obj == btn_hair3) {
				con.add(hair3_l);
				character_l.setVisible(false);
				hair3_l.setVisible(true);
				hair2_l.setVisible(false);
				hair1_l.setVisible(false);
				hair4_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				hair3_l.setBounds(10,20,300,500);
		}else if(obj == btn_hair4) {
				con.add(hair4_l);
				character_l.setVisible(false);
				hair4_l.setVisible(true);
				hair3_l.setVisible(false);
				hair2_l.setVisible(false);
				hair1_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				hair4_l.setBounds(10,20,300,500);
//			main.secondFrame.repaint();
		}else if(obj == btn_top1) {
				con.add(top1_l);
				character_l.setVisible(false);
				top1_l.setVisible(true);
				top2_l.setVisible(false);
				top3_l.setVisible(false);
				top4_l.setVisible(false);
				top5_l.setVisible(false);
				top6_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				top1_l.setBounds(10,20,300,500);
		}else if(obj == btn_top2) {
				con.add(top2_l);
				character_l.setVisible(false);
				top2_l.setVisible(true);
				top3_l.setVisible(false);
				top4_l.setVisible(false);
				top5_l.setVisible(false);
				top1_l.setVisible(false);
				top6_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				top2_l.setBounds(10,20,300,500);
		}else if(obj == btn_top3) {
				con.add(top3_l);
				character_l.setVisible(false);
				top3_l.setVisible(true);
				top4_l.setVisible(false);
				top5_l.setVisible(false);
				top1_l.setVisible(false);
				top2_l.setVisible(false);
				top6_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				top3_l.setBounds(10,20,300,500);
		}else if(obj == btn_top4) {
				con.add(top4_l);
				character_l.setVisible(false);
				top4_l.setVisible(true);
				top5_l.setVisible(false);
				top1_l.setVisible(false);
				top2_l.setVisible(false);
				top3_l.setVisible(false);
				top6_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				top4_l.setBounds(10,20,300,500);
		}else if(obj == btn_top5) {
				con.add(top5_l);
				character_l.setVisible(false);
				top5_l.setVisible(true);
				top1_l.setVisible(false);
				top2_l.setVisible(false);
				top3_l.setVisible(false);
				top4_l.setVisible(false);
				top6_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				top5_l.setBounds(10,20,300,500);
		}else if(obj == btn_top6) {
				con.add(top6_l);
				character_l.setVisible(false);
				top1_l.setVisible(false);
				top2_l.setVisible(false);
				top3_l.setVisible(false);
				top4_l.setVisible(false);
				top5_l.setVisible(false);
				top6_l.setVisible(true);
				con.repaint();
				main.secondFrame.revalidate();
				top6_l.setBounds(10,20,300,500);
//			main.secondFrame.repaint();
		}else if(obj == btn_bottom1) {
				con.add(bottom1_l);
				character_l.setVisible(false);
				bottom1_l.setVisible(true);
				bottom2_l.setVisible(false);
				bottom3_l.setVisible(false);
				bottom4_l.setVisible(false);
				bottom5_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				bottom1_l.setBounds(10,20,300,500);
		}else if(obj == btn_bottom2) {
				con.add(bottom2_l);
				character_l.setVisible(false);
				bottom2_l.setVisible(true);
				bottom1_l.setVisible(false);
				bottom3_l.setVisible(false);
				bottom4_l.setVisible(false);
				bottom5_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				bottom2_l.setBounds(10,20,300,500);
		}else if(obj == btn_bottom3) {
				con.add(bottom3_l);
				character_l.setVisible(false);
				bottom3_l.setVisible(true);
				bottom1_l.setVisible(false);
				bottom2_l.setVisible(false);
				bottom4_l.setVisible(false);
				bottom5_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				bottom3_l.setBounds(10,20,300,500);
		}else if(obj == btn_bottom4) {
				con.add(bottom4_l);
				character_l.setVisible(false);
				bottom1_l.setVisible(false);
				bottom2_l.setVisible(false);
				bottom3_l.setVisible(false);
				bottom4_l.setVisible(true);
				bottom5_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				bottom4_l.setBounds(10,20,300,500);
		}else if(obj == btn_bottom5) {
				con.add(bottom5_l);
				character_l.setVisible(false);
				bottom5_l.setVisible(true);
				bottom1_l.setVisible(false);
				bottom2_l.setVisible(false);
				bottom3_l.setVisible(false);
				bottom4_l.setVisible(false);
				con.repaint();
				main.secondFrame.revalidate();
				bottom5_l.setBounds(10,20,300,500);
		}
		
//			main.secondFrame.repaint();
		
		if(obj == btn_menu_hair) {
			if(btn_top1 != null) {
//				con.remove(btn_top);
//				con.removeAll();
//				init();
				con.remove(btn_top1);
				con.remove(btn_top2);
				con.remove(btn_top3);
				con.remove(btn_top4);
				con.remove(btn_top5);
				con.remove(btn_top6);
			}
			if(btn_bottom1 != null) {
//				con.remove(btn_bottom);
				con.remove(btn_bottom1);
				con.remove(btn_bottom2);
				con.remove(btn_bottom3);
				con.remove(btn_bottom4);
				con.remove(btn_bottom5);
			}

//			btn_top.setVisible(false);
//			btn_bottom.setVisible(false);
			btn_hair1 = new JButton(img_hair1);
			con.add(btn_hair1);
			btn_hair1.addMouseListener(this);
			btn_hair1.setBounds(450,150,90,90);
			
			btn_hair2 = new JButton(img_hair2);
			con.add(btn_hair2);
			btn_hair2.addMouseListener(this);
			btn_hair2.setBounds(540,150,90,90);
			
			btn_hair3 = new JButton(img_hair3);
			con.add(btn_hair3);
			btn_hair3.addMouseListener(this);
			btn_hair3.setBounds(630,150,90,90);
			
			btn_hair4 = new JButton(img_hair4);
			con.add(btn_hair4);
			btn_hair4.addMouseListener(this);
			btn_hair4.setBounds(720,150,90,90);
			
			
		}else if(obj == btn_menu_top) {
			if(btn_hair1 != null) {
//				con.remove(btn_hair);
				con.remove(btn_hair1);
				con.remove(btn_hair2);
				con.remove(btn_hair3);
				con.remove(btn_hair4);
			}
			if(btn_bottom1 != null) {
//				con.remove(btn_bottom);
				con.remove(btn_bottom1);
				con.remove(btn_bottom2);
				con.remove(btn_bottom3);
				con.remove(btn_bottom4);
				con.remove(btn_bottom5);
			}
//			btn_hair.setVisible(false);
//			btn_bottom.setVisible(false);
			btn_top1 = new JButton(img_top1);
			con.add(btn_top1);
			btn_top1.addMouseListener(this);
			btn_top1.setBounds(450,150,90,90);
			
			btn_top2 = new JButton(img_top2);
			con.add(btn_top2);
			btn_top2.addMouseListener(this);
			btn_top2.setBounds(540,150,90,90);
			
			btn_top3 = new JButton(img_top3);
			con.add(btn_top3);
			btn_top3.addMouseListener(this);
			btn_top3.setBounds(630,150,90,90);
			
			btn_top4 = new JButton(img_top4);
			con.add(btn_top4);
			btn_top4.addMouseListener(this);
			btn_top4.setBounds(720,150,90,90);
			
			btn_top5 = new JButton(img_top5);
			con.add(btn_top5);
			btn_top5.addMouseListener(this);
			btn_top5.setBounds(450,240,90,90);
			
			btn_top6 = new JButton(img_top6);
			con.add(btn_top6);
			btn_top6.addMouseListener(this);
			btn_top6.setBounds(540,240,90,90);
		}else if(obj == btn_menu_bottom) {
			if(btn_top1 != null) {
//				con.remove(btn_top);
//				con.removeAll();
//				init();
				con.remove(btn_top1);
				con.remove(btn_top2);
				con.remove(btn_top3);
				con.remove(btn_top4);
				con.remove(btn_top5);
				con.remove(btn_top6);
			}
			if(btn_hair1 != null) {
//				con.remove(btn_hair);
				con.remove(btn_hair1);
				con.remove(btn_hair2);
				con.remove(btn_hair3);
				con.remove(btn_hair4);
			}
//			btn_hair.setVisible(false);
//			btn_top.setVisible(false);
			btn_bottom1 = new JButton(img_bottom1);
			con.add(btn_bottom1);
			btn_bottom1.addMouseListener(this);
			btn_bottom1.setBounds(450,150,90,90);
			
			btn_bottom2 = new JButton(img_bottom2);
			con.add(btn_bottom2);
			btn_bottom2.addMouseListener(this);
			btn_bottom2.setBounds(540,150,90,90);
			
			btn_bottom3 = new JButton(img_bottom3);
			con.add(btn_bottom3);
			btn_bottom3.addMouseListener(this);
			btn_bottom3.setBounds(630,150,90,90);
			
			btn_bottom4 = new JButton(img_bottom4);
			con.add(btn_bottom4);
			btn_bottom4.addMouseListener(this);
			btn_bottom4.setBounds(720,150,90,90);
			
			btn_bottom5 = new JButton(img_bottom5);
			con.add(btn_bottom5);
			btn_bottom5.addMouseListener(this);
			btn_bottom5.setBounds(450,240,90,90);
			
		}else if(obj == btn_reset) {
			character_l.setVisible(true);
			hair1_l.setVisible(false);
			hair2_l.setVisible(false);
			hair3_l.setVisible(false);
			hair4_l.setVisible(false);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top6_l.setVisible(false);
			bottom1_l.setVisible(false);
			bottom2_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(false);
			bottom5_l.setVisible(false);
		}else if(obj == btn_save) {
			
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
