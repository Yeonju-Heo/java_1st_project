package mbti_dao;

import mbti_vo.ItemVO;
import mbti_vo.UserVO;

public class ItemDAO extends DBConn{
	
	/** 뽑은 아이템 user_table에 추가 **/
	public int getPickItemResult(UserVO user, ItemVO item) {
		int result = 0;
		
		try {
			String sql = " UPDATE USER_TABLE"
					+ " SET U_ITEM = ITEM_LIST(U_ITEM(?)) "
					+ " WHERE U_ID = ?";
					
			getPreparedStatement(sql);
			
			pstmt.setString(1, item.getI_type());
			pstmt.setString(2, user.getU_id());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
}
