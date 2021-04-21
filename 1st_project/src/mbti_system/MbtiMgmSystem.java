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
import mbti_vo.MessageVO;
import mbti_vo.UserItemVO;
import mbti_vo.UserVO;

public class MbtiMgmSystem {
	// Field//
	UserDAO udao = new UserDAO();
	BoardDAO bdao = new BoardDAO();
	MbtiDAO mdao = new MbtiDAO();
	ItemDAO idao = new ItemDAO();
	UserItemDAO u_idao = new UserItemDAO();

	// login 결과
	public static boolean LOGIN_RESULT = false;

	// Constructor
	public MbtiMgmSystem() {

	}

	// Method
	/** 로그인 **/
	public int loginCheck(String id, String pass) { //#############################
		return udao.getLoginResult(id, pass);
	}

	/** 회원가입 **/
	public boolean join(UserVO user) {
		return udao.getJoinResult(user);
	}

	/** 회원가입 아이디 중복 **/
	public boolean idCheck(String id) {
		return udao.getIdCheck(id);
	}
	
	/** 유저 포인트 차감(헤어) **/
	public boolean subHairPoint(UserVO user) {
		return udao.getSubHairPointResult(user);
	}

	/** 유저 포인트 차감(상의,하의) **/
	public boolean subTopBottomPoint(UserVO user) {
		return udao.getSubTopBottomPointResult(user);
	}
	
	/** 회원 정보 조회 **/
	public UserVO searchUser(String id) {
		return udao.getUserDataResult(id);
	}

	/** 회원 아이템 헤어 조회 **/
	public ArrayList<UserItemVO> searchHairItem(String id) {
		return u_idao.getUserHairItem(id);
	}
	
	/** 회원 아이템 상의 조회 **/
	public ArrayList<UserItemVO> searchTopItem(String id) {
		return u_idao.getUserTopItem(id);
	}
	
	/** 회원 아이템 하의 조회 **/
	public ArrayList<UserItemVO> searchBottomItem(String id) {
		return u_idao.getUserBottomItem(id);
	}

	/** 회원 비밀번호 수정 **/
	public int updateUser(UserVO user, String pass) {
		return udao.getUpdateUserResult(user, pass);
	}

	/** 모든 아이템 조회 **/
	public ArrayList<ItemVO> getItem() {
		return idao.getItemResult();
	}

	/** 내 mbti 조회 **/
	public MbtiVO getMbti(UserVO user) {
		return mdao.getMbtiSelectResult(user);
	}

	/** 종료 **/
	public void close() {
		udao.close();
		System.out.println("--- 데이터베이스 연결 종료 ---");
	}

	/** 게시판 등록 **/
	public boolean insertBoard(BoardVO board) {
		return bdao.getInsertResult(board);
	}

	/** 게시판 조회 **/
	public ArrayList<BoardVO> getBoardList() {
		return bdao.getSelectResult();
	}

	/** 게시판 글 읽기 **/
	public BoardVO readBoard(int no) {
		return bdao.getReadResult(no);
	}

	/** 게시판 검색 **/
	public ArrayList<BoardVO> searchBoard(String title) {
		return bdao.getSearchResult(title);
	}

	/** 게시판 수정 **/
	public int updateBoard(BoardVO board) {
		return bdao.getUpdateResult(board);
	}

	/** 게시판 추천 **/
	public int updateRecommend(int recommend, int no) {
		return bdao.getUpdateRecommendResult(recommend, no);
	}

	/** 게시판 삭제 **/
	public boolean deleteBoard(int no) {
		return bdao.getDeleteResult(no);
	}

	/** 게시판 포인트 추가 **/
	public boolean addPoint(BoardVO board) {
		return bdao.getAddPointResult(board);
	}

	/** 뽑은 아이템 추가 **/
	public boolean updateUserItem(String id, String item) {
		return u_idao.getUserItemResult(id, item);
	}

	/** 관리자 유저 검색 **/
	public ArrayList<UserVO> getUserDateSelect(String id) {
		System.out.println("검색");
		return udao.getUserSearchAdminResult(id);
	}

	/** 유저 검색 **/
	public UserVO getUserDataSelect(String id) {
		System.out.println("메인시스템");
		return udao.getUserDataResult(id);
	}
	
	/** 유저 검색 (채팅)**/
	public UserVO getChatUserDataSelect(String id) {
		System.out.println("메인시스템");
		return udao.getChatUserDataResult(id);
	}
	
	/** 관리자 유저 조회 **/
	public ArrayList<UserVO> getUserDateSelect() {
		System.out.println("조회");
		return udao.getUserDataResult();
	}

	/** 관리자 유저 조회(null체크) **/
	public boolean getUserDateExsistSelect(String id) {
		System.out.println("조회");
		return udao.getUserExsistResult(id);
	}

	/** 관리자 게시글 조회(null체크) **/
	public boolean getBoardDateExsistSelect(String title) {
		System.out.println("조회");
		return bdao.getBoardExsistResult(title);
	}

	/** 유저 조회 **/
	public ArrayList<UserVO> getUserDataSelect() {
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

	/** 관리자 보드 삭제 **/
	public boolean deleteAdminBoard(int bno) {
		return bdao.getDeleteResult(bno);
	}

	/** 관리자 게시판 검색 **/
	public ArrayList<BoardVO> searchAdminBoard(String title) {
		return bdao.getSearchAdminResult(title);
	}
}
