package mbti_system;

import java.util.ArrayList;

import mbti_dao.BoardDAO;
import mbti_dao.ItemDAO;
import mbti_dao.MbtiDAO;
import mbti_dao.UserDAO;
import mbti_dao.UserItemDAO;
import mbti_vo.BoardVO;
import mbti_vo.ItemVO;
import mbti_vo.MbtiVO;
import mbti_vo.UserItemVO;
import mbti_vo.UserVO;

public class MbtiMgmSystem {
	//Field
	UserDAO udao = new UserDAO();
	BoardDAO bdao = new BoardDAO();
	MbtiDAO mdao = new MbtiDAO();
	ItemDAO idao = new ItemDAO();
	UserItemDAO u_idao = new UserItemDAO();
	
	//login 결과
	public static boolean LOGIN_RESULT = false;
	
	//Constructor
	public MbtiMgmSystem() {
		
	}
	
	//Method
	/**  로그인 **/
	public boolean loginCheck(String id, String pass) {
		return udao.getLoginResult(id, pass);
	}
	
	/** 회원가입 **/
	public boolean join(UserVO user,MbtiVO mbti) {
		return udao.getJoinResult(user, mbti);
	}
	
	/** 회원 정보 조회 **/
	public UserVO searchUser(String id) {
		return udao.getUserDateResult(id);
	}
	
	/** 회원 아이템 조회 **/
	public UserItemVO searchItem(UserVO user) {
		return u_idao.getUserItemResult(user);
	}
	
	/** 회원 비밀번호 수정 **/
	public int updateUser(UserVO user,String pass) {
		return udao.getUpdateUserResult(user, pass);
	}
	
	
	/** 종료 **/
	public void close() {
		udao.close();
		System.out.println("--- 데이터베이스 연결 종료 ---");
	}
	
	/** 게시판 등록 **/
	public boolean insertBoard(BoardVO board,UserVO user) {
		return bdao.getInsertResult(board, user);
	}
	
	/** 게시판 조회 **/
	public ArrayList<BoardVO> getBoardList(){
		return bdao.getSelectResult();
	}
	
	/** 게시판 검색 **/
	public BoardVO searchBoard(String title) {
		return bdao.getSelectResult(title);
	}
	
	/** 게시판 수정 **/
	public int updateBoard(BoardVO board, String content) {
		return bdao.getUpdateResult(board, content);
	}
	
	/** 내 mbti 조회 **/
	public MbtiVO getMbti(UserVO user) {
		return mdao.getMbtiSelectResult(user);
	}
	
	/** 뽑은 아이템 추가 **/
	public boolean updateUserItem(UserVO user, ItemVO item) {
		return u_idao.getUserItemResult(user, item);
	}
	
}
