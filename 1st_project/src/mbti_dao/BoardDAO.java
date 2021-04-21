package mbti_dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import mbti_gui.BoardReadUI;
import mbti_vo.BoardVO;
import mbti_vo.UserVO;

public class BoardDAO extends DBConn {
	
	/** 등록 **/
	public boolean getInsertResult(BoardVO board) {
		boolean result = false;
		String sql = "";

		try {
			if (board.getB_filepath().equals("")) {
				sql = " INSERT INTO BOARD_TABLE(B_RNO,B_TITLE,B_CONTENT,B_ID,B_DATE) "
						+ " VALUES(SEQ_BOARD.NEXTVAL,?,?,?,sysdate)";
				getPreparedStatement(sql);

			} else {
				sql = " INSERT INTO BOARD_TABLE(B_RNO,B_TITLE,B_CONTENT,B_ID,B_DATE,B_FILEPATH, B_IMG) "
						+ " VALUES(SEQ_BOARD.NEXTVAL,?,?,?,sysdate,?,?)";
				getPreparedStatement(sql);

				pstmt.setString(4, board.getB_filepath());
				
				FileInputStream fin = new FileInputStream(board.getB_filepath());
				pstmt.setBinaryStream(5, fin, fin.available());
			}

			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setString(3, board.getB_id());

			int val = pstmt.executeUpdate();
			if (val != 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/** 조회 **/
	public ArrayList<BoardVO> getSelectResult(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			String sql = " SELECT * FROM BOARD_TABLE ORDER BY B_RNO DESC ";
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
	
	/** 읽기 **/
	public BoardVO getReadResult(int no) {
		BoardVO board = new BoardVO();
		try {
			String sql = " SELECT * FROM BOARD_TABLE WHERE B_RNO = ? ";
			getPreparedStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				board.setB_rno(rs.getInt(1));
				board.setB_title(rs.getString(2));
				board.setB_content(rs.getString(3));
				board.setB_id(rs.getString(4));
				board.setB_date(rs.getDate(5));
				board.setB_good(rs.getInt(6));
				board.setB_bad(rs.getInt(7));
				
				if(rs.getString(8) != null) {
					board.setB_filepath(rs.getString(8));
					
					InputStream in = rs.getBinaryStream(9);
					board.setB_img(ImageIO.read(in)); // &&&
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return board;
	}
	
	/** 검색 **/ // ###0419 
	public ArrayList<BoardVO> getSearchResult(String title) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			String sql = " SELECT * FROM BOARD_TABLE WHERE B_TITLE LIKE '%' ||?|| '%' ORDER BY B_RNO DESC";
			getPreparedStatement(sql);
			pstmt.setString(1, title);

			rs = pstmt.executeQuery();
			while (rs.next()) {
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
			e.printStackTrace();
		}

		return list;
	}
	
	/**관리자 검색**/
	public ArrayList<BoardVO> getSearchAdminResult(String title) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			String sql = " SELECT * FROM BOARD_TABLE WHERE B_TITLE LIKE '%' ||?|| '%' ORDER BY B_RNO";
			getPreparedStatement(sql);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/** 수정 **/
	public int getUpdateResult(BoardVO board) {
		int result = 0;
		String sql = "";

		try {
			if (board.getB_filepath().equals("")) {
				sql = " UPDATE BOARD_TABLE SET B_TITLE = ?, B_CONTENT = ?, B_FILEPATH = NULL, B_IMG = NULL WHERE B_RNO = ? ";
				getPreparedStatement(sql);
				pstmt.setInt(3, board.getB_rno());
				
			} else {
				sql = " UPDATE BOARD_TABLE SET B_TITLE = ?, B_CONTENT = ?, B_FILEPATH = ?, B_IMG = ? WHERE B_RNO = ?";
				getPreparedStatement(sql);

				pstmt.setString(3, board.getB_filepath());
				
				FileInputStream fin = new FileInputStream(board.getB_filepath());
				pstmt.setBinaryStream(4, fin, fin.available());
				
				pstmt.setInt(5, board.getB_rno());

			}
			
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	
	/** 삭제 (admin + 일반) **/
	public boolean getDeleteResult(int bno) {
		boolean result = false;
		
		try {
			String sql = " DELETE FROM BOARD_TABLE WHERE B_RNO = ?";
			getPreparedStatement(sql);
			
			pstmt.setInt(1, bno);
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
	
	/**보드 정보 null체크(admin)**/
	public boolean getBoardExsistResult(String title) {
		boolean result = false;
		
		try {
			String sql = 
//					"SELECT COUNT(*) FROM BOARD_TABLE " + 
//					" WHERE B_TITLE = ? "
					" SELECT COUNT(*) "
					+ "	FROM BOARD_TABLE WHERE B_TITLE LIKE '%' " + 
					" ||?|| '%' " ;
			getPreparedStatement(sql);
			
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getInt(1) >= 1) result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 추천 **/
	public int getUpdateRecommendResult(int recommend, int no) {
		int result = 0;

		try {
//			String sql = " UPDATE BOARD_TABLE SET B_? = B_? + 1 WHERE B_RNO = ? ";
			String sql = "";
			
			if (recommend == BoardReadUI.GOOD) {
				sql = " UPDATE BOARD_TABLE SET B_GOOD = B_GOOD + 1 WHERE B_RNO = ? ";
			} else if (recommend == BoardReadUI.BAD) {
				sql = " UPDATE BOARD_TABLE SET B_BAD = B_BAD + 1 WHERE B_RNO = ? ";
			}
			getPreparedStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
	
	public boolean getAddPointResult(BoardVO board) {
		boolean result = false;

		try {
			String sql = " UPDATE USER_TABLE SET U_POINT = U_POINT+10 WHERE U_ID = ? ";
			getPreparedStatement(sql);
			pstmt.setString(1, board.getB_id());

			int val = pstmt.executeUpdate();

			if (val != 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
