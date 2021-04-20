package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mbti_vo.UserItemVO;

public class ClosetUI extends JPanel implements ActionListener, MouseListener{
	JButton btn_hair1,btn_hair2,btn_hair3,btn_hair4,btn_hair5,btn_top1,btn_top2,btn_top3,btn_top4,btn_top5,btn_top6, btn_bottom1,btn_bottom2,btn_bottom3,btn_bottom4,btn_bottom5;

	ImageIcon character = new ImageIcon("images/merge_charactor.png");

	ImageIcon hair1,hair2, hair3,hair4,hair5;
	ImageIcon top1,top2,top3, top4,top5,top6;
	ImageIcon bottom1,bottom2,bottom3,bottom4,bottom5;
	JLabel character_l = new JLabel(character);
	JLabel hair1_l,hair2_l,hair3_l,hair4_l,hair5_l;
	JLabel top1_l,top2_l,top3_l,top4_l,top5_l,top6_l;
	JLabel bottom1_l,bottom2_l,bottom3_l,bottom4_l,bottom5_l;
	
	private ImageIcon img_hair1 = new ImageIcon("images/closet_hair1.png");
	private ImageIcon img_hair2 = new ImageIcon("images/closet_hair2.png");
	private ImageIcon img_hair3 = new ImageIcon("images/closet_hair3.png");
	private ImageIcon img_hair4 = new ImageIcon("images/closet_hair4.png");
	private ImageIcon img_hair5 = new ImageIcon("images/closet_hair5.png");

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

	JButton btn_menu_hair,btn_menu_top,btn_menu_bottom,btn_reset,btn_save;

	JPanel panel,menu_p,btn_p,img_p;
	Container con;
	
	MbtiMainUI main;
	UserItemVO uitem;

	public ClosetUI(MbtiMainUI main) {
		this.main = main;
		init();
	}

	public void init() {
		main.system.updateUserItem(main.id_tf.getText(), "hair1");
		uitem = main.system.searchItem(main.id_tf.getText());
		setLayout(new BorderLayout());
//		setSize(900,700);
		setPreferredSize(new Dimension(550,500));
		setBackground(Color.white);
		con = new JPanel();
		con.setSize(900,700);
		character_l.setBounds(10,20,300,500);
//		con.add(character_l);				 //#####################
		add(character_l,BorderLayout.WEST);  //#####################
		hair1 = new ImageIcon(uitem.getI_content());
		hair1_l = new JLabel(hair1);
		add(hair1_l,BorderLayout.WEST);
		
		
		panel = new JPanel(new BorderLayout());
		img_p = new JPanel(new GridLayout(0,4,5,5));
		menu_p = new JPanel(new BorderLayout());
		btn_menu_hair = new JButton("헤어");
		btn_menu_hair.setFont(Commons.getFont());
//		btn_menu_hair.setBounds(450,70,120,30);
		btn_menu_hair.setPreferredSize(new Dimension(90,30));
		btn_menu_hair.addMouseListener(this);
		menu_p.add(btn_menu_hair,BorderLayout.WEST);
		btn_menu_top = new JButton("상의");
		btn_menu_top.setFont(Commons.getFont());
		btn_menu_top.setPreferredSize(new Dimension(90,30));
//		btn_menu_top.setBounds(570,70,120,30);
		menu_p.add(btn_menu_top,BorderLayout.CENTER);
		btn_menu_top.addMouseListener(this);
		btn_menu_bottom = new JButton("하의");
		btn_menu_bottom.setFont(Commons.getFont());
		btn_menu_bottom.setPreferredSize(new Dimension(90,30));
//		btn_menu_bottom.setBounds(690,70,120,30);
		menu_p.add(btn_menu_bottom,BorderLayout.EAST);
		btn_menu_bottom.addMouseListener(this);
		panel.add(menu_p,BorderLayout.NORTH);
		panel.add(img_p,BorderLayout.CENTER);

		btn_p = new JPanel(new BorderLayout());
		btn_reset = new JButton("모두 벗기");
		btn_reset.setPreferredSize(new Dimension(90,30));
		btn_save = new JButton("저장");
		btn_save.setPreferredSize(new Dimension(90,30));
//		btn_reset.setBounds(500, 370, 100, 30);
//		btn_save.setBounds(660, 370, 100, 30);
//		con.add(btn_reset);					//#####################
//		con.add(btn_save);					//#####################
		btn_reset.addMouseListener(this);
		btn_save.addMouseListener(this);

		btn_p.add(btn_reset,BorderLayout.WEST);
		btn_p.add(btn_save,BorderLayout.EAST);
		panel.add(btn_p,BorderLayout.SOUTH);
		add(panel,BorderLayout.EAST);
		setVisible(true);



	}




	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn_menu_hair) {
			con.repaint();
			img_p.removeAll();
			img_p.repaint();
			btn_hair1 = new JButton(img_hair1);
			btn_hair1.setPreferredSize(new Dimension(40,40));
			img_p.add(btn_hair1);
			btn_hair1.setBorderPainted(false);
			btn_hair1.setContentAreaFilled(false);
			btn_hair1.setFocusPainted(false);
			btn_hair1.addMouseListener(this);
			
			btn_hair2 = new JButton(img_hair2);
			btn_hair2.setPreferredSize(new Dimension(40,40));
			img_p.add(btn_hair2);
			btn_hair2.setBorderPainted(false);
			btn_hair2.setContentAreaFilled(false);
			btn_hair2.setFocusPainted(false);
			btn_hair2.addMouseListener(this);
			
			btn_hair3 = new JButton(img_hair3);
			btn_hair3.setPreferredSize(new Dimension(40,40));
			img_p.add(btn_hair3);
			btn_hair3.setBorderPainted(false);
			btn_hair3.setContentAreaFilled(false);
			btn_hair3.setFocusPainted(false);
			btn_hair3.addMouseListener(this);
			
			btn_hair4 = new JButton(img_hair4);
			btn_hair4.setPreferredSize(new Dimension(40,40));
//			btn_hair4.setBounds(720,150,90,90);
			img_p.add(btn_hair4);
			btn_hair4.setBorderPainted(false);
			btn_hair4.setContentAreaFilled(false);
			btn_hair4.setFocusPainted(false);
			btn_hair4.addMouseListener(this);
			
			btn_hair5 = new JButton(img_hair5);
			btn_hair5.setPreferredSize(new Dimension(40,40));
			img_p.add(btn_hair5);
			btn_hair5.setBorderPainted(false);
			btn_hair5.setContentAreaFilled(false);
			btn_hair5.setFocusPainted(false);
			btn_hair5.addMouseListener(this);
			
			revalidate();
		}else if(obj == btn_menu_top) {
			img_p.removeAll();
			img_p.repaint();
			btn_top1 = new JButton(img_top1);
//			btn_top1.setBounds(450,150,90,90);
			img_p.add(btn_top1);
			btn_top1.setBorderPainted(false);
			btn_top1.setContentAreaFilled(false);
			btn_top1.setFocusPainted(false);
			btn_top1.addMouseListener(this);
			
			btn_top2 = new JButton(img_top2);
//			btn_top2.setBounds(540,150,90,90);
			img_p.add(btn_top2);
			btn_top2.setBorderPainted(false);
			btn_top2.setContentAreaFilled(false);
			btn_top2.setFocusPainted(false);
			btn_top2.addMouseListener(this);
			
			btn_top3 = new JButton(img_top3);
//			btn_top3.setBounds(630,150,90,90);
			img_p.add(btn_top3);
			btn_top3.setBorderPainted(false);
			btn_top3.setContentAreaFilled(false);
			btn_top3.setFocusPainted(false);
			btn_top3.addMouseListener(this);
			
			btn_top4 = new JButton(img_top4);
//			btn_top4.setBounds(720,150,90,90);
			img_p.add(btn_top4);
			btn_top4.setBorderPainted(false);
			btn_top4.setContentAreaFilled(false);
			btn_top4.setFocusPainted(false);
			btn_top4.addMouseListener(this);
			
			btn_top5 = new JButton(img_top5);
//			btn_top5.setBounds(450,240,90,90);
			img_p.add(btn_top5);
			btn_top5.setBorderPainted(false);
			btn_top5.setContentAreaFilled(false);
			btn_top5.setFocusPainted(false);
			btn_top5.addMouseListener(this);
			
			btn_top6 = new JButton(img_top6);
//			btn_top6.setBounds(540,240,90,90);
			img_p.add(btn_top6);
			btn_top6.setBorderPainted(false);
			btn_top6.setContentAreaFilled(false);
			btn_top6.setFocusPainted(false);
			btn_top6.addMouseListener(this);
			
			revalidate();
		}else if(obj == btn_menu_bottom) {
			con.repaint();
			img_p.removeAll();
			img_p.repaint();
			btn_bottom1 = new JButton(img_bottom1);
//			btn_bottom1.setBounds(450,150,90,90);
			img_p.add(btn_bottom1);
			btn_bottom1.setBorderPainted(false);
			btn_bottom1.setContentAreaFilled(false);
			btn_bottom1.setFocusPainted(false);
			btn_bottom1.addMouseListener(this);
			
			btn_bottom2 = new JButton(img_bottom2);
//			btn_bottom2.setBounds(540,150,90,90);
			img_p.add(btn_bottom2);
			btn_bottom2.setBorderPainted(false);
			btn_bottom2.setContentAreaFilled(false);
			btn_bottom2.setFocusPainted(false);
			btn_bottom2.addMouseListener(this);
			
			btn_bottom3 = new JButton(img_bottom3);
//			btn_bottom3.setBounds(630,150,90,90);
			img_p.add(btn_bottom3);
			btn_bottom3.setBorderPainted(false);
			btn_bottom3.setContentAreaFilled(false);
			btn_bottom3.setFocusPainted(false);
			btn_bottom3.addMouseListener(this);
			
			btn_bottom4 = new JButton(img_bottom4);
//			btn_bottom4.setBounds(720,150,90,90);
			img_p.add(btn_bottom4);
			btn_bottom4.setBorderPainted(false);
			btn_bottom4.setContentAreaFilled(false);
			btn_bottom4.setFocusPainted(false);
			btn_bottom4.addMouseListener(this);
			
			btn_bottom5 = new JButton(img_bottom5);
//			btn_bottom5.setBounds(450,240,90,90);
			img_p.add(btn_bottom5);
			btn_bottom5.setBorderPainted(false);
			btn_bottom5.setContentAreaFilled(false);
			btn_bottom5.setFocusPainted(false);
			btn_bottom5.addMouseListener(this);
			
			revalidate();
		}else if(obj == btn_reset) {
			
			character_l.setVisible(true);
			hair1_l.setVisible(false);
			hair2_l.setVisible(false);
			hair3_l.setVisible(false);
			hair4_l.setVisible(false);
			hair5_l.setVisible(false);
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
			
			add(character_l,BorderLayout.WEST);	//#####################
			con.repaint();
			revalidate();
			
		}else if(obj == btn_save) {

		}else if(obj == btn_hair1) {
			hair1_l.setBounds(10,20,300,500);
			//con.add(hair1_l);				//#####################
			character_l.setVisible(false);
			hair1_l.setVisible(true);
			hair2_l.setVisible(false);
			hair3_l.setVisible(false);
			hair4_l.setVisible(false);
			hair5_l.setVisible(false);
			add(hair1_l,BorderLayout.WEST);  //#####################
			con.repaint();
			revalidate();

		}else if(obj == btn_hair2) {
			hair2_l.setBounds(10,20,300,500);
			//con.add(hair2_l);
			character_l.setVisible(false);
			hair2_l.setVisible(true);
			hair1_l.setVisible(false);
			hair3_l.setVisible(false);
			hair4_l.setVisible(false);
			hair5_l.setVisible(false);
			add(hair2_l,BorderLayout.WEST);
			con.repaint();
			revalidate();
		}else if(obj == btn_hair3) {
			hair3_l.setBounds(10,20,300,500);
			//con.add(hair3_l);
			character_l.setVisible(false);
			hair3_l.setVisible(true);
			hair2_l.setVisible(false);
			hair1_l.setVisible(false);
			hair4_l.setVisible(false);
			hair5_l.setVisible(false);
			add(hair3_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_hair4) {
			hair4_l.setBounds(10,20,300,500);
			//con.add(hair4_l);
			character_l.setVisible(false);
			hair4_l.setVisible(true);
			hair3_l.setVisible(false);
			hair2_l.setVisible(false);
			hair1_l.setVisible(false);
			hair5_l.setVisible(false);
			add(hair4_l,BorderLayout.WEST);
			con.repaint();
			revalidate();
		}else if(obj == btn_hair5) {
			hair5_l.setBounds(10,20,300,500);
			//con.add(hair4_l);
			character_l.setVisible(false);
			hair5_l.setVisible(true);
			hair3_l.setVisible(false);
			hair2_l.setVisible(false);
			hair1_l.setVisible(false);
			hair4_l.setVisible(false);
			add(hair4_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

//		main.secondFrame.repaint();
		}else if(obj == btn_top1) {
			top1_l.setBounds(10,20,300,500);
			//con.add(top1_l);
			character_l.setVisible(false);
			top1_l.setVisible(true);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top6_l.setVisible(false);
			add(top1_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_top2) {
			top2_l.setBounds(10,20,300,500);
			//con.add(top2_l);
			character_l.setVisible(false);
			top2_l.setVisible(true);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top1_l.setVisible(false);
			top6_l.setVisible(false);
			add(top2_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_top3) {
			top3_l.setBounds(10,20,300,500);
			//con.add(top3_l);
			character_l.setVisible(false);
			top3_l.setVisible(true);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top6_l.setVisible(false);
			add(top3_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_top4) {
			top4_l.setBounds(10,20,300,500);
			//con.add(top4_l);
			character_l.setVisible(false);
			top4_l.setVisible(true);
			top5_l.setVisible(false);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top6_l.setVisible(false);
			add(top4_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_top5) {
			top5_l.setBounds(10,20,300,500);
			//con.add(top5_l);
			character_l.setVisible(false);
			top5_l.setVisible(true);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top6_l.setVisible(false);
			add(top5_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_top6) {
			top6_l.setBounds(10,20,300,500);
			//con.add(top6_l);
			character_l.setVisible(false);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top6_l.setVisible(true);
			add(top6_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom1) {
			bottom1_l.setBounds(10,20,300,500);
			//con.add(bottom1_l);
			character_l.setVisible(false);
			bottom1_l.setVisible(true);
			bottom2_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(false);
			bottom5_l.setVisible(false);
			add(bottom1_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom2) {
			bottom2_l.setBounds(10,20,300,500);
			//con.add(bottom2_l);
			character_l.setVisible(false);
			bottom2_l.setVisible(true);
			bottom1_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(false);
			bottom5_l.setVisible(false);
			add(bottom2_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom3) {
			bottom3_l.setBounds(10,20,300,500);
			//con.add(bottom3_l);
			character_l.setVisible(false);
			bottom3_l.setVisible(true);
			bottom1_l.setVisible(false);
			bottom2_l.setVisible(false);
			bottom4_l.setVisible(false);
			bottom5_l.setVisible(false);
			add(bottom3_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom4) {
			bottom4_l.setBounds(10,20,300,500);
			//con.add(bottom4_l);
			character_l.setVisible(false);
			bottom1_l.setVisible(false);
			bottom2_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(true);
			bottom5_l.setVisible(false);
			add(bottom4_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom5) {
			bottom5_l.setBounds(10,20,300,500);
			//con.add(bottom5_l);
			character_l.setVisible(false);
			bottom5_l.setVisible(true);
			bottom1_l.setVisible(false);
			bottom2_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(false);
			add(bottom5_l,BorderLayout.WEST);
			con.repaint();
			revalidate();

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}







}