package kr.co.mlec.ui;

public class ReturnUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser != null) {
			if(!LoginUI.retUser.getId().equals("Manager")) {  // 회원으로 로그인한 경우
				int no = scanInt("반납할 도서 번호를 입력하세요 : ");
				
				if(LoginUI.retUser.getuBookList() != null) {
					int ret = uService.deleteBook(no, LoginUI.retUser);
					
					if(ret == -1)
						System.out.println("입력하신 도서 번호가 존재하지 않습니다.");
					else
						System.out.println("[" + no + "]번 도서를 반납하였습니다");
				}
				else {
					System.out.println("[" + LoginUI.retUser.getId() + "]의 대여 도서 목록이 존재하지 않습니다.");
				}
			}
			else {
				System.out.println("회원 로그인이 필요합니다.");
			}
		} else {
			System.out.println("로그인이 필요합니다.");
		}
	}

}
