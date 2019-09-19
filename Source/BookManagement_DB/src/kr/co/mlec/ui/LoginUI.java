package kr.co.mlec.ui;

import kr.co.mlec.vo.UserVO;

public class LoginUI extends BaseUI {

	public static UserVO retUser = null;
	@Override
	public void execute() throws Exception {
		String id = scanStr("ID를 입력하세요 : ");
		String passwd = scanStr("비밀번호를 입력하세요 : ");
		
		UserVO user = new UserVO(id, passwd, uService.findMember(id).getName());
		LoginUI.retUser = uService.login(user);
		
		if(retUser != null) {
			if(retUser.getId().equals("Manager")) {
				System.out.println("관리자로 로그인 되었습니다.");
				System.out.println();
				System.out.println();
				ManagerUI mng = new ManagerUI();
				mng.execute();
			}
			else {
				System.out.println(id + " 님 로그인 되었습니다.");
			}
		}
		else {
			System.out.println("회원정보가 없습니다. 로그인 실패하였습니다.");
		}
	}

}
