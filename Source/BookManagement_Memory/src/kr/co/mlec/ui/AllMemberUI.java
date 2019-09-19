package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.UserVO;

public class AllMemberUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		if(LoginUI.retUser.getId().equals("Manager")) { // 관리자로 로그인된 경우
			List<UserVO> memberList = uService.findAllMember();
			
			System.out.println("------------------------------------------");
			System.out.println("\t\t전체 회원 목록 조회");
			System.out.println("------------------------------------------");
			System.out.println("번호\tID\t비밀번호\t이름");
			System.out.println("------------------------------------------");
			if(memberList.isEmpty()) {
				System.out.println("등록된 회원이 없습니다.");
			} else {
				for(UserVO user : memberList) {
					System.out.println(user.getNo() + "\t" + user.getId()
								+ "\t" + user.getPasswd() + "\t" + user.getName());
				}
			}
			System.out.println("------------------------------------------");
		}
		else {
			System.out.println("관리자 로그인이 필요합니다.");
		}

	}

}
