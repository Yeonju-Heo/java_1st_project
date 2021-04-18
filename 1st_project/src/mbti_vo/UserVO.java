package mbti_vo;

import java.util.Date;

public class UserVO {
	String u_id,u_pass,cpass,u_mbti;
	int u_point;
	String u_date;
	
	
	
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getU_mbti() {
		return u_mbti;
	}
	public void setU_mbti(String u_mbti) {
		this.u_mbti = u_mbti;
	}
	public int getU_point() {
		return u_point;
	}
	public void setU_point(int u_point) {
		this.u_point = u_point;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pass() {
		return u_pass;
	}
	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	public String getU_date() {
		return u_date;
	}
	public void setU_date(String u_date) {
		this.u_date = u_date;
	}
	
	
	
}
