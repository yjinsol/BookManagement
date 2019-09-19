package kr.co.mlec.ui;

public class ManagerUI extends BaseUI {

	private int menu() {
		System.out.println("*** ������ �޴� ***");
		System.out.println("1. ��ü ȸ�� ���");
		System.out.println("2. ȸ�� �˻�");
		System.out.println("3. ���� �߰�");
		System.out.println("4. ���� ����");
		System.out.println("5. ���� �뿩 ���");
		System.out.println("0. ������ �޴� ����");
		System.out.println();
		int type = 0;
		try {
			type = scanInt("�޴��� �����ϼ��� : ");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return type;
		
	}
	
	@Override
	public void execute() throws Exception {
		while(true) {
			int type = menu();
			System.out.println();
			IBookManageUI ui = null;
			
			try {
				switch (type) {
				case 1:
					ui = new AllMemberUI();
					break;
				case 2:
					ui = new FindMemberUI();
					break;
				case 3:
					ui = new AddBookUI();
					break;
				case 4:
					ui = new DeleteBookUI();
					break;
				case 5:
					ui = new AllRentUI();
					break;
				case 0:
					LoginUI.retUser = null;
					return;
				}
				
				if(ui != null) {
					ui.execute();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
