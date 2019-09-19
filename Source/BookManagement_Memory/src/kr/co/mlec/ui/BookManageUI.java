package kr.co.mlec.ui;

import java.util.Scanner;

public class BookManageUI extends BaseUI {
	private Scanner sc = new Scanner(System.in);

	private int menu() {
		System.out.println("*** 도서 관리 프로그램 ***");
		System.out.println("1. 대여");
		System.out.println("2. 반납");
		System.out.println("3. 회원가입");
		System.out.println("4. 검색");
		System.out.println("5. 로그인");
		System.out.println("6. 전체 도서 목록");
		System.out.println("0. 종료");
		int type = 0;
		try {
			type = scanInt("메뉴를 선택하세요 : ");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return type;
		
	}
	
	@Override
	public void execute() {
		while(true) {

			int type = menu();
			IBookManageUI ui = null;
			try {
				switch (type) {
				case 1:
					ui = new BorrowUI();
					break;
				case 2:
					ui = new ReturnUI();
					break;
				case 3:
					ui = new SignUpUI();
					break;
				case 4:
					ui = new FindUI();
					break;
				case 5:
					ui = new LoginUI();
					break;
				case 6:
					ui = new AllBookUI();
					break;
				case 0:
					ui = new ExitUI();
					break;
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
