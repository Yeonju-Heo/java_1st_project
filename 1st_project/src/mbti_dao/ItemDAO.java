package mbti_dao;

import mbti_vo.ItemVO;
import mbti_vo.UserVO;

public class ItemDAO extends DBConn{
	
	/** 유저 아이템 조회 **/
	public ItemVO getUserItemResult(String item_name) {
		ItemVO item = new ItemVO();
		
		try {
			String sql = " SELECT I_TYPE FROM ITEM_TABLE "
					+ " WHERE I_TYPE = ?";
			getPreparedStatement(sql);
			pstmt.setString(1, item_name);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				item.setI_type(rs.getString(1));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return item;
		
	}
	
	
}
