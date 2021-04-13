package mbti_gui;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;

public class Commons {
	
	public static Font getFont() {
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 12);
		return font;
	}
	
	public static Font getFont2() {
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 14);
		return font;
	}
	
	public static Font getFont(int size) {
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, size);
		return font;
	}
	
	public static JButton getJButton(String name) {
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 14);
		JButton button = new JButton(name);
		button.setFont(font);
		return button;
	}

	/** ¸Þ½ÃÁö Ãâ·Â **/
	public static Label getMsg(String msg) {
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 12);
		Label label = new Label(msg);
		label.setFont(font);		
		return label;
	}
	
	
	
	
	
}
