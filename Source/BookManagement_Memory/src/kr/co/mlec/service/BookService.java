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
	 * 도서 추가
	 */
	public void insertBook(BookVO book) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		book.setRegDate(sdf.format(new Date()));
		book.setNo(BookVO.getBookNo());
		
		dao.insert(book);
	}
	
	/*
	 * 도서 삭제
	 */
	public int deleteBook(int bookNo) throws Exception {
		return dao.delete(bookNo);
	}
	
	/*
	 * 도서 번호로 검색
	 */
	public BookVO findBook(int bookNo) throws Exception {
		return dao.find(bookNo);
	}
	
	/*
	 * 도서 제목과 저자로 검색
	 */
	public BookVO findBook(String title, String author) throws Exception {
		return dao.find(title, author);
	}
	
	/*
	 * 전체 도서 목록 조회
	 */
	public List<BookVO> findAllBook() throws Exception {
		return dao.findAll();
	}
	

	


	
	
	
}
