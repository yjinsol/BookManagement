package kr.co.mlec.ui;

import kr.co.mlec.vo.BookVO;

public class BorrowUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser != null) { 
			if(!LoginUI.retUser.getId().equals("Manager")) { // �����ڰ� �ƴ� ȸ������ �α����� ���
				int bookNo = scanInt("�뿩�� ������ ��ȣ�� �Է��ϼ��� : ");

				if(bService.getDao().getBookList().size() != 0) {
					uService.insertBook(bService, bookNo, LoginUI.retUser);
					
				}
				else {
					System.out.println("������ �������� �ʽ��ϴ�.");
				}
			}
			else {
				System.out.println("ȸ�� �α����� �ʿ��մϴ�.");
			}
		}
		else {
			System.out.println("�α����� �ʿ��մϴ�.");
		}
		
	}
	
}
