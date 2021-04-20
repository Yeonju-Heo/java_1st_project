package mbti_vo;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class UserItemVO {
	String u_id, i_name;
	BufferedImage i_closet, i_content;

	


	public BufferedImage getI_closet() {
		return i_closet;
	}

	public void setI_closet(BufferedImage i_closet) {
		this.i_closet = i_closet;
	}

	public BufferedImage getI_content() {
		return i_content;
	}

	public void setI_content(BufferedImage i_content) {
		this.i_content = i_content;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	
	
	

}
