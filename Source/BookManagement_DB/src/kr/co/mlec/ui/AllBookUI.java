package kr.co.mlec.ui;

import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.RentVO;

public class AllBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<BookVO> bookList = bService.findAllBook();
				
		System.out.println("-------------------------------------------------------------");
		System.out.println("\t\t전체 도서 조회");
		System.out.println("-------------------------------------------------------------");
		System.out.println("번호\t제목\t저자\t등록일\t\t대여여부\t대여날짜");
		System.out.println("-------------------------------------------------------------");
		if(bookList == null) {
			System.out.println("등록된 도서가 없습니다");
		} else {
			for(BookVO book : bookList) {
				int flag = book.getRentFlag();
				String rFlag = "";
				if(flag == 1)
					rFlag = "대여중";
				else
					rFlag = "대여가능";
				System.out.println(book.getNo() + "\t" + book.getTitle()
				+ "\t" + book.getAuthor() + "\t" + book.getRegDate() + "\t" + rFlag + "\t" + book.getRentDate());
			}
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		if(LoginUI.retUser != null) { 
			if(!LoginUI.retUser.getId().equals("Manager")) { // 회원으로 로그인한 경우
				
				List<RentVO> uRentList = rService.findRent(LoginUI.retUser.getId());
				List<BookVO> uBookList = new ArrayList<>();
				
				if(uRentList.isEmpty()) {
					System.out.println("[" + LoginUI.retUser.getId() + "]의 대여 목록이 존재하지 않습니다.");
				}
				else {
					for(RentVO r : uRentList) {
						uBookList.add(bService.findBook(r.getBookNo()));
					}
					
					
					System.out.println("-------------------------------------------------------------");
					System.out.println("\t\t대여한 도서 조회");
					System.out.println("-------------------------------------------------------------");
					System.out.println("번호\t제목\t저자\t등록일\t\t대여여부\t대여날짜");
					System.out.println("-------------------------------------------------------------");
					
					for(BookVO book : uBookList) {
						int flag = book.getRentFlag();
						String rFlag = "";
						if(flag == 1)
							rFlag = "대여중";
						else
							rFlag = "대여가능";
						System.out.println(book.getNo() + "\t" + book.getTitle()
									+ "\t" + book.getAuthor() + "\t" + book.getRegDate() + "\t" + rFlag + "\t" + book.getRentDate());
					}
				}
				System.out.println("-------------------------------------------------------------");
			}
		}
	}

}
