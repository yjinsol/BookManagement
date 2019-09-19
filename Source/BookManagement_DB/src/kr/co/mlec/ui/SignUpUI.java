package kr.co.mlec.ui;

import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.UserVO;

public class SignUpUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		while(true) {
			String id = scanStr("ID�� �Է��ϼ��� : ");
			String passwd = scanStr("��й�ȣ�� �Է��ϼ��� : ");
			String name = scanStr("�̸��� �Է��ϼ��� : ");
			
			UserVO user = new UserVO(id, passwd, name);
			
			if(uService.insertMember(user)) {
				System.out.println("ID : " + id + ", ��й�ȣ : " + passwd + " �� ���������� ��ϵǾ����ϴ�.");
				System.out.println(id + " ���� ȸ�� ������ �����մϴ�.");
				break;
			}
			else {
				System.out.println("�̹� �����ϴ� ID�Դϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
		

	}

}
