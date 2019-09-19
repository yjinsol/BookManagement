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
		memberList.add(new UserVO(UserVO.getUserNo(), "Manager", "0000", "������"));
	}
	
	/*
	 * ȸ�����
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
	 * ȸ���˻�
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
	 * �α���
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
	 * ��ü ȸ�� ��� ��ȸ
	 */
	public List<UserVO> findAllMember() throws Exception {
		return memberList;
	}

	/*
	 * ���� �뿩
	 */
	public void insert(BookService bService, int bookNo, UserVO user) throws Exception {
		for(BookVO uBook : user.getuBookList()) {
			if(uBook.getNo() == bookNo) {
				System.out.println("������ �̹� �����մϴ�.");
				return;
			}
		}
		List<BookVO> bookList = bService.findAllBook();
		for(BookVO book : bookList) {
			if(book.getNo() == bookNo) { 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
				book.setRegDate(sdf.format(new Date()));
				user.insertuBookList(book);
				System.out.println("[" + bookNo + "]�� ������ �뿩�Ͽ����ϴ�.");
				return;
			}
		}
		System.out.println("[" + bookNo + "]�� ������ �������� �ʽ��ϴ�.");
	}
	
	
	/*
	 * ���� �ݳ�
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
