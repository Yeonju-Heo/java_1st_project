package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainUI {
	//Field
	MbtiMainUI main;
	
	//Constructor
	public MainUI(MbtiMainUI main) {
		this.main = main;
		init();
	}
	
	//Method
	public void init() {
		main.switch_panel(MbtiMainUI.MAIN);
		
		ImageIcon icon = new ImageIcon("images/main3.png");
		JLabel main_label = new JLabel(icon);
		main.content_panel.add(main_label);
		
		main.secondFrame.add(BorderLayout.NORTH,main.menu_panel);
		main.secondFrame.add(BorderLayout.CENTER,main.content_panel);
		main.secondFrame.add(BorderLayout.SOUTH,main.bottom_panel);
		
		main.menu_panel.setBackground(Color.white);
		main.content_panel.setBackground(Color.white);
		main.bottom_panel.setBackground(Color.white);
		
		main.secondFrame.setSize(900,700);

		Dimension fsize = main.secondFrame.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		main.secondFrame.setLocation(width, height);
		
		main.secondFrame.setVisible(true);
		
		main.secondFrame.addWindowListener(new WindowAdapter() {
			public void	windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
