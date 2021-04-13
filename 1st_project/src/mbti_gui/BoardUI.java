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
  //Field//
	
	String[] colNames = {"��ȣ","����","�ۼ���","�ۼ���","��õ"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0) {
        public boolean isCellEditable(int i, int c) {  //���� ���� ����
            return false;
        }
    };
	Object[] row = new Object[5];
	JTable list_table = new JTable(model);

	MbtiMainUI main;
	JTextField search_tf, title_tf;
	JTextArea content_ta;
	JButton btn_search, btn_write, btn_insert, btn_cancel, 
			btn_list, btn_delete, btn_update;
	int count = 1;
	JLabel up_label;
	JLabel down_label;
	
	
	//Constructor
	public BoardUI(MbtiMainUI main) {
		this.main = main;
		main.board_panel.setBackground(Color.white);
		main.content_panel.setBackground(Color.white);
		init();
	}
	
	
	//Method
	/** �� ��� **/
	public void init() {
		main.switch_panel(MbtiMainUI.BOARD);
		main.board_panel.setLayout(new BorderLayout());
		
		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel();
		Panel search_panel = new Panel(new FlowLayout(FlowLayout.RIGHT));
		Panel list_panel = new Panel();
		
		//ž�г�
		JLabel board_label = new JLabel("�����Խ���");
		board_label.setFont(Commons.getFont(20));
		top_panel.add(board_label);
		
		//�����г� - �˻�
		search_tf = new JTextField(20);
		btn_search = new JButton("�˻�");
		btn_search.setFont(Commons.getFont());
		search_panel.add(search_tf);
		search_panel.add(btn_search);
		
		//�����г� - �۸��
		createJtableData();
		model.setColumnIdentifiers(colNames);
		
		list_table.setModel(model);
		list_table.setRowHeight(35);
		list_table.setAutoCreateRowSorter(false);
		
		list_table.setRowMargin(0); 
		list_table.getColumnModel().setColumnMargin(0);
		list_table.getTableHeader().setReorderingAllowed(false); //���콺�� �÷� �̵� �Ұ�
		list_table.getTableHeader().setResizingAllowed(false); //���콺�� �÷� ũ�� ���� �Ұ�
		list_table.setBackground(Color.white);
		list_table.setShowVerticalLines(false);  //�÷� ���м� �� ���̰�
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  //��� ����Ʈ ���� ��� ����
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = list_table.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
//		list_table.getColumn("��ȣ").setPreferredWidth(5); 
//		list_table.getColumn("����").setWidth(125);
//		list_table.getColumn("�ۼ���").setPreferredWidth(5);
//		list_table.getColumn("�ۼ���").setPreferredWidth(5);
//		list_table.getColumn("��õ").setPreferredWidth(5);
		
		resizeColumnWidth(list_table);  //�÷� ũ�� ����
		JScrollPane pane = new JScrollPane(list_table);
		pane.setPreferredSize(new Dimension(700,400));
		list_panel.add(pane);
		
		center_panel.add(BorderLayout.NORTH, search_panel);
		center_panel.add(BorderLayout.CENTER, list_panel);
		
		//�����г�
		btn_write = new JButton("�۾���");
		btn_write.setFont(Commons.getFont());
		bottom_panel.add(btn_write);
		
		//���̱�
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
	
	
	/** �۸�� ���� **/
	public void createJtableData() {
		
		model.setNumRows(0);
		
		row[0] = "1";
		row[1] = "���� �׽�Ʈ ���� �׽�Ʈ ���� �׽�Ʈ";
		row[2] = "����ġ";
		row[3] = "2021.01.01";
		row[4] = "��õ/�ݴ�";

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
//		row[2] = "����ġ";
//		row[3] = "2021.01.01";
//		row[4] = "��õ/�ݴ�";
//		
//		model.addRow(row);			
//	
//		count++;
//		
//		model.fireTableDataChanged();
//	}
	
	
	/** �� �ۼ� ȭ�� **/
	public void writeUI() {
		main.board_panel.removeAll();
		main.switch_panel(MbtiMainUI.BOARD);
		main.board_panel.setLayout(new BorderLayout());
		
		Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Panel center_panel = new Panel(new BorderLayout());
		Panel bottom_panel = new Panel();
		Panel title_panel = new Panel();
		Panel content_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		//ž�г�
		JLabel board_label = new JLabel("�����Խ���");
		board_label.setFont(Commons.getFont(20));
		top_panel.add(board_label);
		
		//�����г� - ����
		JLabel title_label = new JLabel("����  ");
		title_tf = new JTextField(45);
		title_label.setFont(Commons.getFont(15));
		title_tf.setFont(Commons.getFont(15));
		title_panel.add(title_label);
		title_panel.add(title_tf);
		
		//�����г� - �����ۼ�
		JLabel content_label = new JLabel("����  ");
		content_label.setFont(Commons.getFont(15));
		content_ta = new JTextArea(15, 45);
		content_ta.setFont(Commons.getFont(15));
		content_ta.setLineWrap(true);
		
		JScrollPane ta_pane = new JScrollPane(content_ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		content_panel.add(content_label);
		content_panel.add(ta_pane);
		center_panel.add(BorderLayout.NORTH, title_panel);
		center_panel.add(BorderLayout.CENTER, content_panel);
		
		//�����г�
		btn_insert = new JButton("���");
		btn_cancel = new JButton("���");
		btn_insert.setFont(Commons.getFont());
		btn_cancel.setFont(Commons.getFont());
		bottom_panel.add(btn_insert);
		bottom_panel.add(btn_cancel);
		
		//���̱�
		main.board_panel.add(BorderLayout.NORTH, top_panel);
		main.board_panel.add(BorderLayout.CENTER, center_panel);
		main.board_panel.add(BorderLayout.SOUTH, bottom_panel);
		main.content_panel.add(main.board_panel);
		main.secondFrame.setVisible(true);

		content_ta.addMouseListener(this);
		btn_insert.addActionListener(this);
		btn_cancel.addActionListener(this);
	}
	
	
	/** �� �б� ȭ�� **/
	public void readUI() {
			main.board_panel.removeAll();
			main.switch_panel(MbtiMainUI.BOARD);
			main.board_panel.setLayout(new BorderLayout());
			Panel top_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Panel center_panel = new Panel(new BorderLayout());
			Panel bottom_panel = new Panel(new BorderLayout());
			Panel title_panel = new Panel(new BorderLayout());
			Panel content_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Panel recommend_panel = new Panel();
			
			//ž�г�
			JLabel board_label = new JLabel("�����Խ���");
			board_label.setFont(Commons.getFont(20));
			top_panel.add(board_label);
			top_panel.setLayout(new GridLayout(2,1));  //�����Խ����̶� ���� ���� ���� �����
			
			//�����г� - ���� + �ۼ���
			JLabel title_label = new JLabel("MBTI ���� �׽�Ʈ�Դϴ�.");
			JLabel writer_label = new JLabel("�ۼ���: ����ġ");
			title_label.setFont(Commons.getFont(15));
			writer_label.setFont(Commons.getFont(15));
			title_panel.add(BorderLayout.WEST, title_label);
			title_panel.add(BorderLayout.EAST, writer_label);
			
			//�����г� - ����
			JTextArea rcontent_ta = new JTextArea(15, 45);
			rcontent_ta.setEditable(false);
			rcontent_ta.setFont(Commons.getFont(15));
			rcontent_ta.setText("ISTJ - ������, ������, ����м���, ���������, �ſ�м���, ȸ���\r\n" + 
					"ISFJ - ġ���ǻ�, �ʵ��б� ����, �缭, �� ���� ����\r\n" + 
					"ISTP - ���Ϸ�, �����, ��������, �����ͺм���\r\n" + 
					"ISFP - �мǵ����̳�, ����������, ȭ��, ���밡, �����\r\n" + 
					"INTJ - ���������, �������� �ڹ���, ����Ʈ���� ������\r\n" + 
					"INFJ - ���������, ����������Ʈ, Ư������, ��ȸ������\r\n" + 
					"INTP - ��������, ��ó������, ����, �������, ������ �м���\r\n" + 
					"INFP - �Ҽ���, ����, ���ε༭, ��ȸ������, �����, �������\r\n" + 
					"ESTJ - ���輳���, ���, ��ȣ��, �ǻ�, ������Ʈ �Ŵ���\r\n" + 
					"ESFJ - �����̻�, ��ȣ��, ��ȸ������, �����ȹ��, ���Žɻ翪\r\n" + 
					"ESTP - ������, �����, ������, ��ȹ�� ������Ʈ, �������� ��ġ\r\n" + 
					"ESFP - �Ƶ���㰡, �ǻ�, ���, ���׸��� �����̳�, ȯ������\r\n" + 
					"ENTJ - ��ȣ��, �������� �м���, �濵 ������Ʈ, ��ó ������\r\n" + 
					"ENFJ - �����̻�, ȫ��������, �������������, �λ�����\r\n" + 
					"ENTP - �濵��, ����ȫ�� ����, ������ ����, ��ġ��\r\n" + 
					"ENFP - ���θ���Ʈ, ������Ʈ, �Ĵ�濵��, �̺�Ʈ �÷���\r\n" + 
					"");
			JScrollPane ta_pane = new JScrollPane(rcontent_ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			rcontent_ta.setCaretPosition(0);  //��ũ�� �� ����
			
			//�����г� - ��õ��
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
			
			//�����г�
			btn_list = new JButton("�������");
			btn_update = new JButton("����");
			btn_delete = new JButton("����");
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
			
			//���̱�
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
	
	
	public void resizeColumnWidth(JTable table) {  //�� �ʺ� ����
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


	/** �׼� ������ **/
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_search || obj == search_tf) {
			if(search_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("�˻�� �Է����ּ���."));
			} else {
				//�˻��� ���� ������ �ش� �� ������ ȭ�鿡 ���, ������ ���ٰ� ��� 
			}
			System.out.println("------------------------->> �˻�");
		} else if (obj == btn_write) {
			writeUI();
		} else if (obj == btn_insert) {
			if(writeCheck()) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("����� �Ϸ�Ǿ����ϴ�."));
				//createJtableData(title_tf);
				init();
			} else {
				if(title_tf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("������ �Է��ϼ���."));
				} else if(content_ta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("������ �Է��ϼ���."));
				}
			}
		} else if (obj == btn_cancel) {
			int result = JOptionPane.showConfirmDialog(null, Commons.getMsg("�Խù� �ۼ��� ����Ͻðڽ��ϱ�?"));
			if(result == 0) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("�Խù� �ۼ��� ��ҵǾ����ϴ�."));
				init();
			}
			
		} else if (obj == btn_list) {
			init();
		} else if (obj == btn_update) {
			System.out.println("------------------------->> ����");
		} else if (obj == btn_delete) {
			System.out.println("------------------------->> ����");
		}
	}
	
	
	/** �� �ۼ� ��ȿ�� �˻� **/
	public boolean writeCheck() {
		boolean result = false;
		if(title_tf.getText().equals("") || content_ta.getText().equals("")) {
			result = false;
		} else result = true;
		return result;
	}
	
	
	/** �۸�� ���콺 ������ **/
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if(obj == list_table) {
			System.out.println("Ŭ��!!");
			readUI();
			//int row = list_table.getSelectedRow();
			//int column = list_table.getSelectedColumn();
		} else if (obj == up_label) {
			System.out.println("��õ");
		} else if (obj == down_label) {
			System.out.println("����õ");
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
