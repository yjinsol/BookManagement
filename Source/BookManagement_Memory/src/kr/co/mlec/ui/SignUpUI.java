package kr.co.mlec.ui;

import kr.co.mlec.vo.BookVO;
import kr.co.mlec.vo.UserVO;

public class SignUpUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		while(true) {
			String id = scanStr("ID를 입력하세요 : ");
			String passwd = scanStr("비밀번호를 입력하세요 : ");
			String name = scanStr("이름을 입력하세요 : ");
			
			UserVO user = new UserVO(id, passwd, name);
			
			if(uService.insertMember(user)) {
				System.out.println("ID : " + id + ", 비밀번호 : " + passwd + " 가 정상적으로 등록되었습니다.");
				System.out.println(id + " 님의 회원 가입을 축하합니다.");
				break;
			}
			else {
				System.out.println("이미 존재하는 ID입니다. 다시 입력해 주세요.");
			}
		}
		

	}

}
