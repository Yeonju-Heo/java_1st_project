package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Merge_test_heesu extends JFrame implements ActionListener{
//	JPanel charactor_p, btn_p;
	JButton btn_hair, btn_top, btn_bottom;
	Container con;
	ImageIcon charactor = new ImageIcon("images/merge_charactor.png");
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
	
	JLabel charactor_l = new JLabel(charactor);
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
	
	ImageIcon hair_normal = new ImageIcon("images/btn_hair_normal.png");
	ImageIcon top_normal = new ImageIcon("images/btn_top_normal.png");
	ImageIcon bottom_normal = new ImageIcon("images/btn_bottom_normal.png");
	
	
	public Merge_test_heesu() {
		init();
	}
	
	
	public void init() {
		con = this.getContentPane();
		con.setLayout(null);
		
		btn_hair = new JButton(hair_normal);
		btn_top = new JButton(top_normal);
		btn_bottom = new JButton(bottom_normal);
		
		charactor_l.setBounds(10,20,300,500);
//		charactor_nohair_l.setBounds(10,20,300,500);
//		charactor_notop_l.setBounds(10,20,300,500);
//		charactor_nobottom_l.setBounds(10,20,300,500);
		con.add(charactor_l);
//		con.add(charactor_nohair_l);
//		con.add(charactor_notop_l);
//		con.add(charactor_nobottom_l);
		
		btn_hair.setBounds(450,20,170,170);
		btn_top.setBounds(450,210,170,170);
		btn_bottom.setBounds(450,400,170,170);
		con.add(btn_hair);
		con.add(btn_top);
		con.add(btn_bottom);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setVisible(true);
		
		btn_hair.addActionListener(this);
		btn_top.addActionListener(this);
		btn_bottom.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_hair) {
			hair1_l.setBounds(10,20,300,500);
			this.add(hair1_l);
			charactor_l.setVisible(false);
			hair1_l.setVisible(true);
			this.revalidate();
		}else if(obj == btn_top) {
			top1_l.setBounds(10,20,300,500);
			this.add(top1_l);
			charactor_l.setVisible(false);
			top1_l.setVisible(true);
			this.revalidate();
		}else if(obj == btn_bottom) {
			bottom1_l.setBounds(10,20,300,500);
			this.add(bottom1_l);
			charactor_l.setVisible(false);
			bottom1_l.setVisible(true);
			this.revalidate();
		}
		
	}

}





















