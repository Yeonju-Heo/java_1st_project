package mbti_dao;

import mbti_vo.ItemVO;
import mbti_vo.MbtiVO;
import mbti_vo.UserVO;

public class UserDAO extends DBConn{
	
	/** 로그인 처리 **/
	public boolean getLoginResult(String id, String pass) {
		boolean result = false;
		
		try {
			String sql = " SELECT COUNT(*) FROM USER_TABLE "
					+ " WHERE U_ID=? AND U_PASS=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == 1) {
					result = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 회원가입 처리 **/

	//U_ID,U_PASS,U_MBTI,U_POINT,U_DATE,U_ITEM

	public boolean getJoinResult(UserVO user, MbtiVO mbti) {
		boolean result = false;
		
		try {
			String sql = " INSERT INTO USER_TABLE(U_ID,U_PASS,U_MBTI,U_DATE) "
					+ " VALUES(?,?,?,sysdate)";
					
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_pass());
			pstmt.setString(3, mbti.getMbti_type());
			
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
	public UserVO getUserDateResult(String id) {
		UserVO user = new UserVO();
		
		try {
			String sql = " SELECT U_ID,U_MBTI,U_POINT,U_DATE"
					+ "	FROM USER_TABLE WHERE U_ID = ?";
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				user.setU_id(rs.getString(1));
				user.setU_mbti(rs.getString(2));
				user.setU_point(rs.getInt(3));
				user.setU_date(rs.getDate(4));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	/** 유저 아이템 조회 **/
	public UserVO getUserItemResult() {//userVO-u_item도 어레이리스트로 만들어야할까??ㅜㅜㅜ
		UserVO user = new UserVO();
		
		try {
			String sql = " SELECT U_ITEM FROM USER_TABLE";
			getPreparedStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				user.setU_item(rs.getString(1));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	/** 유저 비밀번호 수정 **/
	public int getUpdateResult(String pass, UserVO user) {
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

