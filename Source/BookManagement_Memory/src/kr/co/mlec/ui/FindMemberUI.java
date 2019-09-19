package kr.co.mlec.ui;

import kr.co.mlec.vo.UserVO;

public class FindMemberUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // 관리자로 로그인된 경우
			String userId = scanStr("검색할 회원의 ID를 입력하세요 : ");
			
			UserVO user = uService.findMember(userId);
			System.out.println("------------------------------------------");
			System.out.println("\t\t검색한 회원 정보");
			System.out.println("------------------------------------------");
			System.out.println("번호\tID\t비밀번호\t이름\t대여한 도서 목록");
			System.out.println("------------------------------------------");
			if(user == null) {
				System.out.println("입력하신 ID의 회원이 존재하지 않습니다.");
			} else {
				System.out.println(user.getNo() + "\t" + user.getId()
							+ "\t" + user.getPasswd() + "\t" + user.getName() + "\t" + user.getuBookList());
			}
			System.out.println("------------------------------------------");
		}
		else {
			System.out.println("관리자 로그인이 필요합니다.");
		}
	}

}
