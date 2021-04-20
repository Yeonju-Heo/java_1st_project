package mbti_dao;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import mbti_vo.UserItemVO;

public class UserItemDAO extends DBConn{
	
	
	/** 뽑은 아이템 USER_ITEM_TABLE에 추가 **/
	//U_ID, I_NAME, I_CONTENT, I_CLOSET
	public boolean getUserItemResult(String id, String item) {
		boolean result = false;
		
		try {
			String sql = " INSERT INTO USER_ITEM_TABLE "
					+ " VALUES(?,?,?,?)";
			getPreparedStatement(sql);
			pstmt.setString(1, id);
//			pstmt.setString(2, item.getI_type());
			pstmt.setString(2, item);
			
			FileInputStream fin = new FileInputStream("images/merge_"+item+".png");
			
			pstmt.setBinaryStream(3, fin, fin.available());
			
			fin = new FileInputStream("images/closet_"+item+".png");
			pstmt.setBinaryStream(4, fin, fin.available());
			
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
	public UserItemVO getUserItemResult(String id) {
		UserItemVO uitem = new UserItemVO();
		
		try {
			String sql = " SELECT I_NAME,I_CONTENT,I_CLOSET FROM USER_ITEM_TABLE WHERE U_ID = ?";
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				uitem.setI_name(rs.getString(1));
				InputStream in = rs.getBinaryStream(2);
				uitem.setI_content(ImageIO.read(in));
				in = rs.getBinaryStream(3);
				uitem.setI_closet(ImageIO.read(in));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return uitem;

	}
	
}
