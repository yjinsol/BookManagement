package kr.co.mlec.ui;

public class ReturnUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser != null) {
			if(!LoginUI.retUser.getId().equals("Manager")) {  // ȸ������ �α����� ���
				int no = scanInt("�ݳ��� ���� ��ȣ�� �Է��ϼ��� : ");
				
				int ret = uService.deleteBook(no, LoginUI.retUser);
					
				if(ret == -1)
					System.out.println("[" + no + "]�� ������ " + "�뿩 ��Ͽ� �������� �ʽ��ϴ�.");
				else if(ret == 1)
					System.out.println("[" + no + "]�� ������ �ݳ��Ͽ����ϴ�");
				else if(ret == -2)
					System.out.println("[" + no + "]�� ������ " + LoginUI.retUser.getId() + "�� �뿩 ��Ͽ� �������� �ʽ��ϴ�.");
			}
			else {
				System.out.println("ȸ�� �α����� �ʿ��մϴ�.");
			}
		} else {
			System.out.println("�α����� �ʿ��մϴ�.");
		}
	}

}
