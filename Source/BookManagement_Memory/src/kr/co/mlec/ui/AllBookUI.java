package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.BookVO;

public class AllBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<BookVO> bookList = bService.findAllBook();
				
		System.out.println("------------------------------------------");
		System.out.println("\t\t전체 도서 조회");
		System.out.println("------------------------------------------");
		System.out.println("번호\t제목\t저자\t등록일");
		System.out.println("------------------------------------------");
		if(bookList == null) {
			System.out.println("등록된 도서가 없습니다");
		} else {
			for(BookVO book : bookList) {
				System.out.println(book.getNo() + "\t" + book.getTitle()
							+ "\t" + book.getAuthor() + "\t" + book.getRegDate());
			}
		}
		System.out.println("------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		if(LoginUI.retUser != null) { 
			if(!LoginUI.retUser.getId().equals("Manager")) { // 회원으로 로그인한 경우
				
				List<BookVO> uBookList = LoginUI.retUser.getuBookList();
				System.out.println("------------------------------------------");
				System.out.println("\t\t대여한 도서 조회");
				System.out.println("------------------------------------------");
				System.out.println("번호\t제목\t저자\t대여일");
				System.out.println("------------------------------------------");
				if(uBookList == null) {
					System.out.println("[" + LoginUI.retUser.getId() + "]의 대여 목록이 존재하지 않습니다.");
				} 
				else if(uBookList.isEmpty())
					System.out.println("등록된 도서가 없습니다.");
				else {
					for(BookVO book : uBookList) {
						System.out.println(book.getNo() + "\t" + book.getTitle()
									+ "\t" + book.getAuthor() + "\t" + book.getRegDate());
					}
				}
				System.out.println("------------------------------------------");
			}
		}
	}

}
