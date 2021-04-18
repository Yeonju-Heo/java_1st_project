package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import mbti_vo.BoardVO;

public class BoardUI implements MouseListener, ActionListener {
	// Field

	String[] colNames = { "번호", "제목", "작성자", "작성일", "추천/반대" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0) {
		public boolean isCellEditable(int i, int c) { // 내용 편집 막기
			return false;
		}
	};
	Object[] row = new Object[5];
	JTable list_table = new JTable(model);

	MbtiMainUI main;
	JTextField search_tf, title_tf;
	JTextArea content_ta;
	JButton btn_search, btn_write, btn_insert, btn_cancel, btn_list, btn_delete, btn_update;
	int count = 1;
	JLabel up_label;
	JLabel down_label;

	// Constructor
	public BoardUI(MbtiMainUI main) {
		this.main = main;
		init();
	}

	// Method
	/** 글 목록 **/
	public void init() {
		main.switch_panel(MbtiMainUI.BOARD);
		main.board_panel.setLayout(new BorderLayout());
		main.board_panel.setBackground(Color.white);
		main.content_panel.setBackground(Color.white);

		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel();
		Panel search_panel = new Panel(new FlowLayout(FlowLayout.RIGHT));
		Panel list_panel = new Panel();

		// 탑패널
		JLabel board_label = new JLabel("자유게시판");
		board_label.setFont(Commons.getFont(20));
		top_panel.add(board_label);

		// 센터패널 - 검색
		search_tf = new JTextField(20);
		btn_search = new JButton("검색");
		btn_search.setFont(Commons.getFont());
		search_panel.add(search_tf);
		search_panel.add(btn_search);

		// 센터패널 - 글목록
		createJtableData();
		model.setColumnIdentifiers(colNames);

		list_table.setModel(model);
		list_table.setRowHeight(35);
		list_table.setAutoCreateRowSorter(false);

		list_table.setRowMargin(0);
		list_table.getColumnModel().setColumnMargin(0);
		list_table.getTableHeader().setReorderingAllowed(false); // 마우스로 컬럼 이동 불가
		list_table.getTableHeader().setResizingAllowed(false); // 마우스로 컬럼 크기 조절 불가
		list_table.setBackground(Color.white);
		list_table.setShowVerticalLines(false); // 컬럼 구분선 안 보이게

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 목록 리스트 내용 가운데 정렬
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = list_table.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

//      list_table.getColumn("번호").setPreferredWidth(5); 
//      list_table.getColumn("제목").setWidth(125);
//      list_table.getColumn("작성자").setPreferredWidth(5);
//      list_table.getColumn("작성일").setPreferredWidth(5);
//      list_table.getColumn("추천").setPreferredWidth(5);

		resizeColumnWidth(list_table); // 컬럼 크기 조정
		JScrollPane pane = new JScrollPane(list_table);
		pane.setPreferredSize(new Dimension(700, 400));
		list_panel.add(pane);

		center_panel.add(BorderLayout.NORTH, search_panel);
		center_panel.add(BorderLayout.CENTER, list_panel);

		// 바텀패널
		btn_write = new JButton("글쓰기");
		btn_write.setFont(Commons.getFont());
		bottom_panel.add(btn_write);

		// 붙이기
		main.board_panel.add(BorderLayout.NORTH, top_panel);
		main.board_panel.add(BorderLayout.CENTER, center_panel);
		main.board_panel.add(BorderLayout.SOUTH, bottom_panel);
		main.content_panel.add(main.board_panel);
		main.secondFrame.setVisible(true);

		list_table.addMouseListener(this);
		btn_write.addActionListener(this);
		btn_search.addActionListener(this);
		search_tf.addActionListener(this);
	}

	/** 글목록 생성 **/
	public void createJtableData() {

		model.setNumRows(0);

//		row[0] = "1";
//		row[1] = "제목 테스트 제목 테스트 제목 테스트";
//		row[2] = "어피치";
//		row[3] = "2021.01.01";
//		row[4] = "1/1";
//		model.addRow(row);
		
		if(main.system.getBoardList().size() != 0) {
	      for(BoardVO board : main.system.getBoardList()) {
	         row[0] = board.getB_rno();
	         row[1] = board.getB_title();
	         row[2] = board.getB_id();
	         row[3] = board.getB_date();
	         row[4] = board.getB_good() + "/" + board.getB_bad();
	 
	         model.addRow(row);         
	      }      
		} else {
			row[1] = "등록된 게시글이 없습니다.";
			model.addRow(row);      
		}
		
		
		model.fireTableDataChanged();
	}

	
	public void resizeColumnWidth(JTable table) { // 열 너비 조정
		TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 20; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 100)
				width = 200;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

	/** 액션 리스너 **/
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn_search || obj == search_tf) {
			if (search_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("검색어를 입력해주세요."));
			} else {
				// 검색한 내용 있으면 해당 글 제목을 화면에 출력, 없으면 없다고 출력
				System.out.println("------------------------->> 검색");
			}
		} else if(obj == btn_write) {
			new BoardWriteUI(main);
		}
	}


	/** 글목록 마우스 리스너 **/
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		Object lto = list_table.getValueAt(list_table.getSelectedRow(), 0);
		
		if (obj == list_table) {
			if(lto != null) {
				int no = Integer.parseInt(lto.toString());
				new BoardReadUI(main, no);
			} else {
				System.out.println("no post");
			}
			
			
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
