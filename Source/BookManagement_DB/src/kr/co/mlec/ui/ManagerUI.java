package kr.co.mlec.ui;

public class ManagerUI extends BaseUI {

	private int menu() {
		System.out.println("*** 관리자 메뉴 ***");
		System.out.println("1. 전체 회원 목록");
		System.out.println("2. 회원 검색");
		System.out.println("3. 도서 추가");
		System.out.println("4. 도서 삭제");
		System.out.println("5. 도서 대여 목록");
		System.out.println("0. 관리자 메뉴 종료");
		System.out.println();
		int type = 0;
		try {
			type = scanInt("메뉴를 선택하세요 : ");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return type;
		
	}
	
	@Override
	public void execute() throws Exception {
		while(true) {
			int type = menu();
			System.out.println();
			IBookManageUI ui = null;
			
			try {
				switch (type) {
				case 1:
					ui = new AllMemberUI();
					break;
				case 2:
					ui = new FindMemberUI();
					break;
				case 3:
					ui = new AddBookUI();
					break;
				case 4:
					ui = new DeleteBookUI();
					break;
				case 5:
					ui = new AllRentUI();
					break;
				case 0:
					LoginUI.retUser = null;
					return;
				}
				
				if(ui != null) {
					ui.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
