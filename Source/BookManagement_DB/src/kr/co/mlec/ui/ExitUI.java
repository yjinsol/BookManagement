package kr.co.mlec.ui;

public class ExitUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("========================================");
		System.out.println("\n\t도서 관리 프로그램 종료합니다\n");
		System.out.println("========================================");
		System.exit(0);

	}

}
