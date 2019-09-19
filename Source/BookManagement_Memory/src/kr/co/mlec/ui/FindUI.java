package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.BookVO;

public class FindUI extends BaseUI {
	@Override
	public void execute() throws Exception {
		
		String title = scanStr("검색할 도서의 제목을 입력하세요 : ");
		String author = scanStr("검색할 도서의 저자를 입력하세요 : ");
		
		BookVO findBook = bService.findBook(title, author);
		System.out.println("------------------------------------------");
		System.out.println("\t\t검색한 도서 조회");
		System.out.println("------------------------------------------");
		System.out.println("도서 번호\t제목\t저자\t등록일");
		System.out.println("------------------------------------------");
		if(findBook == null) {
			System.out.println("입력하신 제목의 도서가 존재하지 않습니다.");
		} else {
			System.out.println(findBook.getNo() + "\t" + findBook.getTitle()
						+ "\t" + findBook.getAuthor() + "\t" + findBook.getRegDate());
		}
		System.out.println("------------------------------------------");
		
		
	}

}
