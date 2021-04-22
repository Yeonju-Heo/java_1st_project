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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mbti_vo.UserItemVO;
import mbti_vo.UserVO;

public class ClosetUI extends JPanel implements ActionListener, MouseListener{
	ImageIcon character,char_reset;
	ImageIcon nohair = new ImageIcon("images/merge_charactor_nohair.png");		
	ImageIcon notop = new ImageIcon("images/merge_charactor_notop.png");		
	ImageIcon nobottom = new ImageIcon("images/merge_charactor_nobottom.png");		
	ImageIcon onlyhair = new ImageIcon("images/merge_hair2.png");		
	ImageIcon onlytop = new ImageIcon("images/merge_charactor_onlytop.png");		
	ImageIcon onlybottom = new ImageIcon("images/merge_charactor_onlybottom.png");		
	JLabel character_l,char_reset_l,nohair_l,notop_l,nobottom_l,onlyhair_l,onlytop_l,onlybottom_l;
	
	ArrayList<ImageIcon> cl_list = new ArrayList<ImageIcon>();//내옷장 안 작은 이미지 리스트
	ArrayList<JButton> btn_list = new ArrayList<JButton>();//내옷장 안 작은 이미지를 버튼으로 만든 리스트
	ArrayList<ImageIcon> ch_list = new ArrayList<ImageIcon>();//캐릭터가 입는 큰 헤어 이미지 리스트
	ArrayList<JLabel> hair_list = new ArrayList<JLabel>();//캐릭터가 입는 큰 이미지 헤어라벨 리스트
	ArrayList<ImageIcon> ct_list = new ArrayList<ImageIcon>();//캐릭터가 입는 큰 상의 이미지 리스트
	ArrayList<JLabel> top_list = new ArrayList<JLabel>();//캐릭터가 입는 큰 이미지 상의라벨 리스트
	ArrayList<ImageIcon> cb_list = new ArrayList<ImageIcon>();//캐릭터가 입는 큰 하의 이미지 리스트
	ArrayList<JLabel> bottom_list = new ArrayList<JLabel>();//캐릭터가 입는 큰 이미지 하의라벨 리스트

	JButton btn_menu_hair,btn_menu_top,btn_menu_bottom,btn_reset,btn_save;

	JPanel panel,menu_p,btn_p,img_p;
	Container con;
	
	MbtiMainUI main;
	UserItemVO uitem;
	UserVO userch;
	int result=0;
	
	int hidx=-1,tidx=-1,bidx=-1,type=-1;
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
		
		
		nohair_l = new JLabel(nohair);
		notop_l = new JLabel(notop);
		nobottom_l = new JLabel(nobottom);
		nohair_l.setBounds(0,2,142,500);
		notop_l.setBounds(0,2,142,500);
		nobottom_l.setBounds(0,2,142,500);
		onlyhair_l = new JLabel(onlyhair);
		onlytop_l = new JLabel(onlytop);
		onlybottom_l = new JLabel(onlybottom);
		onlyhair_l.setBounds(0,2,142,500);
		onlytop_l.setBounds(0,2,142,500);
		onlybottom_l.setBounds(0,2,142,500);
		
		char_reset = new ImageIcon("images/merge_charactor.png");
		char_reset_l = new JLabel(char_reset);
		
		userch = main.system.getUserChar(main.id_tf.getText());
		character = new ImageIcon(userch.getU_char());
		character_l = new JLabel(character);
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
			
			type=0;
			
			int i=0;
			
			cl_list.clear();
//			hair_list.clear();
			btn_list.clear();
			
			for(UserItemVO uitem : main.system.searchHairItem(main.id_tf.getText())) {
				cl_list.add(new ImageIcon(uitem.getI_closet()));
				btn_list.add(new JButton(cl_list.get(i)));
				btn_list.get(i).addMouseListener(this);
				ch_list.add(new ImageIcon(uitem.getI_content()));
				hair_list.add(new JLabel(ch_list.get(i)));
				img_p.add(btn_list.get(i));
				btn_list.get(i).setBorderPainted(false);
				btn_list.get(i).setContentAreaFilled(false);
				btn_list.get(i).setFocusPainted(false);
				i++;
			}
			
			revalidate();
		}else if(obj == btn_menu_top) {
			con.repaint();
			img_p.removeAll();
			img_p.repaint();
			
			type=1;
			
			int i=0;
			cl_list.clear();
//			top_list.clear();
			btn_list.clear();
			
			for(UserItemVO uitem : main.system.searchTopItem(main.id_tf.getText())) {
				cl_list.add(new ImageIcon(uitem.getI_closet()));
				btn_list.add(new JButton(cl_list.get(i)));
				btn_list.get(i).addMouseListener(this);
				ct_list.add(new ImageIcon(uitem.getI_content()));
				top_list.add(new JLabel(ct_list.get(i)));
				img_p.add(btn_list.get(i));
				btn_list.get(i).setBorderPainted(false);
				btn_list.get(i).setContentAreaFilled(false);
				btn_list.get(i).setFocusPainted(false);
				i++;
			}
			
			revalidate();
		}else if(obj == btn_menu_bottom) {
			con.repaint();
			img_p.removeAll();
			img_p.repaint();
			
			type=2;
			
			int i=0;
			cl_list.clear();
//			bottom_list.clear();
			btn_list.clear();
			
			for(UserItemVO uitem : main.system.searchBottomItem(main.id_tf.getText())) {
				cl_list.add(new ImageIcon(uitem.getI_closet()));
				btn_list.add(new JButton(cl_list.get(i)));
				btn_list.get(i).addMouseListener(this);
				cb_list.add(new ImageIcon(uitem.getI_content()));
				bottom_list.add(new JLabel(cb_list.get(i)));
				img_p.add(btn_list.get(i));
				btn_list.get(i).setBorderPainted(false);
				btn_list.get(i).setContentAreaFilled(false);
				btn_list.get(i).setFocusPainted(false);
				i++;
			}
			
			revalidate();
		}else if(obj == btn_reset) {
			character_l.setVisible(false);
			nohair_l.setVisible(false);
			notop_l.setVisible(false);
			nobottom_l.setVisible(false);
			char_reset_l.setVisible(true);
			if(hair_list.size() != 0) {
				for(int i=0;i<hair_list.size();i++) {
					hair_list.get(i).setVisible(false);
				}
			}
			if(top_list.size() != 0) {
				for(int i=0;i<top_list.size();i++) {
					top_list.get(i).setVisible(false);
				}
			}
			if(bottom_list.size() != 0) {
				for(int i=0;i<bottom_list.size();i++) {
					bottom_list.get(i).setVisible(false);
				}
			}
			hidx=-1;
			tidx=-1;
			bidx=-1;
			add(char_reset_l,BorderLayout.WEST);	//#####################
			con.repaint();
			revalidate();
			
		}else if(obj == btn_save) {
			if(hidx!=-1 && tidx==-1 && bidx==-1) {
				result = main.system.saveUserChar(main.id_tf.getText(), nohair, ch_list.get(hidx));
			}else if(hidx!=-1 && tidx!=-1 && bidx==-1) {
				result = main.system.saveUserChar(main.id_tf.getText(), ch_list.get(hidx), ct_list.get(tidx), onlybottom);
			}else if(hidx!=-1 && tidx==-1 && bidx!=-1) {
				result = main.system.saveUserChar(main.id_tf.getText(), ch_list.get(hidx), cb_list.get(bidx), onlytop);
			}else if(hidx==-1 && tidx!=-1 && bidx==-1) {
				result = main.system.saveUserChar(main.id_tf.getText(), ct_list.get(tidx), notop);
			}else if(hidx==-1 && tidx!=-1 && bidx!=-1) {
				result = main.system.saveUserChar(main.id_tf.getText(), onlyhair, ct_list.get(tidx), cb_list.get(bidx));
			}else if(hidx==-1 && tidx==-1 && bidx!=-1) {
				result = main.system.saveUserChar(main.id_tf.getText(), cb_list.get(bidx), nobottom);
			}else if(hidx!=-1 && tidx!=-1 && bidx!=-1) {
				result = main.system.saveUserChar(main.id_tf.getText(), ch_list.get(hidx), ct_list.get(tidx), cb_list.get(bidx));
			}
			if(result != 0) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("저장되었습니다"));
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("저장에 실패하였습니다"));
			}
			
		}else {
			char_reset_l.setVisible(false);
			character_l.setVisible(false);
			for(int i=0;i<cl_list.size();i++) {
				if(obj == btn_list.get(i)) {
					if(type==0) {
						for(int j=0;j<=hidx;j++) {
							hair_list.get(j).setVisible(false);
						}
						hidx=i;
						nohair_l.setVisible(false);
						notop_l.setVisible(false);
						nobottom_l.setVisible(false);
						onlyhair_l.setVisible(false);
						onlytop_l.setVisible(false);
						onlybottom_l.setVisible(false);
						if(hidx!=-1 && tidx==-1 && bidx==-1) {
							nohair_l.setVisible(true);
							add(nohair_l,BorderLayout.WEST);
						}else if(hidx!=-1 && tidx!=-1 && bidx==-1) {
							onlybottom_l.setVisible(true);
							add(onlybottom_l,BorderLayout.WEST);
						}else if(hidx!=-1 && tidx==-1 && bidx!=-1) {
							onlytop_l.setVisible(true);
							add(onlytop_l,BorderLayout.WEST);
						}
						hair_list.get(i).setVisible(true);
						add(hair_list.get(i),BorderLayout.WEST);
						
					}else if(type==1) {
						for(int j=0;j<=tidx;j++) {
						top_list.get(j).setVisible(false);
						}
						tidx=i;
						nohair_l.setVisible(false);
						notop_l.setVisible(false);
						nobottom_l.setVisible(false);
						onlyhair_l.setVisible(false);
						onlytop_l.setVisible(false);
						onlybottom_l.setVisible(false);
						if(hidx==-1 && tidx!=-1 && bidx==-1) {
							notop_l.setVisible(true);
							add(notop_l,BorderLayout.WEST);
						}else if(hidx!=-1 && tidx!=-1 && bidx==-1) {
							onlybottom_l.setVisible(true);
							add(onlybottom_l,BorderLayout.WEST);
						}else if(hidx==-1 && tidx!=-1 && bidx!=-1) {
							onlyhair_l.setVisible(true);
							add(onlyhair_l,BorderLayout.WEST);
						}
						top_list.get(i).setVisible(true);
						add(top_list.get(i),BorderLayout.WEST);
					}else if(type==2) {
						for(int j=0;j<=bidx;j++) {
							bottom_list.get(j).setVisible(false);
						}
						bidx=i;
						nohair_l.setVisible(false);
						notop_l.setVisible(false);
						nobottom_l.setVisible(false);
						onlyhair_l.setVisible(false);
						onlytop_l.setVisible(false);
						onlybottom_l.setVisible(false);
						if(hidx==-1 && tidx==-1 && bidx!=-1) {
							nobottom_l.setVisible(true);
							add(nobottom_l,BorderLayout.WEST);
						}else if(hidx!=-1 && tidx==-1 && bidx!=-1) {
							onlytop_l.setVisible(true);
							add(onlytop_l,BorderLayout.WEST);
						}else if(hidx==-1 && tidx!=-1 && bidx!=-1) {
							onlyhair_l.setVisible(true);
							add(onlyhair_l,BorderLayout.WEST);
						}
						bottom_list.get(i).setVisible(true);
						add(bottom_list.get(i),BorderLayout.WEST);
					}
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