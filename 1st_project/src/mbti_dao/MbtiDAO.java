package mbti_dao;

import mbti_vo.MbtiVO;
import mbti_vo.UserVO;

public class MbtiDAO extends DBConn {
	
	/** 내 MBTI 조회 **/
	public MbtiVO getMbtiSelectResult(UserVO user) {
		MbtiVO mbti = new MbtiVO();
		
		try {
			String sql = " SELECT * FROM MBTI_TABLE WHERE MBTI_TYPE="
					+ "(SELECT U_MBTI FROM USER_TABLE WHERE U_ID = ?)";
			
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mbti.setMbti_type(rs.getString(1));
				mbti.setMbti_label(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mbti;
	}

}
