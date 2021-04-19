package mbti_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import mbti_vo.UserVO;

public class AdminUserUI implements ActionListener {
	// Field
	AdminMainUI main;
	JTextField search_tf;
	JButton btn_search;
	String[] colNames = { "번호", "아이디", "MBTI", "가입일", "포인트", "삭제" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0) {
		public boolean isCellEditable(int i, int c) { // 내용 편집 막기
			boolean result = false;
			if(c==5) result = true;
			return result;
		}
	};
	int count = 1;
	Object[] row = new Object[6];
	JTable list_table = new JTable(model);


	// Constructor
	public AdminUserUI(AdminMainUI main) {
		this.main = main;
		init();
	}

	// Method
	public void init() {
		main.switch_panel(AdminMainUI.USER);
		main.user_panel.setLayout(new BorderLayout());

		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel();
		Panel search_panel = new Panel(new FlowLayout(FlowLayout.RIGHT));
		Panel list_panel = new Panel();

		// 탑패널
		JLabel board_label = new JLabel("회원 관리");
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
		list_table.setRowHeight(30);
		list_table.setAutoCreateRowSorter(false);

		list_table.setRowMargin(0);
		list_table.getColumnModel().setColumnMargin(0);
		list_table.getTableHeader().setReorderingAllowed(false); // 마우스로 컬럼 이동 불가
		list_table.getTableHeader().setResizingAllowed(false); // 마우스로 컬럼 크기 조절 불가
		list_table.setBackground(Color.white);
		
		list_table.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
        list_table.getColumnModel().getColumn(5).setCellEditor(new TableCell());

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 목록 리스트 내용 가운데 정렬
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = list_table.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount()-1; i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

		JScrollPane pane = new JScrollPane(list_table);
		pane.setPreferredSize(new Dimension(700, 400));
		list_panel.add(pane);
		center_panel.add(BorderLayout.NORTH, search_panel);
		center_panel.add(BorderLayout.CENTER, list_panel);

		// 붙이기
		main.user_panel.add(BorderLayout.NORTH, top_panel);
		main.user_panel.add(BorderLayout.CENTER, center_panel);
		main.user_panel.add(BorderLayout.SOUTH, bottom_panel);
		main.content_panel.add(main.user_panel);
		main.adminFrame.setVisible(true);

		btn_search.addActionListener(this);
		search_tf.addActionListener(this);
		
	}

	/** 전체 데이터 출력 **/
	public void createJtableData() {
		model.setNumRows(0);
		
		for(UserVO user : main.system.getUserDateSelect()) {
	    	 System.out.println(user);
	    	 row = new Object[5];
	    	 row[0] = count; //DB에 추가하기
	         row[1] = user.getU_id();
	         row[2] = user.getU_mbti();
	         row[3] = user.getU_date();
	         row[4] = user.getU_point();
	         
	         model.addRow(row); 
	         count++;
	         
	         model.fireTableDataChanged();
//	         list_table.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
//	         list_table.getColumnModel().getColumn(5).setCellEditor(new TableCell());
	      }  
		
		
	}
	
	/**검색 화면생성**/
	public void createJtableData(ArrayList<UserVO> u_list) {
		model.setNumRows(0);
		for(UserVO user : u_list) {
			row = new Object[5];
			row[0] = count; 
			row[1] = user.getU_id();
			row[2] = user.getU_mbti();
			row[3] = user.getU_date();
			row[4] = user.getU_point();
			
			model.addRow(row); 
			count++;
			
			model.fireTableDataChanged();
//	         list_table.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
//	         list_table.getColumnModel().getColumn(5).setCellEditor(new TableCell());
		}  
		
	}

	/** 일부 데이터 출력 **/
	public void createJtableData(UserVO user) {
		model.setNumRows(0);
		row = new Object[5];
		int count = 1;
		row[0] = count; //DB에 추가하기
		row[1] = user.getU_id();
		row[2] = user.getU_mbti();
		row[3] = user.getU_date();
		row[4] = user.getU_point();
		
		model.addRow(row); 
		
		count++;
		
		model.fireTableDataChanged();
		list_table.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
		list_table.getColumnModel().getColumn(5).setCellEditor(new TableCell());
	}  


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn_search || obj == search_tf) {
				UserSearchProc();
		}
	}
		
	public void UserSearchProc() {
		if (search_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("검색할 아이디를 입력해주세요."));
			search_tf.requestFocus();
		}else {
			// 검색한 내용 있으면 해당 글 제목을 화면에 출력, 없으면 없다고 출력
			if(main.system.getUserDateExsistSelect(search_tf.getText())) {
				ArrayList<UserVO> user = main.system.getUserDateSelect(search_tf.getText());
				System.out.println("검색");
				createJtableData(user);
			}else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("해당하는 데이터가 없습니다."));
				search_tf.requestFocus();
			}
		}
	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton jb;

		public TableCell() {
			jb = new JButton("삭제");
			jb.addActionListener(e -> {
				String user_name = list_table.getValueAt(list_table.getSelectedRow(), 1).toString();
				int con = JOptionPane.showConfirmDialog(null, Commons.getMsg(user_name + "님을 정말 삭제하시겠습니까?"));
				if(con == 0) {
					//DB연동해서 삭제 진행
					JOptionPane.showMessageDialog(null, user_name + "님이 삭제되었습니다.");
					main.system.deleteAdminUser(user_name);
					new AdminUserUI(main);
				}
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return jb;
		}

	}

}
