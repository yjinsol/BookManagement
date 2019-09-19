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
	 * ���� �߰�
	 */
	public void insert(BookVO book) throws Exception {
		for(BookVO b : bookList) {
			if(b.getNo() == book.getNo()) {
				System.out.println("������ �̹� �����մϴ�.");
				return;
			}
		}
		bookList.add(book);
		System.out.println(bookList);
	}
	
	/*
	 * ���� ����
	 */
	public int delete(int bookNo) throws Exception {
		UserService uService = UserServiceFactory.getInstance();
		List<UserVO> uList = uService.findAllMember();
		List<BookVO> uBookList = null;
		
		// �뿩���� ������ ������ ��� uBookList������ �ش� ���� ���� ����
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
		
		
		// bookList���� �ش� ���� ���� ����
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
	// ���� ��ȣ ����
	public void arrangeNo(int no) throws Exception {
		for(BookVO book : bookList) {
			if(book.getNo() > no) {
				book.setNo(book.getNo()-1);
			}
		}
	}
	*/
	
	
	/*
	 * ���� ��ȣ�� �˻�
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
	 * ���� ����� ���ڷ� �˻�
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
	 * ��ü ���� ��� ��ȸ
	 */
	public List<BookVO> findAll() throws Exception {
		if(bookList.size() == 0)
			return null;
		return bookList;
	}
	
}
