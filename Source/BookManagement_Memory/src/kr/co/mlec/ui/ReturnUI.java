package kr.co.mlec.ui;

public class ReturnUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser != null) {
			if(!LoginUI.retUser.getId().equals("Manager")) {  // ȸ������ �α����� ���
				int no = scanInt("�ݳ��� ���� ��ȣ�� �Է��ϼ��� : ");
				
				if(LoginUI.retUser.getuBookList() != null) {
					int ret = uService.deleteBook(no, LoginUI.retUser);
					
					if(ret == -1)
						System.out.println("�Է��Ͻ� ���� ��ȣ�� �������� �ʽ��ϴ�.");
					else
						System.out.println("[" + no + "]�� ������ �ݳ��Ͽ����ϴ�");
				}
				else {
					System.out.println("[" + LoginUI.retUser.getId() + "]�� �뿩 ���� ����� �������� �ʽ��ϴ�.");
				}
			}
			else {
				System.out.println("ȸ�� �α����� �ʿ��մϴ�.");
			}
		} else {
			System.out.println("�α����� �ʿ��մϴ�.");
		}
	}

}
