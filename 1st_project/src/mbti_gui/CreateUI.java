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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateUI implements ActionListener{
	//Field
	MainUI main;
	JPanel point_panel, center_panel, hair_panel, top_panel, bottom_panel, 
		   text_panel, h_text_panel, t_text_panel, b_text_panel;
	
	JButton btn_hair, btn_top, btn_bottom;
	JLabel point_label, hair_label, top_label, bottom_label, text_label;
	ImageIcon hair_normal, hair_rollover, hair_pressed, 
			  top_normal, top_rollover, top_pressed,
			  bottom_normal, bottom_rollover, bottom_pressed;
	
	//Constructor
	public CreateUI(MainUI main) {
		this.main = main;
		init();
	}
	
	//Method
	public void init() {
		main.switch_panel(MainUI.CREATE);
		/** Æ÷ÀÎÆ® ÆÐ³Î **/
		point_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,50));
		point_label = new JLabel("³» Æ÷ÀÎÆ® : 0 point");
		point_label.setFont(Commons.getFont2());
		point_panel.add(point_label);
		
		/** ¼¾ÅÍ ÆÐ³Î **/
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
		
		/** ÅØ½ºÆ® ÆÐ³Î **/
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
		
		/** È­¸é ±¸¼º **/
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
			random_hair();
		}else if(obj == btn_top) {
			random_top();
		}else if(obj == btn_bottom) {
			random_bottom();
		}
		
	}
	
	/** »Ì±â Ã¢ **/
	public void random_hair() {
		JFrame f = new JFrame("Â¥ÀÜ! ¸ÚÁø Çì¾î ´çÃ·!");
		JPanel p = new JPanel(new BorderLayout());
//		Random ran = new Random();
		ImageIcon hair1 = new ImageIcon("images/hair1.png");
		ImageIcon hair2 = new ImageIcon("images/hair2.png");
		ImageIcon hair3 = new ImageIcon("images/hair3.png");
		ImageIcon hair4 = new ImageIcon("images/hair4.png");
		ImageIcon hair5 = new ImageIcon("images/hair5.png");
		
//		int[] photos = {top1, top2, top3, top4, top5, top6};
		
		JLabel l = new JLabel(hair1);
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
	}
	
	public void random_top() {
		JFrame f = new JFrame("Â¥ÀÜ! ¸ÚÁø »óÀÇ ´çÃ·!");
		JPanel p = new JPanel(new BorderLayout());
//		Random ran = new Random();
		ImageIcon top1 = new ImageIcon("images/top1.png");
		ImageIcon top2 = new ImageIcon("images/top2.png");
		ImageIcon top3 = new ImageIcon("images/top3.png");
		ImageIcon top4 = new ImageIcon("images/top4.png");
		ImageIcon top5 = new ImageIcon("images/top5.png");
		ImageIcon top6 = new ImageIcon("images/top6.png");
		
//		int[] photos = {top1, top2, top3, top4, top5, top6};
		
		JLabel l = new JLabel(top1);
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
	}
	
	public void random_bottom() {
		JFrame f = new JFrame("Â¥ÀÜ! ¸ÚÁø ¹ÙÁö ´çÃ·!");
		JPanel p = new JPanel(new BorderLayout());
//		Random ran = new Random();
		ImageIcon bottom1 = new ImageIcon("images/bottom1.png");
		ImageIcon bottom2 = new ImageIcon("images/bottom2.png");
		ImageIcon bottom3 = new ImageIcon("images/bottom3.png");
		ImageIcon bottom4 = new ImageIcon("images/bottom4.png");
		ImageIcon bottom5 = new ImageIcon("images/bottom5.png");
		
//		int[] photos = {top1, top2, top3, top4, top5, top6};
		
		JLabel l = new JLabel(bottom1);
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
	}
	

}
