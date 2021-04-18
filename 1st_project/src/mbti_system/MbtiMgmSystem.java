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
	//Field//
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
   public boolean join(UserVO user) {
      return udao.getJoinResult(user);
   }
	
	/** 회원 정보 조회 **/
	public UserVO searchUser(String id) {
		return udao.getUserDataResult(id);
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
	
//	/** 게시판 등록 **/
//	public boolean insertBoard(BoardVO board,UserVO user) {
//		return bdao.getInsertResult(board, user);
//	}
//	
//	/** 게시판 조회 **/
//	public ArrayList<BoardVO> getBoardList(){
//		return bdao.getSelectResult();
//	}
//	
//	/** 게시판 검색 **/
//	public BoardVO searchBoard(String title) {
//		return bdao.getSelectResult(title);
//	}
//	
//	/** 게시판 수정 **/
//	public int updateBoard(BoardVO board, String content) {
//		return bdao.getUpdateResult(board, content);
//	}
	
	
	/** 게시판 등록 **/
	public boolean insertBoard(BoardVO board) {
		return bdao.getInsertResult(board);
	}
	
	/** 게시판 조회 **/
	public ArrayList<BoardVO> getBoardList(){
		return bdao.getSelectResult();
	}
	
	/** 게시판 글 읽기 **/
	public BoardVO readBoard(int no) {
		return bdao.getReadResult(no);
	}
	
	/** 게시판 검색 **/
	public BoardVO searchBoard(String title) {
		return bdao.getSelectResult(title);
	}
	
	/** 게시판 수정 **/
	public int updateBoard(BoardVO board, String content) {
		return bdao.getUpdateResult(board, content);
	}
	
	/** 게시판 추천 **/
	public int updateRecommend(int recommend, int no) {
		return bdao.getUpdateRecommendResult(recommend, no);
	}
	
	/** 게시판 삭제 **/
	public boolean deleteBoard(int no) {
		return bdao.getDeleteResult(no);
	}
	
	
	/** 내 mbti 조회 **/
	public MbtiVO getMbti(UserVO user) {
		return mdao.getMbtiSelectResult(user);
	}
	
	/** 뽑은 아이템 추가 **/
	public boolean updateUserItem(UserVO user, ItemVO item) {
		return u_idao.getUserItemResult(user, item);
	}
	
	
	/** 관리자 유저 검색 **/
	public UserVO getUserDateSelect(String id){
		System.out.println("검색");
		return udao.getUserSearchAdminResult(id);
	}
	/** 유저 검색 **/
	public UserVO getUserDataSelect(String id){
		System.out.println("메인시스템");
		return udao.getUserDataResult(id);
	}
	
	/** 관리자 유저 조회 **/
	public ArrayList<UserVO> getUserDateSelect(){
		System.out.println("조회");
		return udao.getUserDataResult();
	}
	
	/** 유저 조회 **/
	public ArrayList<UserVO> getUserDataSelect(){
		System.out.println("메인시스템");
		return udao.getUserDataResult();
	}
	
//	/** 유저 삭제 **/
//	public UserVO getUserDateDelete(String id){
//		System.out.println("삭제");
//		return udao.getUserDateResult(id);
//	public  UserVO getUserDatSelect(String id){
//		System.out.println("메인시스템");
//		return udao.getUserDataResult();
//	}
	
	/** 관리자 유저 삭제 **/
	public boolean deleteAdminUser(String name) {
		return udao.getDeleteUserAdmin(name);
	}
//	/** 관리자 유저 삭제 **/
//	public int deleteAdminBoard(BoardVO) {
//		
//	}
	
	/** 관리자 보드 삭제 **/
	public boolean deleteAdminBoard(int bno) {
		return bdao.getDeleteResult(bno);
	}
}
