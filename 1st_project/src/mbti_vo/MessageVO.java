package mbti_vo;

import java.io.Serializable;
import java.util.Vector;

public class MessageVO implements Serializable{
	//Field
	
	public static final int CONNECT = 1;
	public static final int TALK = 2;
	public static final int EXIT = 3;
	
	String name, msg;
	Vector<String> user_list;
	int status;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Vector<String> getUser_list() {
		return user_list;
	}
	public void setUser_list(Vector<String> user_list) {
		this.user_list = user_list;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
