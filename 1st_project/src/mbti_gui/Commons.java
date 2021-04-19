package mbti_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;

public class Commons {
	
	public static Font getFont() {
		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		return font;
	}
	
	public static Font getFont2() {
		Font font = new Font("맑은 고딕", Font.BOLD, 14);
		return font;
	}
	
	public static Font getFont(int size) {
		Font font = new Font("맑은 고딕", Font.BOLD, size);
		return font;
	}
	
	public static JButton getJButton(String name) {
		Font font = new Font("맑은 고딕", Font.BOLD, 14);
		JButton button = new JButton(name);
		button.setFont(font);
		return button;
	}
	

	/** 메시지 출력 **/
	public static Label getMsg(String msg) {
		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		Label label = new Label(msg);
		label.setFont(font);		
		return label;
	}
	
	
	
	public static Font getMbtiFont(String mbti) {
		Font font = null;
		
		if(mbti.equals("INFJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
					
		}else if(mbti.equals("INFP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ENFJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ENFP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ISTJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ISFJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ESTJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ESFJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ISTP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ISFP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ESTP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ESFP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("INTJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("INTP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ENTJ")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}else if(mbti.equals("ENTP")) {
			font = new Font("맑은 고딕", Font.BOLD, 12);
			
		}
		
		return font;
	}
	
	
	
	
}
