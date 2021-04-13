package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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


public class BoardUI implements MouseListener, ActionListener{
  //Field
	
	String[] colNames = {"번호","제목","작성자","작성일","추천"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0) {
        public boolean isCellEditable(int i, int c) {  //내용 편집 막기
            return false;
        }
    };
	Object[] row = new Object[5];
	JTable list_table = new JTable(model);

	MainUI main;
	JTextField search_tf, title_tf;
	JTextArea content_ta;
	JButton btn_search, btn_write, btn_insert, btn_cancel, 
			btn_list, btn_delete, btn_update;
	int count = 1;
	JLabel up_label;
	JLabel down_label;
	
	
	//Constructor
	public BoardUI(MainUI main) {
		this.main = main;
		main.board_panel.setBackground(Color.white);
		main.content_panel.setBackground(Color.white);
		init();
	}
	
	
	//Method
	/** 글 목록 **/
	public void init() {
		main.switch_panel(MainUI.BOARD);
		main.board_panel.setLayout(new BorderLayout());
		
		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel();
		Panel search_panel = new Panel(new FlowLayout(FlowLayout.RIGHT));
		Panel list_panel = new Panel();
		
		//탑패널
		JLabel board_label = new JLabel("자유게시판");
		board_label.setFont(Commons.getFont(20));
		top_panel.add(board_label);
		
		//센터패널 - 검색
		search_tf = new JTextField(20);
		btn_search = new JButton("검색");
		btn_search.setFont(Commons.getFont());
		search_panel.add(search_tf);
		search_panel.add(btn_search);
		
		//센터패널 - 글목록
		createJtableData();
		model.setColumnIdentifiers(colNames);
		
		list_table.setModel(model);
		list_table.setRowHeight(35);
		list_table.setAutoCreateRowSorter(false);
		
		list_table.setRowMargin(0); 
		list_table.getColumnModel().setColumnMargin(0);
		list_table.getTableHeader().setReorderingAllowed(false); //마우스로 컬럼 이동 불가
		list_table.getTableHeader().setResizingAllowed(false); //마우스로 컬럼 크기 조절 불가
		list_table.setBackground(Color.white);
		list_table.setShowVerticalLines(false);  //컬럼 구분선 안 보이게
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  //목록 리스트 내용 가운데 정렬
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = list_table.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
//		list_table.getColumn("번호").setPreferredWidth(5); 
//		list_table.getColumn("제목").setWidth(125);
//		list_table.getColumn("작성자").setPreferredWidth(5);
//		list_table.getColumn("작성일").setPreferredWidth(5);
//		list_table.getColumn("추천").setPreferredWidth(5);
		
		resizeColumnWidth(list_table);  //컬럼 크기 조정
		JScrollPane pane = new JScrollPane(list_table);
		pane.setPreferredSize(new Dimension(700,400));
		list_panel.add(pane);
		
		center_panel.add(BorderLayout.NORTH, search_panel);
		center_panel.add(BorderLayout.CENTER, list_panel);
		
		//바텀패널
		btn_write = new JButton("글쓰기");
		btn_write.setFont(Commons.getFont());
		bottom_panel.add(btn_write);
		
		//붙이기
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
		
		row[0] = "1";
		row[1] = "제목 테스트 제목 테스트 제목 테스트";
		row[2] = "어피치";
		row[3] = "2021.01.01";
		row[4] = "추천/반대";

		model.addRow(row);
		
//		for(ScoreVO score : main.system.getScoreList()) {
//			row[0] = score.getRno();
//			row[1] = score.getName();
//			row[2] = score.getKor();
//			row[3] = score.getEng();
//			row[4] = score.getMath();
//			row[5] = score.getTot();
//			row[6] = score.getAvg();
//			
//			model.addRow(row);			
//		}		
		
		model.fireTableDataChanged();
	}
	
//	public void createJtableData(JTextField tf) {
//		
//		model.setNumRows(count);
//		
//		row[0] = count;
//		row[1] = tf.getText();
//		row[2] = "어피치";
//		row[3] = "2021.01.01";
//		row[4] = "추천/반대";
//		
//		model.addRow(row);			
//	
//		count++;
//		
//		model.fireTableDataChanged();
//	}
	
	
	/** 글 작성 화면 **/
	public void writeUI() {
		main.board_panel.removeAll();
		main.switch_panel(MainUI.BOARD);
		main.board_panel.setLayout(new BorderLayout());
		
		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel();
		Panel title_panel = new Panel();
		Panel content_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		//탑패널
		JLabel board_label = new JLabel("자유게시판");
		board_label.setFont(Commons.getFont(20));
		top_panel.add(board_label);
		
		//센터패널 - 제목
		JLabel title_label = new JLabel("제목  ");
		title_tf = new JTextField(45);
		title_label.setFont(Commons.getFont(15));
		title_tf.setFont(Commons.getFont(15));
		title_panel.add(title_label);
		title_panel.add(title_tf);
		
		//센터패널 - 내용작성
		JLabel content_label = new JLabel("내용  ");
		content_label.setFont(Commons.getFont(15));
		content_ta = new JTextArea(15, 45);
		content_ta.setFont(Commons.getFont(15));
		content_ta.setLineWrap(true);
		
		JScrollPane ta_pane = new JScrollPane(content_ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		content_panel.add(content_label);
		content_panel.add(ta_pane);
		center_panel.add(BorderLayout.NORTH, title_panel);
		center_panel.add(BorderLayout.CENTER, content_panel);
		
		//바텀패널
		btn_insert = new JButton("등록");
		btn_cancel = new JButton("취소");
		btn_insert.setFont(Commons.getFont());
		btn_cancel.setFont(Commons.getFont());
		bottom_panel.add(btn_insert);
		bottom_panel.add(btn_cancel);
		
		//붙이기
		main.board_panel.add(BorderLayout.NORTH, top_panel);
		main.board_panel.add(BorderLayout.CENTER, center_panel);
		main.board_panel.add(BorderLayout.SOUTH, bottom_panel);
		main.content_panel.add(main.board_panel);
		main.secondFrame.setVisible(true);

		content_ta.addMouseListener(this);
		btn_insert.addActionListener(this);
		btn_cancel.addActionListener(this);
	}
	
	
	/** 글 읽기 화면 **/
	public void readUI() {
			main.board_panel.removeAll();
			main.switch_panel(MainUI.BOARD);
			main.board_panel.setLayout(new BorderLayout());
			Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Panel center_panel = new Panel(new BorderLayout());
			Panel bottom_panel = new Panel(new BorderLayout());
			Panel title_panel = new Panel(new BorderLayout());
			Panel content_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Panel recommend_panel = new Panel();
			
			//탑패널
			JLabel board_label = new JLabel("자유게시판");
			board_label.setFont(Commons.getFont(20));
			top_panel.add(board_label);
			top_panel.setLayout(new GridLayout(2,1));  //자유게시판이랑 제목 사이 간격 만들기
			
			//센터패널 - 제목 + 작성자
			JLabel title_label = new JLabel("MBTI 제목 테스트입니다.");
			JLabel writer_label = new JLabel("작성자: 어피치");
			title_label.setFont(Commons.getFont(15));
			writer_label.setFont(Commons.getFont(15));
			title_panel.add(BorderLayout.WEST, title_label);
			title_panel.add(BorderLayout.EAST, writer_label);
			
			//센터패널 - 내용
			JTextArea rcontent_ta = new JTextArea(15, 45);
			rcontent_ta.setEditable(false);
			rcontent_ta.setFont(Commons.getFont(15));
			rcontent_ta.setText("ISTJ - 공무원, 감독관, 예산분석가, 세관조사관, 신용분석가, 회계사\r\n" + 
					"ISFJ - 치과의사, 초등학교 교사, 사서, 고객 서비스 상담원\r\n" + 
					"ISTP - 파일럿, 토목기사, 경제학자, 데이터분석가\r\n" + 
					"ISFP - 패션디자이너, 보석세공사, 화가, 무용가, 조경사\r\n" + 
					"INTJ - 투자은행원, 개인투자 자문가, 소프트웨어 개발자\r\n" + 
					"INFJ - 직업상담자, 교육컨설턴트, 특수교사, 사회복지사\r\n" + 
					"INTP - 경제학자, 벤처투자자, 비평가, 사업컨설, 마케팅 분석가\r\n" + 
					"INFP - 소설가, 시인, 프로듀서, 사회복지사, 영양사, 헤드헌터\r\n" + 
					"ESTJ - 보험설계사, 약사, 변호사, 판사, 프로젝트 매니저\r\n" + 
					"ESFJ - 영업이사, 간호사, 사회복지사, 광고기획자, 여신심사역\r\n" + 
					"ESTP - 경찰관, 은행원, 투자자, 기획사 에이전트, 스포츠팀 코치\r\n" + 
					"ESFP - 아동상담가, 의사, 배우, 인테리어 디자이너, 환경학자\r\n" + 
					"ENTJ - 변호사, 시장조사 분석가, 경영 컨설턴트, 벤처 투자자\r\n" + 
					"ENFJ - 광고이사, 홍보전문가, 기업교육전문가, 인사담당자\r\n" + 
					"ENTP - 경영자, 광고홍보 디렉터, 마케팅 디렉터, 정치인\r\n" + 
					"ENFP - 저널리스트, 컨설턴트, 식당경영자, 이벤트 플레너\r\n" + 
					"");
			JScrollPane ta_pane = new JScrollPane(rcontent_ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			rcontent_ta.setCaretPosition(0);  //스크롤 맨 위로
			
			//센터패널 - 추천수
			ImageIcon up = new ImageIcon("images/up.png");
			up_label = new JLabel(up);
			JLabel up_count = new JLabel("1");
			
			ImageIcon down = new ImageIcon("images/down.png");
			down_label = new JLabel(down);
			JLabel down_count = new JLabel("1");
			
			recommend_panel.add(up_label);
			recommend_panel.add(up_count);
			recommend_panel.add(down_label);
			recommend_panel.add(down_count);

			content_panel.add(ta_pane);
			center_panel.add(BorderLayout.NORTH, title_panel);
			center_panel.add(BorderLayout.CENTER, content_panel);
			center_panel.add(BorderLayout.SOUTH, recommend_panel);
			
			//바텀패널
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
			
			//붙이기
			main.board_panel.add(BorderLayout.NORTH, top_panel);
			main.board_panel.add(BorderLayout.CENTER, center_panel);
			main.board_panel.add(BorderLayout.SOUTH, bottom_panel);
			main.content_panel.add(main.board_panel);
			main.secondFrame.setVisible(true);

			btn_list.addActionListener(this);
			btn_update.addActionListener(this);
			btn_delete.addActionListener(this);
			up_label.addMouseListener(this);
			down_label.addMouseListener(this);
	}
	
	
	public void resizeColumnWidth(JTable table) {  //열 너비 조정
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 20; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 100)
	            width = 200;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}


	/** 액션 리스너 **/
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_search || obj == search_tf) {
			if(search_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("검색어를 입력해주세요."));
			} else {
				//검색한 내용 있으면 해당 글 제목을 화면에 출력, 없으면 없다고 출력 
			}
			System.out.println("------------------------->> 검색");
		} else if (obj == btn_write) {
			writeUI();
		} else if (obj == btn_insert) {
			if(writeCheck()) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("등록이 완료되었습니다."));
				//createJtableData(title_tf);
				init();
			} else {
				if(title_tf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("제목을 입력하세요."));
				} else if(content_ta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("내용을 입력하세요."));
				}
			}
		} else if (obj == btn_cancel) {
			int result = JOptionPane.showConfirmDialog(null, Commons.getMsg("게시물 작성을 취소하시겠습니까?"));
			if(result == 0) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("게시물 작성이 취소되었습니다."));
				init();
			}
			
		} else if (obj == btn_list) {
			init();
		} else if (obj == btn_update) {
			System.out.println("------------------------->> 수정");
		} else if (obj == btn_delete) {
			System.out.println("------------------------->> 삭제");
		}
	}
	
	
	/** 글 작성 유효성 검사 **/
	public boolean writeCheck() {
		boolean result = false;
		if(title_tf.getText().equals("") || content_ta.getText().equals("")) {
			result = false;
		} else result = true;
		return result;
	}
	
	
	/** 글목록 마우스 리스너 **/
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if(obj == list_table) {
			System.out.println("클릭!!");
			readUI();
			//int row = list_table.getSelectedRow();
			//int column = list_table.getSelectedColumn();
		} else if (obj == up_label) {
			System.out.println("추천");
		} else if (obj == down_label) {
			System.out.println("비추천");
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
}
