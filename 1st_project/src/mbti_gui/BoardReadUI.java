package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import mbti_vo.BoardVO;

public class BoardReadUI implements MouseListener, ActionListener {
	// Field

	String[] colNames = { "번호", "제목", "작성자", "작성일", "추천/반대" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0) {
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};
	Object[] row = new Object[5];
	JTable list_table = new JTable(model);

	MbtiMainUI main;
	BoardVO board;
	JTextArea content_ta;
	JButton btn_list, btn_delete, btn_update;
	JLabel good_label, bad_label, img_label;
	String title, id, content, good, bad, filepath; // &&&
	BufferedImage img;
	int no;
	boolean flag = true;

	public static final int GOOD = 1;
	public static final int BAD = 0;

	// Constructor
	public BoardReadUI(MbtiMainUI main, int no) {
		this.main = main;
		this.no = no;
		init();
	}

	public void getInfo() {
		board = main.system.readBoard(no);
//		BoardVO board = main.system.readBoard(no);
		title = board.getB_title();
		id = board.getB_id();
		content = board.getB_content();
		good = String.valueOf(board.getB_good());
		bad = String.valueOf(board.getB_bad());
		filepath = board.getB_filepath();
		img = board.getB_img();
	}

	/** 글 읽기 화면 **/
	public void init() {
		getInfo();

		main.board_panel.removeAll();
		main.switch_panel(MbtiMainUI.BOARD);
		main.board_panel.setLayout(new BorderLayout());
		main.board_panel.setBackground(Color.white);
		main.content_panel.setBackground(Color.white);

		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel(new BorderLayout());
		Panel title_panel = new Panel(new BorderLayout());
		Panel content_panel = new Panel(new BorderLayout()); // &&
		Panel recommend_panel = new Panel();

		// 탑패널
		JLabel board_label = new JLabel("자유게시판");
		board_label.setFont(Commons.getFont(20));
		top_panel.add(board_label);
		top_panel.setLayout(new GridLayout(2, 1)); // 자유게시판이랑 제목 사이 간격 만들기

		// 센터패널 - 제목 + 작성자
		JLabel title_label = new JLabel("제목: " + title);
		JLabel writer_label = new JLabel("작성자: " + id);
		title_label.setFont(Commons.getFont(15));
		writer_label.setFont(Commons.getFont(15));
		title_panel.add(BorderLayout.WEST, title_label);
		title_panel.add(BorderLayout.EAST, writer_label);

		// 센터패널 - 내용
//		if (img != null) { // &&&&
//			if (img.getWidth() >= 400 || img.getHeight() >= 250) {
//				Image rimg = img.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
//				img_label = new JLabel(new ImageIcon(rimg));
//			} else {
//				img_label = new JLabel(new ImageIcon(img));
//			}
//			content_panel.add(img_label, BorderLayout.NORTH);
//			img_label.addMouseListener(this);
//		}

		if (img != null) { // &&&&

			int width = img.getWidth();
			int height = img.getHeight();

			while (flag) {
				if (width > 500 || height > 250) {
					width = width / 2;
					height = height / 2;
				} else {
					flag = false;
				}
			}

			Image rimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			img_label = new JLabel(new ImageIcon(rimg));

			content_panel.add(img_label, BorderLayout.NORTH);
			img_label.addMouseListener(this);
		}

		JTextArea rcontent_ta = new JTextArea(15, 45);
		rcontent_ta.setEditable(false);
		rcontent_ta.setFont(Commons.getFont(15));
		rcontent_ta.setText(content);
		JScrollPane ta_pane = new JScrollPane(rcontent_ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		rcontent_ta.setCaretPosition(0); // 스크롤 맨 위로

		// 센터패널 - 추천수
		ImageIcon good_icon = new ImageIcon("images/up.png");
		good_label = new JLabel(good_icon);
		JLabel good_count = new JLabel(good);

		ImageIcon bad_icon = new ImageIcon("images/down.png");
		bad_label = new JLabel(bad_icon);
		JLabel bad_count = new JLabel(bad);

		recommend_panel.add(good_label);
		recommend_panel.add(good_count);
		recommend_panel.add(bad_label);
		recommend_panel.add(bad_count);

//		ImageIcon writer = new ImageIcon("images/character.png"); // 0413: 게시글에 캐릭터 추가
//		JLabel character_label = new JLabel(writer);

		content_panel.add(ta_pane, BorderLayout.CENTER); // &&&&
		content_panel.setPreferredSize(new Dimension(700, 400));
		center_panel.add(BorderLayout.NORTH, title_panel);
		center_panel.add(BorderLayout.CENTER, content_panel);
//		center_panel.add(BorderLayout.EAST, character_label); // 0413: 게시글에 캐릭터 추가
		center_panel.add(BorderLayout.SOUTH, recommend_panel);

		// 바텀패널
		btn_list = new JButton("목록으로");
		btn_update = new JButton("수정");
		btn_delete = new JButton("삭제");
		btn_list.setFont(Commons.getFont());
		btn_update.setFont(Commons.getFont());
		btn_delete.setFont(Commons.getFont());
		Panel right_panel = new Panel();
		Panel left_panel = new Panel();
		right_panel.add(btn_update);
		right_panel.add(btn_delete);
		left_panel.add(btn_list);
		bottom_panel.add(BorderLayout.WEST, left_panel);
		bottom_panel.add(BorderLayout.EAST, right_panel);

		// 붙이기
		main.board_panel.add(BorderLayout.NORTH, top_panel);
		main.board_panel.add(BorderLayout.CENTER, center_panel);
		main.board_panel.add(BorderLayout.SOUTH, bottom_panel);
		main.content_panel.add(main.board_panel);
		main.secondFrame.setVisible(true);

		btn_list.addActionListener(this);
		btn_update.addActionListener(this);
		btn_delete.addActionListener(this);
		good_label.addMouseListener(this);
		bad_label.addMouseListener(this);

	}

	/** 글 삭제 **/
	public void deleteProc() {
		if (id.equals(main.id_tf.getText())) {
			int con = JOptionPane.showConfirmDialog(null, Commons.getMsg("정말 삭제하시겠습니까?"));
			if (con == 0) {
				if (main.system.deleteBoard(no)) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("글이 삭제되었습니다."));
					new BoardUI(main);
				} else {
					JOptionPane.showMessageDialog(null, Commons.getMsg("삭제에 실패했습니다."));
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "권한이 없습니다");
		}
	}

	public void showImg() {
		JFrame img_frame = new JFrame("image");
		Image rimg = img;

		Double window_width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		Double window_height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		if (img.getWidth() > window_width || img.getHeight() > window_height) {
			rimg = img.getScaledInstance(img.getWidth() / 2, img.getHeight() / 2, Image.SCALE_SMOOTH);
			img_frame.setSize(img.getWidth(), img.getHeight());
		} else {
			img_frame.setSize(img.getWidth()+100, img.getHeight()+100);
		}

		ImageIcon rimg_icon = new ImageIcon(rimg);
		JLabel rimg_label = new JLabel(rimg_icon);
		img_frame.add(rimg_label);

		img_frame.setVisible(true);

		img_frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				img_frame.dispose();
			}
		});

	}

	/** 액션 리스너 **/
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn_list) {
			new BoardUI(main);
		} else if (obj == btn_update) {
			new BoardUpdateUI(main, board);
		} else if (obj == btn_delete) {
			deleteProc();
		}
	}

	/** 글목록 마우스 리스너 **/
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		int result = 0;

		if (obj == good_label) {
			result = main.system.updateRecommend(GOOD, no);
			if (result != 0)
				JOptionPane.showMessageDialog(null, Commons.getMsg("추천 완료"));
			init();
		} else if (obj == bad_label) {
			result = main.system.updateRecommend(BAD, no);
			if (result != 0)
				JOptionPane.showMessageDialog(null, Commons.getMsg("비추천 완료"));
			init();
		} else if (obj == img_label) {
			showImg();
		}

	}

	/** 마우스 리스너 오버라이드 **/
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
