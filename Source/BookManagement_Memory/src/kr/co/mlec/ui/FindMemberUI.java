package kr.co.mlec.ui;

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
				System.out.println("�Է��Ͻ� ID�� ȸ���� �������� �ʽ��ϴ�.");
			} else {
				System.out.println(user.getNo() + "\t" + user.getId()
							+ "\t" + user.getPasswd() + "\t" + user.getName() + "\t" + user.getuBookList());
			}
			System.out.println("------------------------------------------");
		}
		else {
			System.out.println("������ �α����� �ʿ��մϴ�.");
		}
	}

}
