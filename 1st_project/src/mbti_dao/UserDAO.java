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

	public boolean getJoinResult(UserVO user, ItemVO item, MbtiVO mbti) {
		boolean result = false;
		
		try {
			String sql = " INSERT INTO USER_TABLE VALUES(?,?,?,?,sysdate,?)";
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_pass());
			pstmt.setString(3, mbti.getMbti_type());
			pstmt.setInt(4, user.getU_point());
			pstmt.setString(5, item.getI_type());
			
			int val = pstmt.executeUpdate();
			if(val != 0) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	
}

