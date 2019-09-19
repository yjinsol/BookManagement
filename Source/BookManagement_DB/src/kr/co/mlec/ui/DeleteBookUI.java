package kr.co.mlec.ui;

public class DeleteBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // �����ڷ� �α��ε� ���
			int no = scanInt("������ ������ ��ȣ�� �Է��ϼ��� : ");
			
			int ret = bService.deleteBook(no);
			
			if(ret == -1)
				System.out.println("�Է��Ͻ� ��ȣ�� ������ �������� �ʽ��ϴ�.");
			else
				System.out.println("[" + no + "]�� ������ �����Ͽ����ϴ�.");		
		}
		else {
			System.out.println("������ �α����� �ʿ��մϴ�.");
		}

	}

}
