package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyClosetUI extends JPanel implements ActionListener, MouseListener{
	JButton btn_hair1,btn_hair2,btn_hair3,btn_hair4,btn_top1,btn_top2,btn_top3,btn_top4,btn_top5,btn_top6, btn_bottom1,btn_bottom2,btn_bottom3,btn_bottom4,btn_bottom5;

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
	
	JPanel panel,menu_p,btn_p,img_p;
	Container con;
	
	public MyClosetUI() {
		init();
	}
	
	public void init() {
//		System.out.println("sss:"+character_l.getSize());
		
		setLayout(new BorderLayout());
		setSize(900,700);
		con = new JPanel();
		con.setSize(900,700);
		character_l.setBounds(10,20,300,500);
		con.add(character_l);
		add(con,BorderLayout.WEST);
		
		panel = new JPanel(new BorderLayout());
		img_p = new JPanel(new GridLayout(2,4));
		menu_p = new JPanel(new BorderLayout());
		btn_menu_hair = new JButton("머리");
		btn_menu_hair.setFont(Commons.getFont());
//		btn_menu_hair.setBounds(450,70,120,30);
		btn_menu_hair.addMouseListener(this);
		menu_p.add(btn_menu_hair,BorderLayout.WEST);
		btn_menu_top = new JButton("상의");
		btn_menu_top.setFont(Commons.getFont());
//		btn_menu_top.setBounds(570,70,120,30);
		menu_p.add(btn_menu_top,BorderLayout.CENTER);
		btn_menu_top.addMouseListener(this);
		btn_menu_bottom = new JButton("하의");
		btn_menu_bottom.setFont(Commons.getFont());
//		btn_menu_bottom.setBounds(690,70,120,30);
		menu_p.add(btn_menu_bottom,BorderLayout.EAST);
		btn_menu_bottom.addMouseListener(this);
		panel.add(menu_p,BorderLayout.NORTH);
		panel.add(img_p,BorderLayout.CENTER);
		
		btn_p = new JPanel(new BorderLayout());
		btn_reset = new JButton("모두 벗기");
		btn_save = new JButton("저장");
		btn_reset.setBounds(500, 370, 100, 30);
		btn_save.setBounds(660, 370, 100, 30);
		con.add(btn_reset);
		con.add(btn_save);
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
//			if(btn_top1 != null) {
//				img_p.remove(btn_top1);
//				img_p.remove(btn_top2);
//				img_p.remove(btn_top3);
//				img_p.remove(btn_top4);
//				img_p.remove(btn_top5);
//				img_p.remove(btn_top6);
//			}
//			if(btn_bottom1 != null) {
//				img_p.remove(btn_bottom1);
//				img_p.remove(btn_bottom2);
//				img_p.remove(btn_bottom3);
//				img_p.remove(btn_bottom4);
//				img_p.remove(btn_bottom5);
//			}
			img_p.removeAll();
			btn_hair1 = new JButton(img_hair1);
//			btn_hair1.setBounds(450,150,90,90);
			img_p.add(btn_hair1);
			btn_hair1.addMouseListener(this);
			
			btn_hair2 = new JButton(img_hair2);
//			btn_hair2.setBounds(540,150,90,90);
			img_p.add(btn_hair2);
			btn_hair2.addMouseListener(this);
			
			btn_hair3 = new JButton(img_hair3);
//			btn_hair3.setBounds(630,150,90,90);
			img_p.add(btn_hair3);
			btn_hair3.addMouseListener(this);
			
			btn_hair4 = new JButton(img_hair4);
//			btn_hair4.setBounds(720,150,90,90);
			img_p.add(btn_hair4);
			btn_hair4.addMouseListener(this);
			
			revalidate();
		}else if(obj == btn_menu_top) {
//			if(btn_hair1 != null) {
//				img_p.remove(btn_hair1);
//				img_p.remove(btn_hair2);
//				img_p.remove(btn_hair3);
//				img_p.remove(btn_hair4);
//			}
//			if(btn_bottom1 != null) {
//				img_p.remove(btn_bottom1);
//				img_p.remove(btn_bottom2);
//				img_p.remove(btn_bottom3);
//				img_p.remove(btn_bottom4);
//				img_p.remove(btn_bottom5);
//			}
			img_p.removeAll();
			btn_top1 = new JButton(img_top1);
//			btn_top1.setBounds(450,150,90,90);
			img_p.add(btn_top1);
			btn_top1.addMouseListener(this);
			
			btn_top2 = new JButton(img_top2);
//			btn_top2.setBounds(540,150,90,90);
			img_p.add(btn_top2);
			btn_top2.addMouseListener(this);
			
			btn_top3 = new JButton(img_top3);
//			btn_top3.setBounds(630,150,90,90);
			img_p.add(btn_top3);
			btn_top3.addMouseListener(this);
			
			btn_top4 = new JButton(img_top4);
//			btn_top4.setBounds(720,150,90,90);
			img_p.add(btn_top4);
			btn_top4.addMouseListener(this);
			
			btn_top5 = new JButton(img_top5);
//			btn_top5.setBounds(450,240,90,90);
			img_p.add(btn_top5);
			btn_top5.addMouseListener(this);
			
			btn_top6 = new JButton(img_top6);
//			btn_top6.setBounds(540,240,90,90);
			img_p.add(btn_top6);
			btn_top6.addMouseListener(this);
			
			revalidate();

		}else if(obj == btn_menu_bottom) {
//			if(btn_top1 != null) {
//				img_p.remove(btn_top1);
//				img_p.remove(btn_top2);
//				img_p.remove(btn_top3);
//				img_p.remove(btn_top4);
//				img_p.remove(btn_top5);
//				img_p.remove(btn_top6);
//			}
//			if(btn_hair1 != null) {
//				img_p.remove(btn_hair1);
//				img_p.remove(btn_hair2);
//				img_p.remove(btn_hair3);
//				img_p.remove(btn_hair4);
//			}
			img_p.removeAll();
			btn_bottom1 = new JButton(img_bottom1);
//			btn_bottom1.setBounds(450,150,90,90);
			img_p.add(btn_bottom1);
			btn_bottom1.addMouseListener(this);
			
			btn_bottom2 = new JButton(img_bottom2);
//			btn_bottom2.setBounds(540,150,90,90);
			img_p.add(btn_bottom2);
			btn_bottom2.addMouseListener(this);
			
			btn_bottom3 = new JButton(img_bottom3);
//			btn_bottom3.setBounds(630,150,90,90);
			img_p.add(btn_bottom3);
			btn_bottom3.addMouseListener(this);
			
			btn_bottom4 = new JButton(img_bottom4);
//			btn_bottom4.setBounds(720,150,90,90);
			img_p.add(btn_bottom4);
			btn_bottom4.addMouseListener(this);
			
			btn_bottom5 = new JButton(img_bottom5);
//			btn_bottom5.setBounds(450,240,90,90);
			img_p.add(btn_bottom5);
			btn_bottom5.addMouseListener(this);
			
			revalidate();

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
			
		}else if(obj == btn_hair1) {
			hair1_l.setBounds(10,20,300,500);
			con.add(hair1_l);
			character_l.setVisible(false);
			hair1_l.setVisible(true);
			hair2_l.setVisible(false);
			hair3_l.setVisible(false);
			hair4_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_hair2) {
			hair2_l.setBounds(10,20,300,500);
			con.add(hair2_l);
			character_l.setVisible(false);
			hair2_l.setVisible(true);
			hair1_l.setVisible(false);
			hair3_l.setVisible(false);
			hair4_l.setVisible(false);
			con.repaint();
			revalidate();
		}else if(obj == btn_hair3) {
			hair3_l.setBounds(10,20,300,500);
			con.add(hair3_l);
			character_l.setVisible(false);
			hair3_l.setVisible(true);
			hair2_l.setVisible(false);
			hair1_l.setVisible(false);
			hair4_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_hair4) {
			hair4_l.setBounds(10,20,300,500);
			con.add(hair4_l);
			character_l.setVisible(false);
			hair4_l.setVisible(true);
			hair3_l.setVisible(false);
			hair2_l.setVisible(false);
			hair1_l.setVisible(false);
			con.repaint();
			revalidate();

//		main.secondFrame.repaint();
		}else if(obj == btn_top1) {
			top1_l.setBounds(10,20,300,500);
			con.add(top1_l);
			character_l.setVisible(false);
			top1_l.setVisible(true);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top6_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_top2) {
			top2_l.setBounds(10,20,300,500);
			con.add(top2_l);
			character_l.setVisible(false);
			top2_l.setVisible(true);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top1_l.setVisible(false);
			top6_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_top3) {
			top3_l.setBounds(10,20,300,500);
			con.add(top3_l);
			character_l.setVisible(false);
			top3_l.setVisible(true);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top6_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_top4) {
			top4_l.setBounds(10,20,300,500);
			con.add(top4_l);
			character_l.setVisible(false);
			top4_l.setVisible(true);
			top5_l.setVisible(false);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top6_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_top5) {
		top5_l.setBounds(10,20,300,500);
			con.add(top5_l);
			character_l.setVisible(false);
			top5_l.setVisible(true);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top6_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_top6) {
			top6_l.setBounds(10,20,300,500);
			con.add(top6_l);
			character_l.setVisible(false);
			top1_l.setVisible(false);
			top2_l.setVisible(false);
			top3_l.setVisible(false);
			top4_l.setVisible(false);
			top5_l.setVisible(false);
			top6_l.setVisible(true);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom1) {
			bottom1_l.setBounds(10,20,300,500);
			con.add(bottom1_l);
			character_l.setVisible(false);
			bottom1_l.setVisible(true);
			bottom2_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(false);
			bottom5_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom2) {
			bottom2_l.setBounds(10,20,300,500);
			con.add(bottom2_l);
			character_l.setVisible(false);
			bottom2_l.setVisible(true);
			bottom1_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(false);
			bottom5_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom3) {
			bottom3_l.setBounds(10,20,300,500);
			con.add(bottom3_l);
			character_l.setVisible(false);
			bottom3_l.setVisible(true);
			bottom1_l.setVisible(false);
			bottom2_l.setVisible(false);
			bottom4_l.setVisible(false);
			bottom5_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom4) {
			bottom4_l.setBounds(10,20,300,500);
			con.add(bottom4_l);
			character_l.setVisible(false);
			bottom1_l.setVisible(false);
			bottom2_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(true);
			bottom5_l.setVisible(false);
			con.repaint();
			revalidate();

		}else if(obj == btn_bottom5) {
			bottom5_l.setBounds(10,20,300,500);
			con.add(bottom5_l);
			character_l.setVisible(false);
			bottom5_l.setVisible(true);
			bottom1_l.setVisible(false);
			bottom2_l.setVisible(false);
			bottom3_l.setVisible(false);
			bottom4_l.setVisible(false);
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
