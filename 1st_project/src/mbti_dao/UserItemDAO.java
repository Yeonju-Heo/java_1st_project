package mbti_dao;

import mbti_vo.ItemVO;
import mbti_vo.UserItemVO;
import mbti_vo.UserVO;

public class UserItemDAO extends DBConn{
	
	
	/** 뽑은 아이템 USER_ITEM_TABLE에 추가 **/
	public boolean getUserItemResult(UserVO user, ItemVO item) {
		boolean result = false;
		
		try {
			String sql = " INSERT INTO USER_ITEM_TABLE "
					+ " VALUES(?,?)";
			getPreparedStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, item.getI_type());
			
			int val = pstmt.executeUpdate();
			if(val != 0) {
				result = true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 유저 아이템 조회 **/
	public UserItemVO getUserItemResult(UserVO user) {
		UserItemVO uitem = new UserItemVO();
		
		try {
			String sql = " SELECT I_NAME FROM USER_ITEM_TABLE WHERE U_ID = ?";
			getPreparedStatement(sql);
			pstmt.setString(1, user.getU_id());
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				uitem.setI_name(rs.getString(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return uitem;

	}
	
}
