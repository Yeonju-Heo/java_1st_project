package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ClosetUI implements ActionListener {
	//Field
	MbtiMainUI main;
	JPanel char_panel, type_panel, image_panel, btn_panel,reset_panel,save_panel,
			closet_img_panel, closet_panel, char_img_panel, menu_panel;
	String[] typelist = {"머리","상의","하의"};
	ArrayList<JButton> btn_type_list = new ArrayList<JButton>();
	JLabel char_img;
	JButton btn_reset, btn_save;
	ImageIcon character, top_img, top_img2, top_img3, top_img4;
	LineBorder border = new LineBorder(Color.GRAY);
	
	//Constructor
	public ClosetUI(MbtiMainUI main) {
		this.main = main;
		init();
	}
	
	//Method
	public void init() {
		char_panel = new JPanel(new GridLayout(1,1,0,0));
		char_img_panel = new JPanel(new FlowLayout(FlowLayout.LEFT,70,70));
		character = new ImageIcon("images/character.png");
		char_img = new JLabel(character);
		char_img_panel.add(char_img);
		char_panel.add(char_img_panel);
		char_panel.setPreferredSize(new Dimension(300,600));
		
//		closet_panel = new JPanel(new BorderLayout());
//		closet_panel.setPreferredSize(new Dimension(220,10));

		
		menu_panel = new JPanel();
		menu_panel.setLayout(new BorderLayout());
		type_panel = new JPanel(new GridLayout(1,3,3,3));
		for(String name : typelist) {
			JButton btn_menu = new JButton(name);
			btn_menu.setFont(Commons.getFont());
//			btn_menu.setPreferredSize(new Dimension(90,27));
			type_panel.add(btn_menu);
			btn_type_list.add(btn_menu);
			btn_menu.addActionListener(this);
		}
//		type_panel.setPreferredSize(new Dimension(10,10));
//		menu_panel.setPreferredSize(new Dimension(100,00));
		menu_panel.add(type_panel,BorderLayout.NORTH);
		
		menu_panel.setBorder(border);
		
//		closet_img_panel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
//		closet_img_panel.setPreferredSize(new Dimension(90,25));
		image_panel = new JPanel(new GridLayout(1,4,20,20));//옷 사진
		top_img = new ImageIcon("images/closet_top5.png");
		char_img = new JLabel(top_img);
		image_panel.add(char_img,BorderLayout.CENTER);
		top_img2 = new ImageIcon("images/closet_top7.png");
		char_img = new JLabel(top_img2);
		image_panel.add(char_img,BorderLayout.CENTER);
		top_img3 = new ImageIcon("images/closet_top9.png");
		char_img = new JLabel(top_img3);
		image_panel.add(char_img,BorderLayout.CENTER);
		top_img4 = new ImageIcon("images/closet_top3.png");
		char_img = new JLabel(top_img4);
		image_panel.add(char_img);
//		image_panel.setPreferredSize(new Dimension(90,100));
//		closet_img_panel.add(image_panel);
//		closet_img_panel.setBorder(border);
		menu_panel.add(image_panel,BorderLayout.CENTER);
		
		btn_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		reset_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		save_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btn_reset = new JButton("모두 벗기");
		btn_reset.setFont(Commons.getFont());
		btn_reset.setPreferredSize(new Dimension(90,25));
		btn_save = new JButton("저장");
		btn_save.setPreferredSize(new Dimension(90,25));
		btn_save.setFont(Commons.getFont());
		reset_panel.add(btn_reset);
		save_panel.add(btn_save);
		btn_panel.add(reset_panel);
		btn_panel.add(save_panel);
		menu_panel.add(btn_panel,BorderLayout.SOUTH);

		
		
//		closet_panel.add(menu_panel,BorderLayout.CENTER);
//		closet_panel.add(closet_img_panel);
//		closet_panel.add(btn_panel,BorderLayout.SOUTH);
//		closet_panel.setBorder(border);
		
		main.mypage_panel.setLayout(new BorderLayout());
		main.mypage_panel.setSize(900, 700);
//		main.mypage_panel.add(BorderLayout.NORTH,type_panel);
		main.mypage_panel.add(BorderLayout.WEST,char_panel);
		main.mypage_panel.add(BorderLayout.EAST, menu_panel);
		
		main.content_panel.add(main.mypage_panel);
		main.secondFrame.setVisible(true);
		
		btn_reset.addActionListener(this);
		btn_save.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
