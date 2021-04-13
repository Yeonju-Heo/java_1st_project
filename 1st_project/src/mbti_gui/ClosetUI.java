package mbti_gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ClosetUI {
	//Field
//	MbtiMgmSystem system;
	//수정
//	JFrame closetFrame;
	JPanel type_panel, clothes_panel, btn_panel,char_panel, closet_panel;
	ArrayList<JButton> buttonlist = new ArrayList<JButton>();
	ArrayList<JButton> typelist = new ArrayList<JButton>();
	JButton btn_reset, btn_save;
	Panel gomain_panel = new Panel();
	Panel create_panel = new Panel();
	Panel chat_panel = new Panel();
	Panel board_panel = new Panel();
	Panel mypage_panel = new Panel();
	MainUI main;
		
	//Constructor
	public ClosetUI() {};
	
	public ClosetUI(MainUI main) {
		this.main = main;
		init();
	}
	
	public void init() {
		char_panel = new JPanel();//캐릭터 사진
		closet_panel = new JPanel(new GridLayout(3,1));//옷장
		type_panel = new JPanel(new GridLayout(1,3));//옷 종류
		clothes_panel = new JPanel(new GridLayout());
		ImageIcon icon = new ImageIcon("images/top5.png");
		JLabel top5 = new JLabel(icon);
		closet_panel.add(top5);
		main.content_panel.add(closet_panel);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.black),"panel"));
        main.content_panel.add(panel);
        main.secondFrame.add(main.menu_panel, BorderLayout.NORTH);
        main.secondFrame.add(main.content_panel, BorderLayout.EAST);
        main.secondFrame.setSize(750,700);
        Dimension fsize = main.secondFrame.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		main.secondFrame.setLocation(width, height);
        main.secondFrame.setVisible(true);
	}
	
}
