package mbti_dao;

import mbti_vo.MbtiVO;
import mbti_vo.UserVO;

public class MbtiDAO extends DBConn {
	
	/** MBTI 설명 조회 **/
	public MbtiVO getSelectResult(UserVO user) {
		MbtiVO mbti = new MbtiVO();
		
		try {
			String sql = " SELECT MBTI_TYPE FROM MBTI_TABLE WHERE MBTI_TYPE=?";
			
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_mbti());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mbti;
	}

}
