package kr.co.mlec.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.service.UserService;
import kr.co.mlec.service.UserServiceFactory;
import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.UserVO;

public class BookDAO {
	private List<BookVO> bookList;
	
	public BookDAO() {
		bookList = new ArrayList<>();
	}

	

	public List<BookVO> getBookList() {
		return bookList;
	}

	/*
	 * 도서 추가
	 */
	public void insert(BookVO book) throws Exception {
		for(BookVO b : bookList) {
			if(b.getNo() == book.getNo()) {
				System.out.println("도서가 이미 존재합니다.");
				return;
			}
		}
		bookList.add(book);
		System.out.println(bookList);
	}
	
	/*
	 * 도서 삭제
	 */
	public int delete(int bookNo) throws Exception {
		UserService uService = UserServiceFactory.getInstance();
		List<UserVO> uList = uService.findAllMember();
		List<BookVO> uBookList = null;
		
		// 대여중인 도서가 삭제될 경우 uBookList에서도 해당 도서 정보 삭제
		for(int i = 0; i < uList.size(); i++) {
			UserVO user = uList.get(i); 
			uBookList = user.getuBookList();
			if(!uBookList.isEmpty()) {
				for(int j = 0; j < uBookList.size(); j++) {
					BookVO book  = uBookList.get(j); 
					if(book.getNo() == bookNo)
						uService.deleteBook(book.getNo(), user);
				}
			}
		}
		
		
		// bookList에서 해당 도서 정보 삭제
		for(BookVO book : bookList) {
			if(book.getNo() == bookNo) {
				bookList.remove(book);
//				arrangeNo(book.getNo());
//				BookVO.setBookNo();
				System.out.println(bookList);
				return 1;
			}
		}
		return -1;
	}
	
	
	/*
	// 도서 번호 정렬
	public void arrangeNo(int no) throws Exception {
		for(BookVO book : bookList) {
			if(book.getNo() > no) {
				book.setNo(book.getNo()-1);
			}
		}
	}
	*/
	
	
	/*
	 * 도서 번호로 검색
	 */
	public BookVO find(int bookNo) throws Exception {
		for(BookVO book : bookList) {
			if(book.getNo() == bookNo) {
				return book;
			}
		}
		return null;
	}
	
	/*
	 * 도서 제목과 저자로 검색
	 */
	public BookVO find(String title, String author) throws Exception {
		for(BookVO book : bookList) {
			if(book.getTitle().equals(title) && book.getAuthor().equals(author)) {
				return book;
			}
		}
		return null;
	}
	
	/*
	 * 전체 도서 목록 조회
	 */
	public List<BookVO> findAll() throws Exception {
		if(bookList.size() == 0)
			return null;
		return bookList;
	}
	
}
