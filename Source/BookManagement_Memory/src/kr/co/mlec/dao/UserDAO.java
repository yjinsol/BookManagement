package kr.co.mlec.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.mlec.service.BookService;
import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.UserVO;

public class UserDAO {
	private List<UserVO> memberList;
	
	public UserDAO() {
		memberList = new ArrayList<>();
		memberList.add(new UserVO(UserVO.getUserNo(), "Manager", "0000", "관리자"));
	}
	
	/*
	 * 회원등록
	 */
	public boolean insert(UserVO user) throws Exception {
		boolean bool = true;
		for(UserVO u : memberList) {
			if(u.getId().equals(user.getId())) {
				bool = false;
				break;
			}
		}
		if(bool) {
			memberList.add(user);
		}
		System.out.println(memberList);
		return bool;
	}
	

	/*
	 * 회원검색
	 */
	public UserVO find(String userId) throws Exception {
		for(UserVO user : memberList) {
			if(user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
	/*
	 * 로그인
	 */
	public UserVO login(UserVO user) throws Exception {
		for(UserVO u : memberList) {
			if(u.getId().equals(user.getId()) && u.getPasswd().equals(user.getPasswd())) {
				return u;
			}
		}
		return null;
	}
	
	/*
	 * 전체 회원 목록 조회
	 */
	public List<UserVO> findAllMember() throws Exception {
		return memberList;
	}

	/*
	 * 도서 대여
	 */
	public void insert(BookService bService, int bookNo, UserVO user) throws Exception {
		for(BookVO uBook : user.getuBookList()) {
			if(uBook.getNo() == bookNo) {
				System.out.println("도서가 이미 존재합니다.");
				return;
			}
		}
		List<BookVO> bookList = bService.findAllBook();
		for(BookVO book : bookList) {
			if(book.getNo() == bookNo) { 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
				book.setRegDate(sdf.format(new Date()));
				user.insertuBookList(book);
				System.out.println("[" + bookNo + "]번 도서를 대여하였습니다.");
				return;
			}
		}
		System.out.println("[" + bookNo + "]번 도서가 존재하지 않습니다.");
	}
	
	
	/*
	 * 도서 반납
	 */
	public int delete(int no, UserVO user) throws Exception {
		for(BookVO book : user.getuBookList()) {
			if(book.getNo() == no) {
				user.deleteuBookList(book);
				return 1;
			}
		}
		return -1;
	}
	
}
