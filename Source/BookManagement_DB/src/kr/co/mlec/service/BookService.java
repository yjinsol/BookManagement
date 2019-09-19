package kr.co.mlec.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.mlec.dao.BookDAO;
import kr.co.mlec.vo.BookVO;

public class BookService {
	private BookDAO dao;

	public BookService() {
		dao = new BookDAO();
	}
	
	
	
	public BookDAO getDao() {
		return dao;
	}


	/*
	 * ���� �߰�
	 */
	public void insertBook(BookVO book) throws Exception {
		
		dao.insert(book);
	}
	
	/*
	 * ���� ����
	 */
	public int deleteBook(int bookNo) throws Exception {
		return dao.delete(bookNo);
	}

	/*
	 * ���� ��ȣ�� �˻�
	 */
	public BookVO findBook(int bookNo) throws Exception {
		return dao.find(bookNo);
	}
	
	/*
	 * ���� ����� ���ڷ� �˻�
	 */
	public BookVO findBook(String title, String author) throws Exception {
		return dao.find(title, author);
	}
	
	/*
	 * ��ü ���� ��� ��ȸ
	 */
	public List<BookVO> findAllBook() throws Exception {
		return dao.findAll();
	}
	

	


	
	
	
}
