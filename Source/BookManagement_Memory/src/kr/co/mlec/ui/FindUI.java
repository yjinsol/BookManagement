package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.BookVO;

public class FindUI extends BaseUI {
	@Override
	public void execute() throws Exception {
		
		String title = scanStr("�˻��� ������ ������ �Է��ϼ��� : ");
		String author = scanStr("�˻��� ������ ���ڸ� �Է��ϼ��� : ");
		
		BookVO findBook = bService.findBook(title, author);
		System.out.println("------------------------------------------");
		System.out.println("\t\t�˻��� ���� ��ȸ");
		System.out.println("------------------------------------------");
		System.out.println("���� ��ȣ\t����\t����\t�����");
		System.out.println("------------------------------------------");
		if(findBook == null) {
			System.out.println("�Է��Ͻ� ������ ������ �������� �ʽ��ϴ�.");
		} else {
			System.out.println(findBook.getNo() + "\t" + findBook.getTitle()
						+ "\t" + findBook.getAuthor() + "\t" + findBook.getRegDate());
		}
		System.out.println("------------------------------------------");
		
		
	}

}
