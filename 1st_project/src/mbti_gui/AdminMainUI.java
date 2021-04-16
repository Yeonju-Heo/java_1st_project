package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import mbti_system.MbtiMgmSystem;

public class AdminMainUI implements ActionListener{

	// Field
	MbtiMgmSystem system;
	JFrame adminFrame = new JFrame("MBTI WORLD - 관리자");
	JPanel menu_panel, bottom_panel;
	String[] admin_menulist = { "메인", "회원관리", "게시글 관리", "종료" }; // 관리자
	ArrayList<JButton> admin_buttonlist = new ArrayList<JButton>(); // 관리자

	Panel main_panel = new Panel();
	Panel user_panel = new Panel();
	Panel board_panel = new Panel();
	Panel content_panel = new Panel();

	public static final int MAIN = 0;
	public static final int USER = 1;
	public static final int BOARD = 2;

	// Constructor
	public AdminMainUI() {
		init();
	}

	public void init() { // 관리자
		menu_panel = new JPanel(new GridLayout(1, 3, 5, 5));
		bottom_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));

		for (String name : admin_menulist) {
			JButton btn_menu = new JButton(name);
			btn_menu.setFont(Commons.getFont());
			menu_panel.add(btn_menu);
			admin_buttonlist.add(btn_menu);
			btn_menu.addActionListener(this);
		}

		ImageIcon icon = new ImageIcon("images/mainlogo.png");
		JLabel main_label = new JLabel(icon);
		main_panel.add(main_label);
		content_panel.add(main_panel);

		JLabel status_label = new JLabel("※ 관리자 계정으로 접속중입니다. ※");
		status_label.setFont(Commons.getFont(17));
		status_label.setForeground(Color.RED);
		status_label.setHorizontalAlignment(JLabel.CENTER);
		bottom_panel.add(status_label);

		
		adminFrame.add(BorderLayout.NORTH, menu_panel);
		adminFrame.add(BorderLayout.CENTER, content_panel);
		adminFrame.add(BorderLayout.SOUTH, bottom_panel);

		menu_panel.setBackground(Color.white);
		content_panel.setBackground(Color.white);
		bottom_panel.setBackground(Color.white);

		adminFrame.setSize(900, 700);

		Dimension fsize = adminFrame.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
		adminFrame.setLocation(width, height);

		adminFrame.setVisible(true);

		adminFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	// Method
	public void switch_panel(int menu) {
		content_panel.removeAll();
		main_panel.setVisible(false);
		user_panel.setVisible(false);
		board_panel.setVisible(false);

		switch (menu) {
		case MAIN:
			main_panel.removeAll();
			main_panel.setVisible(true);
		case USER:
			user_panel.removeAll();
			user_panel.setVisible(true);
			break;
		case BOARD:
			board_panel.removeAll();
			board_panel.setVisible(true);
			break;
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == admin_buttonlist.get(0)) { // 관리자
			switch_panel(MAIN);
			init();
		} else if (obj == admin_buttonlist.get(1)) {
			new AdminUserUI(this);
		} else if (obj == admin_buttonlist.get(2)) {
			new AdminBoardUI(this);
		} else if (obj == admin_buttonlist.get(3)) {
			int con = JOptionPane.showConfirmDialog(null, Commons.getMsg("정말 종료하시겠습니까?"));
			if (con == 0)
				System.exit(0);
		}
	}

}