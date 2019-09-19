package kr.co.mlec.ui;

import kr.co.mlec.vo.BookVO;

public class BorrowUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser != null) { 
			if(!LoginUI.retUser.getId().equals("Manager")) { // �����ڰ� �ƴ� ȸ������ �α����� ���
				
				int bookNo = scanInt("�뿩�� ������ ��ȣ�� �Է��ϼ��� : ");
				int ret = uService.insertBook(bookNo, LoginUI.retUser);
				
				if(ret == 1) {
					
					System.out.println("[" + bookNo + "]�� ������ �뿩�Ͽ����ϴ�.");
				}
				else if(ret == -1){
					System.out.println("[" + bookNo + "]�� ������ �������� �ʽ��ϴ�.");
				}
				else if(ret == -2) {
					System.out.println("[" + bookNo + "]�� ������ �뿩���Դϴ�.");
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
