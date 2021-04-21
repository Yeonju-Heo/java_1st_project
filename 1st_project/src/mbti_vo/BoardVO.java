package mbti_vo;

import java.awt.image.BufferedImage;
import java.util.Date;

public class BoardVO {
	int b_rno, b_good, b_bad;
	String b_title, b_content, b_id, b_filepath;
	Date b_date;
	BufferedImage b_img;
	
	
	public BufferedImage getB_img() {
		return b_img;
	}
	public void setB_img(BufferedImage b_img) {
		this.b_img = b_img;
	}
	public String getB_filepath() {
		return b_filepath;
	}
	public void setB_filepath(String b_filepath) {
		this.b_filepath = b_filepath;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public int getB_rno() {
		return b_rno;
	}
	public void setB_rno(int b_rno) {
		this.b_rno = b_rno;
	}
	public int getB_good() {
		return b_good;
	}
	public void setB_good(int b_good) {
		this.b_good = b_good;
	}
	public int getB_bad() {
		return b_bad;
	}
	public void setB_bad(int b_bad) {
		this.b_bad = b_bad;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	
	

}
