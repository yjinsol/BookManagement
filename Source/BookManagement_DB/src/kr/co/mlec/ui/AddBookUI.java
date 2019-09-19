package kr.co.mlec.ui;

import kr.co.mlec.vo.BookVO;

public class AddBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // �����ڷ� �α��ε� ���
			String title = scanStr("�߰��� ������ ������ �Է��ϼ��� : ");
			String author = scanStr("�߰��� ������ ���ڸ� �Է��ϼ��� : ");
			
			BookVO book = new BookVO(title, author);
			
			bService.insertBook(book);
			System.out.println("[���� : " + title + ", ���� : " + author + "]�� ������ �߰��Ͽ����ϴ�.");
		}
		else {
			System.out.println("������ �α����� �ʿ��մϴ�.");
		}

	}

}
