package mbti_dao;

import java.util.ArrayList;

import mbti_vo.BoardVO;
import mbti_vo.MbtiVO;
import mbti_vo.UserItemVO;
import mbti_vo.UserVO;

public class UserDAO extends DBConn{
	
	/** 로그인 처리 **/
	public boolean getLoginResult(String id, String pass) {
		UserVO user = new UserVO();
		UserItemVO uitem = new UserItemVO();
		BoardVO board = new BoardVO();
		boolean result = false;
		
		try {
			String sql = " SELECT U_ID, COUNT(*) FROM USER_TABLE "
					+ " WHERE U_ID=? AND U_PASS=? GROUP BY U_ID";
			getPreparedStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				uitem.setU_id(rs.getString(1));
				board.setB_id(rs.getString(1));
				user.setU_id(rs.getString(1));
				if(rs.getInt(2) == 1) {
					result = true;
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
				if(rs.getInt(1) == 1) result = false;
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
			String sql = " INSERT INTO USER_TABLE(U_ID,U_PASS,U_MBTI,U_DATE) "
					+ " VALUES(?,?,?,sysdate)";
					
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_pass());
			pstmt.setString(3, user.getU_mbti());
			
			int val = pstmt.executeUpdate();
			if(val != 0) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		
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
	
	/** 유저 정보 검색 (admin)**/
	public ArrayList<UserVO> getUserSearchAdminResult(String id) {
		ArrayList<UserVO> ulist = new ArrayList<UserVO>();
		
		try {
			String sql = " SELECT U_ID,U_MBTI,U_POINT,U_DATE "
					+ "	FROM USER_TABLE WHERE U_ID LIKE '%' " + 
					" ||?|| '%' " ;
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setU_id(rs.getString(1));
				user.setU_mbti(rs.getString(2));
				user.setU_point(rs.getInt(3));
				user.setU_date(rs.getString(4));
				ulist.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ulist;
		
	}
	
	/**유저 정보 체크(admin)**/
	public boolean getUserExsistResult(String id) {
		boolean result = false;
		
		try {
			String sql = 
//					"SELECT COUNT(*) FROM USER_TABLE " + 
//					" WHERE U_ID = ? "
					" SELECT COUNT(*) "
					+ "	FROM USER_TABLE WHERE U_ID LIKE '%' " + 
					" ||?|| '%' " ;
			getPreparedStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getInt(1) >= 1) result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 유저 정보 조회(admin)**/
	public ArrayList<UserVO> getUserDataResult() {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			String sql = "SELECT U_ID, U_PASS, U_MBTI,U_DATE,U_POINT " + 
					" FROM USER_TABLE ";
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

