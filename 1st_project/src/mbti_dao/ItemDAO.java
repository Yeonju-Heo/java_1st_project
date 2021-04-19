package mbti_dao;

import mbti_vo.ItemVO;
import mbti_vo.UserVO;

public class ItemDAO extends DBConn{
	
	/** 모든 아이템 조회 **/
	public ItemVO getItemResult() {
		ItemVO item = new ItemVO();
		
		try {
			String sql = " SELECT I_TYPE FROM ITEM_TABLE ";
			getPreparedStatement(sql);
			
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
