package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.UserVO;

public class AllMemberUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // �����ڷ� �α��ε� ���
			List<UserVO> memberList = uService.findAllMember();
			
			System.out.println("------------------------------------------");
			System.out.println("\t\t��ü ȸ�� ��� ��ȸ");
			System.out.println("------------------------------------------");
			System.out.println("��ȣ\tID\t��й�ȣ\t�̸�");
			System.out.println("------------------------------------------");
			if(memberList.isEmpty()) {
				System.out.println("��ϵ� ȸ���� �����ϴ�.");
			} else {
				for(UserVO user : memberList) {
					System.out.println(user.getNo() + "\t" + user.getId()
								+ "\t" + user.getPasswd() + "\t" + user.getName());
				}
			}
			System.out.println("------------------------------------------");
		}
		else {
			System.out.println("������ �α����� �ʿ��մϴ�.");
		}

	}

}
