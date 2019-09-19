package kr.co.mlec.ui;

import java.util.List;

import kr.co.mlec.vo.RentVO;

public class AllRentUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		List<RentVO> rList = rService.findAllRent();
		System.out.println("------------------------------------------");
		System.out.println("\t\t도서 목록 조회");
		System.out.println("------------------------------------------");
		System.out.println("회원ID\t도서번호");
		System.out.println("------------------------------------------");
		
		for(RentVO r : rList) {
			System.out.println(r.getId() + "\t" + r.getBookNo());
		}

	}

}
