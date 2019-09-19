package kr.co.mlec.ui;

import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.RentVO;

public class AllBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<BookVO> bookList = bService.findAllBook();
				
		System.out.println("-------------------------------------------------------------");
		System.out.println("\t\t��ü ���� ��ȸ");
		System.out.println("-------------------------------------------------------------");
		System.out.println("��ȣ\t����\t����\t�����\t\t�뿩����\t�뿩��¥");
		System.out.println("-------------------------------------------------------------");
		if(bookList == null) {
			System.out.println("��ϵ� ������ �����ϴ�");
		} else {
			for(BookVO book : bookList) {
				int flag = book.getRentFlag();
				String rFlag = "";
				if(flag == 1)
					rFlag = "�뿩��";
				else
					rFlag = "�뿩����";
				System.out.println(book.getNo() + "\t" + book.getTitle()
				+ "\t" + book.getAuthor() + "\t" + book.getRegDate() + "\t" + rFlag + "\t" + book.getRentDate());
			}
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		if(LoginUI.retUser != null) { 
			if(!LoginUI.retUser.getId().equals("Manager")) { // ȸ������ �α����� ���
				
				List<RentVO> uRentList = rService.findRent(LoginUI.retUser.getId());
				List<BookVO> uBookList = new ArrayList<>();
				
				if(uRentList.isEmpty()) {
					System.out.println("[" + LoginUI.retUser.getId() + "]�� �뿩 ����� �������� �ʽ��ϴ�.");
				}
				else {
					for(RentVO r : uRentList) {
						uBookList.add(bService.findBook(r.getBookNo()));
					}
					
					
					System.out.println("-------------------------------------------------------------");
					System.out.println("\t\t�뿩�� ���� ��ȸ");
					System.out.println("-------------------------------------------------------------");
					System.out.println("��ȣ\t����\t����\t�����\t\t�뿩����\t�뿩��¥");
					System.out.println("-------------------------------------------------------------");
					
					for(BookVO book : uBookList) {
						int flag = book.getRentFlag();
						String rFlag = "";
						if(flag == 1)
							rFlag = "�뿩��";
						else
							rFlag = "�뿩����";
						System.out.println(book.getNo() + "\t" + book.getTitle()
									+ "\t" + book.getAuthor() + "\t" + book.getRegDate() + "\t" + rFlag + "\t" + book.getRentDate());
					}
				}
				System.out.println("-------------------------------------------------------------");
			}
		}
	}

}
