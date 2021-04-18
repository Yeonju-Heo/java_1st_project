package mbti_dao;

import java.util.ArrayList;

import mbti_vo.BoardVO;
import mbti_vo.UserVO;

public class BoardDAO extends DBConn {
	
	/** 등록 **/
	public boolean getInsertResult(BoardVO board, UserVO user) {
		boolean result = false;
		
		try {
			String sql = " INSERT INTO BOARD_TABLE(B_RNO,B_TITLE,B_CONTENT,B_ID,B_DATE) "
					+ " VALUES(SEQ_BOARD.NEXTVAL,?,?,?,sysdate)";
			getPreparedStatement(sql);
			
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setString(3, user.getU_id());
			
			int val = pstmt.executeUpdate();
			if(val != 0) {
				result = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	/** 조회 **/
	public ArrayList<BoardVO> getSelectResult(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			String sql = " SELECT * FROM BOARD_TABLE ";
			getPreparedStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setB_rno(rs.getInt(1));
				board.setB_title(rs.getString(2));
				board.setB_content(rs.getString(3));
				board.setB_id(rs.getString(4));
				board.setB_date(rs.getDate(5));
				board.setB_good(rs.getInt(6));
				board.setB_bad(rs.getInt(7));
				
				list.add(board);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	/** 검색 **/
	public BoardVO getSelectResult(String title){
		BoardVO board = new BoardVO();
		try {
			String sql = " SELECT * FROM BOARD_TABLE WHERE B_TITLE=?";
			getPreparedStatement(sql);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setB_rno(rs.getInt(1));
				board.setB_title(rs.getString(2));
				board.setB_content(rs.getString(3));
				board.setB_id(rs.getString(4));
				board.setB_date(rs.getDate(5));
				board.setB_good(rs.getInt(6));
				board.setB_bad(rs.getInt(7));
							
			}		
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	/** 수정 **/
	public int getUpdateResult(BoardVO board, String content) {
		int result = 0;
		
		try {
			String sql = " UPDATE BOARD_TABLE "
					+ " SET B_CONTENT = ? WHERE B_RNO=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setInt(2, board.getB_rno());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 삭제 **/
	public boolean getDeleteResult(BoardVO board) {
		boolean result = false;
		
		try {
			String sql = " DELETE FROM BOARD_TABLE WHERE B_RNO = ?";
			getPreparedStatement(sql);
			
			pstmt.setInt(1, board.getB_rno());
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
	
}
