package kr.co.mlec.ui;

import kr.co.mlec.vo.BookVO;

public class AddBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // 관리자로 로그인된 경우
			String title = scanStr("추가할 도서의 제목을 입력하세요 : ");
			String author = scanStr("추가할 도서의 저자를 입력하세요 : ");
			
			BookVO book = new BookVO(title, author);
			
			bService.insertBook(book);
		}
		else {
			System.out.println("관리자 로그인이 필요합니다.");
		}

	}

}
