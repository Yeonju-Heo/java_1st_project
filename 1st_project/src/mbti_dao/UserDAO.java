package mbti_dao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import mbti_gui.MbtiMainUIEvent;
import mbti_vo.BoardVO;
import mbti_vo.UserItemVO;
import mbti_vo.UserVO;

public class UserDAO extends DBConn{
	
	/** 로그인 처리 **/
	public int getLoginResult(String id, String pass) {
		UserVO user = new UserVO();
		UserItemVO uitem = new UserItemVO();
		BoardVO board = new BoardVO();
		
		int result = -1;
		
		try {
			String sql = " SELECT* FROM USER_TABLE WHERE U_ID = ? AND U_PASS = ? ";
			getPreparedStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				uitem.setU_id(rs.getString(1));
				board.setB_id(rs.getString(1));
				user.setU_id(rs.getString(1));
				if(rs != null && rs.getString(6).equals("Y")) {
					result = MbtiMainUIEvent.ADMIN;
				} else if(rs != null && rs.getString(6).equals("N")) {
					result = MbtiMainUIEvent.USER;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 회원가입 아이디 중복 처리 **/
	public boolean getIdCheck(String id) {
		boolean result = false;
		try {
			String sql = " select count(*) login_result from user_table "
					+ " where u_id=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(1) == 1) result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/** 회원가입 처리 **/

	//U_ID,U_PASS,U_MBTI,U_POINT,U_DATE,U_ITEM

	public boolean getJoinResult(UserVO user) {
		boolean result = false;
		
		try {
			String sql = " INSERT INTO USER_TABLE(U_ID,U_PASS,U_MBTI,U_DATE,U_CHAR) "
					+ " VALUES(?,?,?,sysdate,?)";
					
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_pass());
			pstmt.setString(3, user.getU_mbti());
			
			FileInputStream fin = new FileInputStream("images/merge_charactor.png");
			
			pstmt.setBinaryStream(4, fin, fin.available());
			
			int val = pstmt.executeUpdate();
			if(val != 0) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	/** 유저 포인트 차감(헤어) **/
	public boolean getSubHairPointResult(UserVO user) {
		boolean result = false;
		try {
			String sql = " update user_table set u_point=decode(sign(u_point-30), -1,  0, u_point-30) where u_id=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			
			int val = pstmt.executeUpdate();
			
			if(val != 0) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 유저 포인트 차감(상의,하의) **/
	public boolean getSubTopBottomPointResult(UserVO user) {
		boolean result = false;
		try {
			String sql = " update user_table set u_point=decode(sign(u_point-20), -1,  0, u_point-20) where u_id=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			
			int val = pstmt.executeUpdate();
			
			if(val != 0) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 유저 캐릭터 완성본 저장 **/
	public int saveUserCharResult(String id, ImageIcon hair, ImageIcon top, ImageIcon bottom) {
		int result = 0;
		
		try {
			String sql = " UPDATE USER_TABLE SET U_CHAR = ?"
					+ " WHERE U_ID = ? ";
			getPreparedStatement(sql);
			BufferedImage himg = (BufferedImage) hair.getImage();
			BufferedImage timg = (BufferedImage) top.getImage();
			BufferedImage bimg = (BufferedImage) bottom.getImage();
			
			BufferedImage merge = new BufferedImage(timg.getWidth(),
					bimg.getHeight(),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) merge.getGraphics();
			g.drawImage(timg, 0, 0, null);
			g.drawImage(bimg, 0, 0, null);
			g.drawImage(himg, 0, 0, null);
			
			ImageIO.write(merge, "png", new File("images/char_"+id+".png"));
			
			FileInputStream fin = new FileInputStream("images/char_"+id+".png");
			pstmt.setBinaryStream(1, fin, fin.available());
			
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 유저 완성캐릭터 조회 **/
	public UserVO getUserChar(String id) {
		UserVO user = new UserVO();
		try {
			String sql =" SELECT U_CHAR FROM USER_TABLE WHERE U_ID = ? ";
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				InputStream in = rs.getBinaryStream(1);
				user.setU_char(ImageIO.read(in));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
	
	/** 유저 정보 조회 **/
	public UserVO getUserDataResult(String id) {
		UserVO user = new UserVO();
		try {
			String sql = "SELECT U_ID, U_MBTI, TO_CHAR(U_DATE,'YYYY-MM-DD'), U_POINT " + 
					" FROM USER_TABLE " + 
					" WHERE U_ID = ? ";
			getPreparedStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setU_id(rs.getString(1));
				user.setU_mbti(rs.getString(2));
				user.setU_date(rs.getString(3));;
				user.setU_point(rs.getInt(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	/** 유저 정보 조회(채팅) **/
	public UserVO getChatUserDataResult(String id) {
		UserVO user = new UserVO();
		try {
			String sql = "SELECT U_ID, U_MBTI " + 
					" FROM USER_TABLE " + 
					" WHERE U_ID = ? ";
			getPreparedStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setU_id(rs.getString(1));
				user.setU_mbti(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	
	/** 유저 정보 검색 (admin)**/
	public ArrayList<UserVO> getUserSearchAdminResult(String id) {
		ArrayList<UserVO> u_list = new ArrayList<UserVO>();
		
		try {
			String sql = 
					" SELECT U_ID, U_MBTI,TO_CHAR(U_DATE, 'YYYY-MM-DD'),U_POINT "
					+ "	FROM USER_TABLE WHERE U_ID LIKE '%' " + 
					" ||?|| '%' " ;
			
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setU_id(rs.getString(1));
				user.setU_mbti(rs.getString(2));
				user.setU_date(rs.getString(3));;
				user.setU_point(rs.getInt(4));
				u_list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u_list;
		
	}
	
	/** 유저 정보 조회(admin)**/
	public ArrayList<UserVO> getUserDataResult() {	//#############################
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			String sql = "SELECT U_ID, U_PASS, U_MBTI,TO_CHAR(U_DATE, 'YYYY-MM-DD'),U_POINT " + 
						 " FROM USER_TABLE WHERE U_ID != 'admin' ";
			
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setU_id(rs.getString(1));
				user.setU_pass(rs.getString(2));
				user.setU_mbti(rs.getString(3));
				user.setU_date(rs.getString(4));
				user.setU_point(rs.getInt(5));
				
				list.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/**유저 정보 null체크(admin)**/
	public boolean getUserExsistResult(String name) {  
		boolean result = false;
		
		try {
			String sql = 
//					"SELECT COUNT(*) FROM BOARD_TABLE " + 
//					" WHERE B_TITLE = ? "
					" SELECT COUNT(*) FROM USER_TABLE " + 
					" WHERE U_ID LIKE '%' ||?|| '%' " ;
			
			getPreparedStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				if(rs.getInt(1) >= 1) result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/** 유저 정보 삭제(admin)**/
	public boolean getDeleteUserAdmin(String name) {
		boolean result = false;
		try {
			String sql = " DELETE FROM USER_TABLE " + 
					" WHERE U_ID = ? ";
			getPreparedStatement(sql);
			pstmt.setString(1, name);
			
			int val = pstmt.executeUpdate();
			if(val !=0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	/** 유저 비밀번호 수정 **/
	public int getUpdateUserResult(UserVO user,String pass) {
		int result = 0;
		
		try {
			String sql = " UPDATE USER_TABLE"
					+ " SET U_PASS = ? WHERE U_ID = ? ";
			getPreparedStatement(sql);
			
			pstmt.setString(1, pass);
			pstmt.setString(2, user.getU_id());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	
	
}

