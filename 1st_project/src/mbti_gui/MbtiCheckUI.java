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
	JRadioButton yes1, yes2, yes3, yes4, no1, no2, no3, no4;
	
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
		
		yes1 = new JRadioButton();
		yes2 = new JRadioButton();
		yes3 = new JRadioButton();
		yes4 = new JRadioButton();
		no1 = new JRadioButton();
		no2 = new JRadioButton();
		no3 = new JRadioButton();
		no4 = new JRadioButton();
		
		ButtonGroup choice1 = new ButtonGroup();
		ButtonGroup choice2 = new ButtonGroup();
		ButtonGroup choice3 = new ButtonGroup();
		ButtonGroup choice4 = new ButtonGroup();
		
		choice1.add(yes1);
		choice2.add(yes2);
		choice3.add(yes3);
		choice4.add(yes4);
		choice1.add(no1);
		choice2.add(no2);
		choice3.add(no3);
		choice4.add(no4);
		
		choice_p.add(yes_l);
		choice_p.add(no_l);
		choice_p.add(yes1);
		choice_p.add(no1);
		choice_p.add(yes2);
		choice_p.add(no2);
		choice_p.add(yes3);
		choice_p.add(no3);
		choice_p.add(yes4);
		choice_p.add(no4);
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
		yes1.setBackground(Color.white);
		yes2.setBackground(Color.white);
		yes3.setBackground(Color.white);
		yes4.setBackground(Color.white);
		no1.setBackground(Color.white);
		no2.setBackground(Color.white);
		no3.setBackground(Color.white);
		no4.setBackground(Color.white);
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
		yes1.addActionListener(this);
		yes2.addActionListener(this);
		yes3.addActionListener(this);
		yes4.addActionListener(this);
		no1.addActionListener(this);
		no2.addActionListener(this);
		no3.addActionListener(this);
		no4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == ui.mbti_check_btn) {
			mbti_check();
		}else if(obj == yes1) {
			yes1.setText("E");
		}else if(obj == no1) {
			no1.setText("I");
		}else if(obj == yes2) {
			yes2.setText("S");
		}else if(obj == no2) {
			no2.setText("N");
		}else if(obj == yes3) {
			yes3.setText("F");
		}else if(obj == no3) {
			no3.setText("T");
		}else if(obj == yes4) {
			yes4.setText("J");
		}else if(obj == no4) {
			no4.setText("P");
		}else if(obj == check_btn) {
//			if(obj == yes1 || obj == yes2 || obj == yes3 || obj == yes4) {
				JOptionPane.showMessageDialog(null, Commons.getMsg(
						"당신의 MBTI는 "+ yes1.getText()+yes2.getText()+yes3.getText()+yes4.getText() +" 입니다."));
//			}
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
