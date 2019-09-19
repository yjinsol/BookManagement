package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.BookVO;

public class AllBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<BookVO> bookList = bService.findAllBook();
				
		System.out.println("------------------------------------------");
		System.out.println("\t\t��ü ���� ��ȸ");
		System.out.println("------------------------------------------");
		System.out.println("��ȣ\t����\t����\t�����");
		System.out.println("------------------------------------------");
		if(bookList == null) {
			System.out.println("��ϵ� ������ �����ϴ�");
		} else {
			for(BookVO book : bookList) {
				System.out.println(book.getNo() + "\t" + book.getTitle()
							+ "\t" + book.getAuthor() + "\t" + book.getRegDate());
			}
		}
		System.out.println("------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		if(LoginUI.retUser != null) { 
			if(!LoginUI.retUser.getId().equals("Manager")) { // ȸ������ �α����� ���
				
				List<BookVO> uBookList = LoginUI.retUser.getuBookList();
				System.out.println("------------------------------------------");
				System.out.println("\t\t�뿩�� ���� ��ȸ");
				System.out.println("------------------------------------------");
				System.out.println("��ȣ\t����\t����\t�뿩��");
				System.out.println("------------------------------------------");
				if(uBookList == null) {
					System.out.println("[" + LoginUI.retUser.getId() + "]�� �뿩 ����� �������� �ʽ��ϴ�.");
				} 
				else if(uBookList.isEmpty())
					System.out.println("��ϵ� ������ �����ϴ�.");
				else {
					for(BookVO book : uBookList) {
						System.out.println(book.getNo() + "\t" + book.getTitle()
									+ "\t" + book.getAuthor() + "\t" + book.getRegDate());
					}
				}
				System.out.println("------------------------------------------");
			}
		}
	}

}
