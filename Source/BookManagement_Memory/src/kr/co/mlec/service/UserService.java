package kr.co.mlec.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.mlec.dao.UserDAO;
import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.UserVO;


public class UserService {
	private UserDAO dao;

	public UserService() {
		dao = new UserDAO();
	}
	
	/*
	 * 회원등록
	 */
	public boolean insertMember(UserVO user) throws Exception {
		user.setNo(UserVO.getUserNo());
		return dao.insert(user);
	}

	
	/*
	 * 회원검색
	 */
	public UserVO findMember(String userId) throws Exception {
		return dao.find(userId);
	}
	
	/*
	 * 로그인
	 */
	public UserVO login(UserVO user) throws Exception {
		return dao.login(user);
	}
	
	
	/*
	 * 전체 회원 목록 조회
	 */
	public List<UserVO> findAllMember() throws Exception {
		return dao.findAllMember();
	}
	
	/*
	 * 도서 대여
	 */
	public void insertBook(BookService bService, int bookNo, UserVO user) throws Exception {
		dao.insert(bService, bookNo, user);
	}
	
	
	/*
	 * 도서 반납
	 */
	public int deleteBook(int no, UserVO user) throws Exception {
		return dao.delete(no, user);
	}
}
