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
	 * ȸ�����
	 */
	public boolean insertMember(UserVO user) throws Exception {
		user.setNo(UserVO.getUserNo());
		return dao.insert(user);
	}

	
	/*
	 * ȸ���˻�
	 */
	public UserVO findMember(String userId) throws Exception {
		return dao.find(userId);
	}
	
	/*
	 * �α���
	 */
	public UserVO login(UserVO user) throws Exception {
		return dao.login(user);
	}
	
	
	/*
	 * ��ü ȸ�� ��� ��ȸ
	 */
	public List<UserVO> findAllMember() throws Exception {
		return dao.findAllMember();
	}
	
	/*
	 * ���� �뿩
	 */
	public void insertBook(BookService bService, int bookNo, UserVO user) throws Exception {
		dao.insert(bService, bookNo, user);
	}
	
	
	/*
	 * ���� �ݳ�
	 */
	public int deleteBook(int no, UserVO user) throws Exception {
		return dao.delete(no, user);
	}
}
