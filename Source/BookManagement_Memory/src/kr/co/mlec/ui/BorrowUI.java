package kr.co.mlec.ui;

import kr.co.mlec.vo.BookVO;

public class BorrowUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser != null) { 
			if(!LoginUI.retUser.getId().equals("Manager")) { // 관리자가 아닌 회원으로 로그인한 경우
				int bookNo = scanInt("대여할 도서의 번호를 입력하세요 : ");

				if(bService.getDao().getBookList().size() != 0) {
					uService.insertBook(bService, bookNo, LoginUI.retUser);
					
				}
				else {
					System.out.println("도서가 존재하지 않습니다.");
				}
			}
			else {
				System.out.println("회원 로그인이 필요합니다.");
			}
		}
		else {
			System.out.println("로그인이 필요합니다.");
		}
		
	}
	
}
