package kr.co.mlec.ui;

public class DeleteBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // 관리자로 로그인된 경우
			int no = scanInt("삭제할 도서의 번호를 입력하세요 : ");
			
			int ret = bService.deleteBook(no);
			
			if(ret == -1)
				System.out.println("입력하신 번호의 도서가 존재하지 않습니다.");
			else
				System.out.println("[" + no + "]번 도서를 삭제하였습니다.");		
		}
		else {
			System.out.println("관리자 로그인이 필요합니다.");
		}

	}

}
