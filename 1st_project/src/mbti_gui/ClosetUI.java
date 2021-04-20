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
import java.util.ArrayList;

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
	
	ArrayList<ImageIcon> cl_list = new ArrayList<ImageIcon>();
	ArrayList<JButton> btn_list = new ArrayList<JButton>();
	ArrayList<JLabel> label_list = new ArrayList<JLabel>();
	
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
	
	int index=0;
//	JButton btn_hair;

	public ClosetUI(MbtiMainUI main) {
		this.main = main;
		init();
	}

	public void init() {
		
		setLayout(new BorderLayout());
//		setSize(900,700);
		setPreferredSize(new Dimension(550,500));
		setBackground(Color.white);
		con = new JPanel();
		con.setSize(900,700);
		character_l.setBounds(10,20,300,500);
//		con.add(character_l);				 //#####################
		add(character_l,BorderLayout.WEST);  //#####################
		
		
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
			System.out.println("hair?");
			
			int i=0;
			cl_list.clear();
			label_list.clear();
			
			for(UserItemVO uitem : main.system.searchHairItem(main.id_tf.getText())) {
				cl_list.add(new ImageIcon(uitem.getI_closet()));
				btn_list.add(new JButton(cl_list.get(i)));
				btn_list.get(i).addMouseListener(this);
				label_list.add(new JLabel(new ImageIcon(uitem.getI_content())));
				img_p.add(btn_list.get(i));
				i++;
			}
			
			
			revalidate();
		}else if(obj == btn_menu_top) {
			con.repaint();
			img_p.removeAll();
			img_p.repaint();
			
			int i=0;
			cl_list.clear();
			label_list.clear();
			for(UserItemVO uitem : main.system.searchTopItem(main.id_tf.getText())) {
				cl_list.add(new ImageIcon(uitem.getI_closet()));
				btn_list.add(new JButton(cl_list.get(i)));
				btn_list.get(i).addMouseListener(this);
				label_list.add(new JLabel(new ImageIcon(uitem.getI_content())));
				img_p.add(btn_list.get(i));
				i++;
			}
			
			revalidate();
		}else if(obj == btn_menu_bottom) {
			con.repaint();
			img_p.removeAll();
			img_p.repaint();
			
			int i=0;
			cl_list.clear();
			label_list.clear();
			for(UserItemVO uitem : main.system.searchBottomItem(main.id_tf.getText())) {
				cl_list.add(new ImageIcon(uitem.getI_closet()));
				btn_list.add(new JButton(cl_list.get(i)));
				btn_list.get(i).addMouseListener(this);
				label_list.add(new JLabel(new ImageIcon(uitem.getI_content())));
				img_p.add(btn_list.get(i));
				i++;
			}
			
			revalidate();
		}else if(obj == btn_reset) {
			
			character_l.setVisible(true);
			for(int i=0;i<label_list.size();i++) {
				label_list.get(i).setVisible(false);
			}
			
			
			add(character_l,BorderLayout.WEST);	//#####################
			con.repaint();
			revalidate();
			
		}else if(obj == btn_save) {
			
		}else {
			for(int i=0;i<cl_list.size();i++) {
				if(obj == btn_list.get(i)) {
					character_l.setVisible(false);
					label_list.get(index).setVisible(false);
					label_list.get(i).setVisible(true);
					add(label_list.get(i),BorderLayout.WEST);
					index = i;
				}
			}
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