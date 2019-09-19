package kr.co.mlec.ui;

import kr.co.mlec.vo.UserVO;

public class LoginUI extends BaseUI {

	public static UserVO retUser = null;
	@Override
	public void execute() throws Exception {
		String id = scanStr("ID�� �Է��ϼ��� : ");
		String passwd = scanStr("��й�ȣ�� �Է��ϼ��� : ");
		
		UserVO user = new UserVO(id, passwd, uService.findMember(id).getName());
		LoginUI.retUser = uService.login(user);
		
		if(retUser != null) {
			if(retUser.getId().equals("Manager")) {
				System.out.println("�����ڷ� �α��� �Ǿ����ϴ�.");
				System.out.println();
				System.out.println();
				ManagerUI mng = new ManagerUI();
				mng.execute();
			}
			else {
				System.out.println(id + " �� �α��� �Ǿ����ϴ�.");
			}
		}
		else {
			System.out.println("ȸ�������� �����ϴ�. �α��� �����Ͽ����ϴ�.");
		}
	}

}
