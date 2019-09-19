package kr.co.mlec.ui;

import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.RentVO;
import kr.co.mlec.vo.UserVO;

public class FindMemberUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // �����ڷ� �α��ε� ���
			String userId = scanStr("�˻��� ȸ���� ID�� �Է��ϼ��� : ");
			
			UserVO user = uService.findMember(userId);
			System.out.println("------------------------------------------");
			System.out.println("\t\t�˻��� ȸ�� ����");
			System.out.println("------------------------------------------");
			System.out.println("��ȣ\tID\t��й�ȣ\t�̸�\t�뿩�� ���� ���");
			System.out.println("------------------------------------------");
			if(user == null) {
				System.out.println("------------------------------------------");
				System.out.println("�Է��Ͻ� ID�� ȸ���� �������� �ʽ��ϴ�.");
			} else {
				System.out.print(user.getNo() + "\t" + user.getId()
							+ "\t" + user.getPasswd() + "\t" + user.getName() + "\t");
				
				List<RentVO> uRentList = rService.findRent(userId);
				List<BookVO> uBookList = new ArrayList<>();
				
				if(uRentList.size() == 0) {
					System.out.println("�뿩 ���� ����");
				}
				else {
					for(RentVO r : uRentList) {
						uBookList.add(bService.findBook(r.getBookNo()));
					}
					System.out.println(uBookList);
				}
			}
			System.out.println("------------------------------------------");
		}
		else {
			System.out.println("������ �α����� �ʿ��մϴ�.");
		}
	}

}
