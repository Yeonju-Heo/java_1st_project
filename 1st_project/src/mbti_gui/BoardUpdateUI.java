package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mbti_vo.BoardVO;

public class BoardUpdateUI implements ActionListener{
	// Field

	MbtiMainUI main;
	BoardVO board;
	JTextField title_tf;
	JTextArea content_ta;
	JButton btn_update, btn_cancel;
	int count = 1;

	// Constructor
	public BoardUpdateUI(MbtiMainUI main, BoardVO board) {
		this.main = main;
		this.board = board;
		updateProc();
	}

	// Method
	/** 수정 가능여부 체크 **/
	public void updateProc() {
		if(board.getB_id().equals(main.id_tf.getText())) {
			init();
			title_tf.setText(board.getB_title());
			content_ta.setText(board.getB_content());
		} else {
			JOptionPane.showMessageDialog(null, Commons.getMsg("권한이 없습니다."));
		}
	}
	
	/** 글 수정 화면 **/
	public void init() {
		main.board_panel.removeAll();
		main.switch_panel(MbtiMainUI.BOARD);
		main.board_panel.setLayout(new BorderLayout());
		main.board_panel.setBackground(Color.white);
		main.content_panel.setBackground(Color.white);

		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel();
		Panel title_panel = new Panel();
		Panel content_panel = new Panel(new FlowLayout(FlowLayout.LEFT));

		// 탑패널
		JLabel board_label = new JLabel("자유게시판");
		board_label.setFont(Commons.getFont(20));
		top_panel.add(board_label);

		// 센터패널 - 제목
		JLabel title_label = new JLabel("제목  ");
		title_tf = new JTextField(45);
		title_label.setFont(Commons.getFont(15));
		title_tf.setFont(Commons.getFont(15));
		title_panel.add(title_label);
		title_panel.add(title_tf);

		// 센터패널 - 내용작성
		JLabel content_label = new JLabel("내용  ");
		content_label.setFont(Commons.getFont(15));
		content_ta = new JTextArea(15, 45);
		content_ta.setFont(Commons.getFont(15));
		content_ta.setLineWrap(true);

		JScrollPane ta_pane = new JScrollPane(content_ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		content_panel.add(content_label);
		content_panel.add(ta_pane);
		center_panel.add(BorderLayout.NORTH, title_panel);
		center_panel.add(BorderLayout.CENTER, content_panel);

		// 바텀패널
		btn_update = new JButton("수정");
		btn_cancel = new JButton("취소");
		btn_update.setFont(Commons.getFont());
		btn_cancel.setFont(Commons.getFont());
		bottom_panel.add(btn_update);
		bottom_panel.add(btn_cancel);

		// 붙이기
		main.board_panel.add(BorderLayout.NORTH, top_panel);
		main.board_panel.add(BorderLayout.CENTER, center_panel);
		main.board_panel.add(BorderLayout.SOUTH, bottom_panel);
		main.content_panel.add(main.board_panel);
		main.secondFrame.setVisible(true);

		btn_update.addActionListener(this);
		btn_cancel.addActionListener(this);
	}
	
	/** 액션 리스너 **/
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn_update) {
			updateResultProc();
		} else if (obj == btn_cancel) {
			int result = JOptionPane.showConfirmDialog(null, Commons.getMsg("게시물 수정을 취소하시겠습니까?"));
			if (result == 0) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("게시물 수정이 취소되었습니다."));
				new BoardUI(main);
			}
		}
	}
	
	public void updateResultProc() {
		if (writeCheck()) {
//			BoardVO board = new BoardVO();
			board.setB_title(title_tf.getText());
			board.setB_content(content_ta.getText());
//			board.setB_id(main.id_tf.getText());

			int result = main.system.updateBoard(board);
			if(result != 0) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("게시물이 수정되었습니다."));
				new BoardUI(main);
			} else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("게시물 수정에 실패했습니다."));
			}
		}
	}
	

	/** 글 작성 유효성 검사 **/
	public boolean writeCheck() {
		boolean result = false;
		
		if (title_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("제목을 입력하세요."));
			title_tf.requestFocus();
		} else if (content_ta.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("내용을 입력하세요."));
			content_ta.requestFocus();
		} else {
			result = true;
		}
		
		return result;
	}


}
