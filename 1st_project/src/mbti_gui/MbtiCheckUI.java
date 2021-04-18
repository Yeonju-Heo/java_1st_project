package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MbtiCheckUI implements ActionListener, ItemListener{
	//Field
	JoinUI ui;
	MbtiMainUI main;
	JFrame f;
	JPanel title_p, center_p, text_p,choice_p, btn_p;
	JButton check_btn;
//	JRadioButton yes1, yes2, yes3, yes4, no1, no2, no3, no4;
	
	JRadioButton yes[] = new JRadioButton[4];
    JRadioButton no[] = new JRadioButton[4];
    
    String yes_type[] = {"E", "S", "F", "J"}; 
    String no_type[] = {"I", "N", "T", "P"}; 
    String[] mlist = new String[4];
	
	
	//Constructor
	public MbtiCheckUI() {}
	public MbtiCheckUI(JoinUI ui) {
		this.ui = ui;
	}
	
	public MbtiCheckUI(JoinUI ui, MbtiMainUI main) {
		this.ui = ui;
		this.main = main;
	}
	
	//Method
	public void mbti_check() {
		f = new JFrame("MBTI 간단 검사");
		
		JPanel title_p = new JPanel();
		JPanel center_p = new JPanel(new GridLayout(1,4));
		JPanel text_p = new JPanel(new GridLayout(6,1));
		JPanel choice_p = new JPanel(new GridLayout(6,2));
		JPanel btn_p = new JPanel();
		
		/** title **/
		JLabel title_l = new JLabel("당신의 MBTI를 알아보세요!");
		title_l.setFont(Commons.getFont2());
		title_p.add(title_l);
		
		/** center, text **/
		JLabel text0_l = new JLabel("");
		JLabel text1_l = new JLabel("  1. 나는 여러 사람과 대화하는 것이 좋다.");
		JLabel text2_l = new JLabel("  2. 나는 항상 아이디어가 넘쳐난다.");
		JLabel text3_l = new JLabel("  3. 나는 토론을 할 때 상대방의 기분을 살핀다.");
		JLabel text4_l = new JLabel("  4. 나는 무언가를 할 때 계획을 세우는 편이다.");
		
		text1_l.setFont(Commons.getFont());
		text2_l.setFont(Commons.getFont());
		text3_l.setFont(Commons.getFont());
		text4_l.setFont(Commons.getFont());
		
		text_p.add(text0_l);
		text_p.add(text1_l);
		text_p.add(text2_l);
		text_p.add(text3_l);
		text_p.add(text4_l);
		center_p.add(text_p,BorderLayout.WEST);
		
		/** center, choice **/
		JLabel yes_l = new JLabel("YES");
		JLabel no_l = new JLabel("NO");
		yes_l.setFont(Commons.getFont());
		no_l.setFont(Commons.getFont());
		
		ButtonGroup choice1 = new ButtonGroup();
		ButtonGroup choice2 = new ButtonGroup();
		ButtonGroup choice3 = new ButtonGroup();
		ButtonGroup choice4 = new ButtonGroup();
		
		
//		ButtonGroup[][] choice = new ButtonGroup[4][2];
//		
		
		choice_p.add(new JLabel("예"));
		choice_p.add(new JLabel("아니오"));
		for(int i=0;i<yes.length;i++) {
        	yes[i] = new JRadioButton();
        	choice_p.add(yes[i]);
        	yes[i].setBackground(Color.white);
        	yes[i].addActionListener(this);
        	no[i] = new JRadioButton();
        	choice_p.add(no[i]);
        	no[i].setBackground(Color.white);
        	no[i].addActionListener(this);
        	if(i==0) {
        		choice1.add(yes[i]);
        		choice1.add(no[i]);
        	}else if(i==1) {
        		choice2.add(yes[i]);
        		choice2.add(no[i]);
        	}else if(i==2) {
        		choice3.add(yes[i]);
        		choice3.add(no[i]);
        	}else if(i==3) {
        		choice4.add(yes[i]);
        		choice4.add(no[i]);
        	}
        }
		
		center_p.add(choice_p,BorderLayout.EAST);
		
		/** button **/
		check_btn = new JButton("검사하기");
		check_btn.setFont(Commons.getFont());
		btn_p.add(check_btn);
		
		/** ȭ����� **/
		f.add(BorderLayout.NORTH,title_p);
		f.add(BorderLayout.CENTER,center_p);
		f.add(BorderLayout.SOUTH,btn_p);
		
		title_p.setBackground(Color.white);
		center_p.setBackground(Color.white);
		text_p.setBackground(Color.white);
		choice_p.setBackground(Color.white);
		btn_p.setBackground(Color.white);
		
		f.setSize(550,400);

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
		
		check_btn.addActionListener(this);
//		yes1.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == ui.mbti_check_btn) {
			mbti_check();
		}else if(obj == check_btn) {
			if(!mlist[0].equals("")&&!mlist[1].equals("")&&!mlist[2].equals("")&&!mlist[3].equals("")) {
		          
		        JOptionPane.showMessageDialog(null,"당신의 MBTI는 "+mlist[0]+mlist[1]+mlist[2]+mlist[3]+" 입니다");
	      
	      }
		}
		
//		String s = e.getActionCommand();
			for(int i=0;i<mlist.length;i++) {
				if(obj==yes[i]) {
					mlist[i] = yes_type[i];
				}else if(obj==no[i]) {
					mlist[i] = no_type[i];
				}
		}
      
      
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
//		if(obj == yes1) {
//			System.out.println("E");
//		}else if(obj == no1) {
//			System.out.println("I");
//		}else if(obj == yes2) {
//			System.out.println("S");
//		}else if(obj == no2) {
//			System.out.println("N");
//		}else if(obj == yes3) {
//			System.out.println("F");
//		}else if(obj == no3) {
//			System.out.println("T");
//		}else if(obj == yes4) {
//			System.out.println("J");
//		}else if(obj == no4) {
//			System.out.println("P");
//		}
		
	}
	
}
